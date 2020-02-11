package debug

import android.content.Context
import cn.jpush.im.android.api.JMessageClient
import com.erookies.lib_common.BaseApp

class MainDebugApplication : BaseApp() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        initJIM()
    }

    private fun initJIM(){
        JMessageClient.init(context)
    }
}