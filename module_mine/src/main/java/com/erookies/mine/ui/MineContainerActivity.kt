package com.erookies.mine.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.SCHOOL_DETAIL_LOST_FOUND
import com.erookies.lib_common.config.SCHOOL_LOST_FOUND
import com.erookies.lib_common.config.SCHOOL_SEARCH_PEOPLE
import com.erookies.lib_common.config.START_FROM_USER
import com.erookies.mine.R

class MineContainerActivity : BaseActivity() {

    companion object {
        const val TAG_LOST = 10
        const val TAG_PEOPLE = 15
        const val TAG_NAME = "type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_mine_container)

        val fragment = when (intent.getIntExtra(TAG_NAME,-1)) {
            TAG_LOST -> {
                common_toolbar.init("我的失物招领")
                ARouter.getInstance().build(SCHOOL_DETAIL_LOST_FOUND).withInt("from",START_FROM_USER).navigation() as Fragment
            }
            TAG_PEOPLE -> {
                common_toolbar.init("我的寻人")
                ARouter.getInstance().build(SCHOOL_SEARCH_PEOPLE).withInt("start_type", START_FROM_USER).navigation() as Fragment
            }
            else -> null
        }

        fragment ?: return
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_mine_container, fragment)
        transaction.commit()
    }
}
