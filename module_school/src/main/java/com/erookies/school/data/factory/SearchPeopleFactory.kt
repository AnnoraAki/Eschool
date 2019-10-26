package com.erookies.school.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erookies.school.data.repository.SearchPeopleRepository
import com.erookies.school.data.viewModel.SPViewModel

class SearchPeopleFactory(private val repository: SearchPeopleRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SPViewModel(repository) as T
    }
}