package com.erookies.add.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.add.R
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.ADD_OWN

@Route(path = ADD_OWN)
class AddOwnActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity_add_own)

        common_toolbar.init("我的拼单")

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = AddEntryFragment.newInstance("",true)
        transaction.add(R.id.fl_container, fragment)
        transaction.commit()
    }
}
