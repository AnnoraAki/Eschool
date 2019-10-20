package com.erookies.school.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erookies.lib_common.base.BaseActivity
import com.erookies.school.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.school_activity_main)
    }
}
