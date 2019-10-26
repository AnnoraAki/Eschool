package com.erookies.school.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erookies.school.data.repository.LostAndFoundRepository
import com.erookies.school.data.viewModel.LostAndFoundViewModel

class LostAndFoundFactory(private val repository: LostAndFoundRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LostAndFoundViewModel(repository) as T
    }
}