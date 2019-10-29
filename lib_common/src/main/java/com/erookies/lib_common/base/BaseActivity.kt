package com.erookies.lib_common.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.erookies.lib_common.R
import com.erookies.lib_common.event.LoginEvent
import com.erookies.lib_common.utils.LogUtils
import kotlinx.android.synthetic.main.common_toolbar.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
abstract class BaseActivity : AppCompatActivity() {

    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

    val common_toolbar
        get() = toolbar

    var menu: Menu? = null
        private set

    protected fun Toolbar.init(
        title: String,
        @DrawableRes icon: Int = R.drawable.common_ic_back,
        listener: View.OnClickListener? = View.OnClickListener { finish() }
    ) {
        tv_title.text = title
        this.title = ""
        setSupportActionBar(this)
        if (listener == null) {
            navigationIcon = null
        } else {
            setNavigationIcon(icon)
            setNavigationOnClickListener(listener)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
//            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
        LogUtils.d("${javaClass.simpleName} on Create", TAG)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
        LogUtils.d("${javaClass.simpleName} on Stop", TAG)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val r = super.onPrepareOptionsMenu(menu)
        this.menu = menu
        return r
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onLoginStateChanged(event: LoginEvent) {
        LogUtils.d("new state:${event.state},current class:$localClassName")
    }

    protected fun <T : BaseViewModel> getViewmodel(clazz: Class<T>): T {
        val factory = getFactory()
        return if (factory == null) {
            ViewModelProviders.of(this).get(clazz)
        } else {
            ViewModelProviders.of(this, factory).get(clazz)
        }
    }

    protected open fun getFactory(): ViewModelProvider.Factory? = null
}