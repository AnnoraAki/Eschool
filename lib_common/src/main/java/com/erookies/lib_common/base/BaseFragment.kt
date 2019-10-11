package com.erookies.lib_common.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.greenrobot.eventbus.EventBus

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