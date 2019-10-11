package com.erookies.lib_common.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
open class BaseViewModel : ViewModel() {
    private val disposables: MutableList<Disposable> = mutableListOf()

    fun Disposable.lifeCycle(): Disposable {
        disposables.add(this)
        return this@lifeCycle
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposeAll()
    }

    private fun disposeAll() {
        disposables.asSequence()
            .filterNot { it.isDisposed }
            .forEach { it.dispose() }
        disposables.clear()
    }
}