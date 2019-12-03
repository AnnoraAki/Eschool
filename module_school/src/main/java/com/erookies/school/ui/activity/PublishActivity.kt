package com.erookies.school.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.BaseApp.Companion.context
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.lib_common.extentions.getRequestBody
import com.erookies.lib_common.extentions.gone
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.extentions.visible
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.R
import com.erookies.school.network.Api
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import com.wildma.pictureselector.PictureSelector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.school_activity_publish.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

@Route(path = SCHOOL_PUBLISH)
class PublishActivity : BaseActivity(),View.OnClickListener {

    private var bigTag = 1
    private var smallTag = 4
    private var content = ""
    private var picturesForLoad = mutableListOf<String>()
    private val userNo:String? by lazy { BaseApp.user?.stuNum.toString() }

    private val adapter = CommonPicRVAdapter(picturesForLoad)

    private val optionsItem1 = mutableListOf<String>()
    private val optionsItem2 = mutableListOf<String>()

    private val optionsList:MutableList<MutableList<String>> = mutableListOf()

    //初始化条件列表选择器
    private val optionPickView by lazy {
        OptionsPickerBuilder(this,
            OnOptionsSelectListener { options1, options2, options3, v ->
                bigTag = options1
                if (options1 == 0){
                    option_type_text.text = optionsItem1[0]
                    smallTag = 0
                }else{
                    option_type_text.text = optionsList[1][options2]
                    smallTag = options2
                }
            }).build<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.school_activity_publish)

        ARouter.getInstance().inject(this)

        common_toolbar.init("发布信息")

        init()
    }

    private fun init(){
        publish_loading_dialog.indeterminateDrawable.setColorFilter(ContextCompat.getColor(context,R.color.themeBlue),PorterDuff.Mode.MULTIPLY)
        changeLoadingDialogStatus(false)

        optionsItem1.add("寻人")
        optionsItem1.add("失物招领")

        optionsItem2.add("校卡/身份证")
        optionsItem2.add("数码")
        optionsItem2.add("生活用品")
        optionsItem2.add("其他")

        optionsList.add(mutableListOf())
        optionsList.add(optionsItem2)

        optionPickView.setPicker(optionsItem1,optionsList)
        optionPickView.setTitleText("选择类型")

        option_type_text.text = optionsList[bigTag][smallTag-1]

        option_div.setOnClickListener(this)
        option_select_button.setOnClickListener(this)
        option_type_text.setOnClickListener(this)
        publish_info.setOnClickListener(this)

        publish_add_picture_button.setOnClickListener(this)

        publish_pictures.layoutManager = GridLayoutManager(this,3)
        publish_pictures.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_div,
            R.id.option_type_text,
            R.id.option_select_button -> {
                optionPickView.show()
            }

            R.id.publish_add_picture_button -> {
                Log.d("PublishActivity","start to select picture")
                if (picturesForLoad.size < 2){
                    PictureSelector.create(this,PictureSelector.SELECT_REQUEST_CODE).selectPicture()
                }else{
                    toast("已选择3张照片")
                }
            }
            R.id.publish_info -> {
                changeLoadingDialogStatus(true)
                upload(picturesForLoad[0])
                changeLoadingDialogStatus(false)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            val path = data?.getStringExtra(PictureSelector.PICTURE_PATH)
            path ?: return
            Log.d("PublishActivityInfo",path)
            picturesForLoad.add(path)
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("CheckResult")
    private fun upload(fileName:String?){
        val sno = BaseApp.user?.stuNum
        val file = File(fileName)
        val filePart = MultipartBody.Part.createFormData("file",file.name,file.getRequestBody())
        val body = (sno ?: "0").toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val observable = ApiGenerator.getApiService(Api::class.java).uploadInfo(filePart,body)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({wrapper->
                if (wrapper.code == 0){
                    Log.d("PublishActivityInfo",wrapper.msg)
                    toast("上传成功")
                }else{
                    Log.d("PublishActivityInfo",wrapper.msg)
                    toast("上传失败")
                }
            },{err->
                toast(err.message.toString())
                Log.d("PublishActivityInfo",err.message.toString())
            })
    }

    private fun changeLoadingDialogStatus(show:Boolean){
        if (show){
            publish_loading_dialog.contentDescription = "正在上传..."
            publish_loading_dialog.show()
        }else{
            publish_loading_dialog.hide()
        }
    }
}
