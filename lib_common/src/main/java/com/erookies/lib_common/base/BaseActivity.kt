package com.erookies.lib_common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.erookies.lib_common.utils.LogUtils
import org.greenrobot.eventbus.EventBus

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
abstract class BaseActivity : AppCompatActivity() {

    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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