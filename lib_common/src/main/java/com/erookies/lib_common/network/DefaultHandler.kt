package com.erookies.lib_common.network

import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.BuildConfig
import com.erookies.lib_common.extentions.toast

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
object DefaultHandler {
    fun handler(e: Throwable?): Boolean {
        when (e) {
            null -> if (BuildConfig.DEBUG) BaseApp.context.toast("throwable should not be null") else BaseApp.context.toast(
                "未知错误"
            )
            else -> if (BuildConfig.DEBUG) BaseApp.context.toast(e.toString()) else BaseApp.context.toast(
                "服务暂时不可用"
            )
        }
        return true
    }
}