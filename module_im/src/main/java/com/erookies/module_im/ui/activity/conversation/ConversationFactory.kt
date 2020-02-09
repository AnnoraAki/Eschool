package com.erookies.module_im.ui.activity.conversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ConversationFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ConversationViewModel() as T
    }
}