package com.erookies.school.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.school.R
import kotlinx.android.synthetic.main.school_activity_publish.*

@Route(path = SCHOOL_PUBLISH)
class PublishActivity : BaseActivity(),View.OnClickListener {

    private var bigTag = 1
    private var smallTag = 4
    private var content = ""
    private var pictures = mutableListOf<Bitmap>()
    private val userNo:String? by lazy { BaseApp.user?.stuNum.toString() }

    private var picNum = 0

    private val optionsItem1 = mutableListOf<String>()
    private val optionsItem2 = mutableListOf<String>()

    private val optionsList:MutableList<MutableList<String>> = mutableListOf()

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
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_div,
            R.id.option_type_text,
            R.id.option_select_button -> {
                optionPickView.show()
            }
        }
    }
}
