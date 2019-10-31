package com.erookies.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.erookies.lib_common.base.BaseActivity
import com.erookies.main.R

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_register)

        common_toolbar.init("注册")

        showFragment(RegisterContainerFragment.newInstance(R.layout.main_fragment_stu))
    }

    fun showFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()  //开启事务
        transaction.replace(R.id.fl_container, fragment).setTransition(TRANSIT_FRAGMENT_FADE)
        transaction.commit()//提交事务
    }
}
