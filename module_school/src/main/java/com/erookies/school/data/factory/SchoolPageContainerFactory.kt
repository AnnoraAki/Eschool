package com.erookies.school.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erookies.school.data.viewModel.SchoolPageContainerViewModel

class SchoolPageContainerFactory : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SchoolPageContainerViewModel() as T
    }
}