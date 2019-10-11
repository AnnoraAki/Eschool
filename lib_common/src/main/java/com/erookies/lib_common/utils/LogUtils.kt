package com.erookies.lib_common.utils

import android.util.Log
import com.erookies.lib_common.BuildConfig
import kotlin.experimental.and

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */

object LogUtils {
    private val debugMode = BuildConfig.DEBUG
    private var showLog: Byte
    private const val TAG = "Eschool"

    private const val VERBOSE_MASK: Byte = 0x1
    private const val DEBUG_MASK: Byte = 0x2
    private const val INFO_MASK: Byte = 0x4
    private const val WARN_MASK: Byte = 0x8
    private const val ERROR_MASK: Byte = 0x10

    init {
        showLog = if (debugMode) 0x1F else 0x10
    }

    fun v(msg: String, tag: String = TAG, throwable: Throwable? = null) {
        if (showLog and VERBOSE_MASK == VERBOSE_MASK) Log.v(tag, msg, throwable)
    }

    fun d(msg: String, tag: String = TAG, throwable: Throwable? = null) {
        if (showLog and DEBUG_MASK == DEBUG_MASK) Log.d(tag, msg, throwable)
    }

    fun i(msg: String, tag: String = TAG, throwable: Throwable? = null) {
        if (showLog and INFO_MASK == INFO_MASK) Log.i(tag, msg, throwable)
    }

    fun w(msg: String, tag: String = TAG, throwable: Throwable? = null) {
        if (showLog and WARN_MASK == WARN_MASK) Log.w(tag, msg, throwable)
    }

    fun e(msg: String, tag: String = TAG, throwable: Throwable? = null) {
        if (showLog and ERROR_MASK == ERROR_MASK) Log.e(tag, msg, throwable)
    }
}