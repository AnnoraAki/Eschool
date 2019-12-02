package com.erookies.school.ui.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseActivity
import com.erookies.school.R
import com.erookies.school.ui.fragment.SchoolPageContainerFragment
import kotlinx.android.synthetic.main.school_activity_main.*

class MainActivity : BaseActivity() {
    private val container:FrameLayout
        get() = school_page_container

    private val manager:FragmentManager
        get() = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.school_activity_main)
        ARouter.getInstance().inject(this)

        common_toolbar.init("e校",listener = null)

        manager.commit {
            add(R.id.school_page_container,SchoolPageContainerFragment(),SchoolPageContainerFragment::class.java.name)
        }
    }
}
