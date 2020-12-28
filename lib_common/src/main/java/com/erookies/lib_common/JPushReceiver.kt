package com.erookies.lib_common

import android.content.Context
import android.util.Log
import android.widget.Toast
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.JPushMessage
import cn.jpush.android.service.JPushMessageReceiver

class JPushReceiver : JPushMessageReceiver() {
    override fun onAliasOperatorResult(context: Context?, msg: JPushMessage?) {
        super.onAliasOperatorResult(context, msg)
        context ?: return
        msg ?: return
        if (msg.errorCode == 0) {
            Log.d(TAG, "onAliasOperatorResult: 设置alias成功 ${msg?.alias}")
            return
        }
        if (msg.sequence == JPUSH_SEQUENCE && context != null && BaseApp.isLogin) {
            Log.d(TAG, "onAliasOperatorResult: ${msg.errorCode}设置alias失败")
            JPushInterface.setAlias(context, JPUSH_SEQUENCE, BaseApp.user?.stuNum+"#")
        }
    }
}