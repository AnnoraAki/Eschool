package com.erookies.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.*
import com.erookies.lib_common.event.ClickMenuEvent
import com.erookies.lib_common.extentions.defaultSharedPreferences
import com.erookies.lib_common.utils.LogUtils
import com.erookies.main.OnPageChangedListener
import com.erookies.main.R
import com.erookies.main.ui.adapter.ViewPagerAdapter
import com.erookies.main.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.main_activity_main.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class MainActivity : BaseActivity() {

    private val fragments = ArrayList<Fragment>()
    private val viewModel : LoginViewModel by lazy (LazyThreadSafetyMode.NONE) { getViewModel(LoginViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        val isFirstIn = defaultSharedPreferences.getBoolean(FIRST_IN, true)

        if (isFirstIn) {
            ARouter.getInstance().build(MINE_LOGIN).navigation()
        } else {
            viewModel.login(BaseApp.user?.stuNum ?: "",BaseApp.user?.pwd ?: "")
        }

        initFragment()
        initNavigation()
    }

    private fun initFragment() {
        fragments.add(getFragment(ADD_ENTRY))
        fragments.add(getFragment(SCHOOL_ENTRY))
        //增加IM模块
        fragments.add(getFragment(IM_ENTRY))
        fragments.add(getFragment(MINE_ENTRY))
    }

    private fun initNavigation() {
        val pageListener = OnPageChangedListener(nav_main, vp_main) { position, item ->
            if (position != 3) {
                val listener = View.OnClickListener {
                    postClickMenuEvent(position)
                }
                common_toolbar.init(
                    item.title.toString(),
                    listener = null,
                    rightListener = listener
                )
            } else {
                common_toolbar.init(item.title.toString(), listener = null)
            }

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

    private fun postClickMenuEvent(position: Int) {
        EventBus.getDefault().post(ClickMenuEvent(position))
    }

    private fun getFragment(path: String) =
        ARouter.getInstance().build(path).navigation() as Fragment
}
