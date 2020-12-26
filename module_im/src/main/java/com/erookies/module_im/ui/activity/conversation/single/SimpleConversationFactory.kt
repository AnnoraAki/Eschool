package com.erookies.module_im.ui.activity.conversation.single

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SimpleConversationFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SimpleConversationViewModel() as T
    }
}