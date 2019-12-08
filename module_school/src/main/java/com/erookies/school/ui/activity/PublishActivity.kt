package com.erookies.school.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import com.luck.picture.lib.PictureSelector
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.BaseApp.Companion.context
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.lib_common.extentions.getRequestBody
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.R
import com.erookies.school.network.Api
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import com.erookies.school.utils.ConfigurePictureSelect
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.entity.LocalMedia
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.school_activity_publish.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Multipart
import java.io.File

@Route(path = SCHOOL_PUBLISH)
class PublishActivity : BaseActivity(),View.OnClickListener {

    private var bigTag = 1
    private var smallTag = 4
    private var content = ""
    private val selectedPicture = mutableListOf<LocalMedia>()
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
                    smallTag = options2+1
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
                ConfigurePictureSelect(this,selectedPicture)
            }
            R.id.publish_info -> {
                content = publish_detail_describe_input.text.toString()
                if (content.isEmpty()){
                    toast("请简单填写必要的介绍")
                }else{
                    changeLoadingDialogStatus(true)
                    upload(picturesForLoad)
                    changeLoadingDialogStatus(false)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                PictureConfig.CHOOSE_REQUEST -> {
                    picturesForLoad.clear()
                    val selectors = PictureSelector.obtainMultipleResult(data)
                    selectedPicture.clear()
                    selectedPicture.addAll(selectors)
                    if (selectedPicture.isNotEmpty()){
                        for (media in selectedPicture){
                            if (media.isOriginal){
                                picturesForLoad.add(media.originalPath)
                            }else{
                                picturesForLoad.add(media.compressPath)
                            }
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun upload(fileNames:List<String>?){
        Log.d("PublishActivityInfo",userNo)
        Log.d("PublishActivityInfo",fileNames.toString())
        val files = mutableListOf<MultipartBody.Part>()
        val map = hashMapOf<String,RequestBody>(
            "bigtag" to bigTag.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull()),
            "smalltag" to smallTag.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull()),
            "sno" to userNo.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull()),
            "info" to content.toRequestBody("multipart/form-data".toMediaTypeOrNull()),
            "num" to (picturesForLoad.size).toString().toRequestBody("multipart/form-data".toMediaTypeOrNull())
        )
        var file:File
        var filePart:MultipartBody.Part
        var index = 1
        for (url in picturesForLoad){
            file = File(url)
            filePart = MultipartBody.Part.createFormData("file${index}",file.name,file.getRequestBody())
            files.add(filePart)
            index++
        }

        val observable = ApiGenerator.getApiService(Api::class.java).uploadInfo(files,map)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({wrapper->
                if (wrapper.code == 0){
                    Log.d("PublishActivityInfo",wrapper.msg)
                    Toast.makeText(this,"上传成功",Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Log.d("PublishActivityInfo",wrapper.msg)
                    Toast.makeText(this,"上传失败",Toast.LENGTH_SHORT).show()
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
