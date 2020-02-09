package com.erookies.module_im.ui.fragment.entry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IMEntryFactory() : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return IMEntryViewModel() as T
    }
}