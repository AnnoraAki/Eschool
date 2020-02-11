package com.erookies.module_im.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erookies.lib_common.base.BaseActivity
import com.erookies.module_im.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.im_activity_main)
    }
}
