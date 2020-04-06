package com.erookies.lib_common

import com.erookies.lib_common.event.IMEvent

interface IStartConversation {
    fun sendEvent(event:IMEvent)
}