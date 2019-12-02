package com.erookies.add.ui

import android.os.Bundle
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.view.OptionsPickerView
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.viewmodel.AddViewModel
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.toast
import kotlinx.android.synthetic.main.add_activity_add.*


class AddActivity : BaseActivity() {

    private val typeList = arrayListOf(
        AddEntry.CAR,
        AddEntry.MOVIE,
        AddEntry.EAT,
        AddEntry.GAME,
        AddEntry.SING,
        AddEntry.OTHER
    )

    private val pickerView: OptionsPickerView<String> by lazy(LazyThreadSafetyMode.NONE) {
        OptionsPickerBuilder(this,
            OnOptionsSelectListener { one, _, _, _ ->
                tv_type.text = typeList[one]
            })
            .setSubmitText("确定")
            .setCancelText("取消")
            .setSubmitColor(R.color.themeYellow)
            .setCancelColor(R.color.themeYellow)
            .build<String>().apply {
                setPicker(typeList)
            }
    }

    private val viewModel by lazy { getViewModel(AddViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_add)

        common_toolbar.init("发布我的拼单")

        viewModel.statusData.observe {
            when (it) {
                AddViewModel.SUCCEED -> {
                    toast("上传成功")
                    finish()
                }
                AddViewModel.FAILED -> {
                    toast("上传失败")
                }
                AddViewModel.MISS_INFORMATION -> {
                    toast("上传信息不完整哦～")
                }
            }
        }

        rl_type_pick.setOnClickListener {
            pickerView.show()
        }

        mb_sure.setOnClickListener {
            viewModel.check(
                tv_type.text.toString(),
                tip_add_address.text.toString(),
                et_descriptions.text.toString(),
                if (tip_add_people.text.toString() == "") 0 else tip_add_people.text.toString().toInt(),
                tip_add_time.text.toString()
            )
        }
    }

}
