package com.erookies.lib_common.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.erookies.lib_common.event.LoginEvent
import com.erookies.lib_common.utils.LogUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onLoginStateChanged(event: LoginEvent) {
        LogUtils.d("new state:${event.state},current class:${javaClass.simpleName}")
    }

    protected fun <T : BaseViewModel> getViewModel(clazz: Class<T>): T {
        val factory = getFactory()
        return if (factory == null) {
            ViewModelProviders.of(this).get(clazz)
        } else {
            ViewModelProviders.of(this, factory).get(clazz)
        }
    }

    protected open fun getFactory(): ViewModelProvider.Factory? = null

    inline fun <T> LiveData<T>.observe(crossinline event: (T) -> Unit) =
        this.observe(this@BaseFragment, Observer {
            event.invoke(it)
        })

}