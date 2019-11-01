package com.erookies.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.ADD_ENTRY
import com.erookies.lib_common.config.MINE_ENTRY
import com.erookies.lib_common.config.SCHOOL_ENTRY
import com.erookies.main.OnPageChangedListener
import com.erookies.main.R
import com.erookies.main.ui.adapter.ViewPagerAdapter
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.main_activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private val fragments = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        initFragment()
        initNavigation()
    }

    private fun initFragment() {
        fragments.add(getFragment(ADD_ENTRY))
        fragments.add(getFragment(SCHOOL_ENTRY))
        fragments.add(getFragment(MINE_ENTRY))
    }

    private fun initNavigation() {
        val pageListener = OnPageChangedListener(nav_main, vp_main) { _, item ->
            common_toolbar.init(item.title.toString(), listener = null)
        }

        nav_main.apply {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener(pageListener)
            selectedItemId = menu.getItem(0).itemId
        }
        vp_main.apply {
            adapter = ViewPagerAdapter(fragments, supportFragmentManager)
            offscreenPageLimit = 4
            addOnPageChangeListener(pageListener)
        }

    }

    private fun getFragment(path: String) =
        ARouter.getInstance().build(path).navigation() as Fragment
}
