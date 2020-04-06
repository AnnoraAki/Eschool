package com.erookies.module_im.ui.activity.conversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SingleConversationFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SingleConversationViewModel() as T
    }
}