package com.erookies.lib_common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Process
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy



/**
 * Create by Cchanges.
 * Time: 2019-09-29
 */
open class BaseApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
            private set
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
    }

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initBugly()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun initBugly() {
        val context = applicationContext
        val packageName = context.packageName
        val processName = com.erookies.lib_common.utils.getProcessName(Process.myPid())
        val strategy = UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(applicationContext, "869328ad4b", false)
    }
}