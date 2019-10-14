package com.erookies.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erookies.lib_common.base.BaseActivity
import com.tencent.bugly.Bugly
import com.tencent.bugly.crashreport.CrashReport
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        common_toolbar.init("你好啊",listener = null)

        btn.setOnClickListener {
            CrashReport.testJavaCrash()
        }
    }
}
