package com.erookies.add.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.int2String
import com.erookies.add.viewmodel.AddGroupViewModel
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.extentions.setAvatar
import com.erookies.lib_common.extentions.toast
import com.erookies.lib_common.extentions.visible
import kotlinx.android.synthetic.main.add_activity_add_detail.*

class AddDetailActivity : BaseActivity() {

    private lateinit var entry : AddEntry
    private val addGroupViewModel: AddGroupViewModel by lazy(LazyThreadSafetyMode.NONE) {
        getViewModel(AddGroupViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_add_detail)

        common_toolbar.init("拼单详情")

        entry = intent.getParcelableExtra("entry")
        val curUser = entry.user ?: User()

        civ_detail_avatar.setAvatar(entry.user?.avatar ?: "")
        tv_detail_type.text = int2String(entry.tag)
        tv_detail_address.text = "约定地点：${entry.content}"
        tv_detail_nickname.text = curUser.nickname
        tv_detail_time.text = "约定时间：${entry.time}"
        tv_detail_description.text = entry.info

        tv_group_num.apply {
            text = "拼团情况：${entry.others.size} / ${entry.number}"
        }

        if (curUser.stuNum != BaseApp.user?.stuNum) {
            addGroupViewModel.statusCode.observe {
                when (it) {
                    0 -> {
                        toast("加入成功～")
                        tv_group_num.apply {
                            text = "拼团情况：${entry.others.size + 1} / ${entry.number}"
                        }
                    }
                    1 -> toast("不要重复加入～")
                    2 -> toast("人数已满～")
                    3 -> toast("没有登陆哟，登陆后再进行尝试")
                }
            }
            add_btn_add.apply {
                visible()
                setOnClickListener {
                    addGroupViewModel.addGroup(BaseApp.user?.stuNum ?: "", entry.id)
                }
            }
        }
    }
}
