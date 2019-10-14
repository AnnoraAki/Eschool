package com.erookies.main

import android.os.Bundle
import com.erookies.lib_common.base.BaseActivity
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        common_toolbar.init("你好啊", listener = null)

        nav_main.apply {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        }

    }
}
