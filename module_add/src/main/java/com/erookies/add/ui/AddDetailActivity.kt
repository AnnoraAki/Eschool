package com.erookies.add.ui

import android.os.Bundle
import com.erookies.add.R
import com.erookies.lib_common.base.BaseActivity

class AddDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_add_detail)

        common_toolbar.init("拼单详情")

    }
}
