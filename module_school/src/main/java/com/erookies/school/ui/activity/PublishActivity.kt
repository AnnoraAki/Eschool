package com.erookies.school.ui.activity

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.school.R
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import com.erookies.school.utils.ConfiguratePictureSelector
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.permissions.PermissionChecker
import com.luck.picture.lib.tools.PictureFileUtils
import kotlinx.android.synthetic.main.school_activity_publish.*
import kotlinx.android.synthetic.main.school_common_picture_list.*
import java.io.File

@Route(path = SCHOOL_PUBLISH)
class PublishActivity : BaseActivity(),View.OnClickListener {

    private var bigTag = 1
    private var smallTag = 4
    private var content = ""
    private var picturesForLoad = mutableListOf<String>()
    private var picturesForUpload = mutableListOf<String>()
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

        option_div.setOnClickListener(this)
        option_select_button.setOnClickListener(this)
        option_type_text.setOnClickListener(this)

        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //PictureFileUtils.deleteCacheDirFile(this, PictureMimeType.ofImage());
            PictureFileUtils.deleteCacheDirFile(this,PictureMimeType.ofImage())
        } else {
            PermissionChecker.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PictureConfig.APPLY_STORAGE_PERMISSIONS_CODE)
        }

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
                ConfiguratePictureSelector(this)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK){
            when(requestCode){
                PictureConfig.CHOOSE_REQUEST -> {
                    val selectList = PictureSelector.obtainMultipleResult(data)
                    var originalFile:File
                    var compressFile:File
                    for (selector in selectList){
                        Log.d("PublishActivityInfo",selector.compressPath)
                        Log.d("PublishActivityInfo",selector.path)

                        if (picturesForUpload.contains(selector.path)){
                            picturesForUpload.remove(selector.path)
                            picturesForLoad.remove(selector.compressPath)
                        }

                        picturesForLoad.add(selector.compressPath)
                        picturesForUpload.add(selector.path)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
