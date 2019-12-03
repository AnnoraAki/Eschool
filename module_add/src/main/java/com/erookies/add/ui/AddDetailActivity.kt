package com.erookies.add.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.int2String
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.setAvatar
import com.erookies.lib_common.extentions.setImageFromUrl
import kotlinx.android.synthetic.main.add_activity_add_detail.*

class AddDetailActivity : BaseActivity() {

    private lateinit var entry : AddEntry

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_add_detail)

        common_toolbar.init("拼单详情")

        entry = intent.getParcelableExtra("entry")

        civ_detail_avatar.setAvatar(entry.user?.avatar ?: "")
        tv_detail_type.text = int2String(entry.tag)
        tv_detail_address.text = "约定地点：${entry.content}"
        tv_detail_nickname.text = entry.user?.nickname ?: ""
        tv_detail_time.text = "约定时间：${entry.time}"
        tv_detail_description.text = entry.info
    }
}
