package com.erookies.school.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erookies.school.data.repository.TopicRepository
import com.erookies.school.data.viewModel.TopicViewModel

class TopicFactory(private val repository: TopicRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopicViewModel(repository) as T
    }
}