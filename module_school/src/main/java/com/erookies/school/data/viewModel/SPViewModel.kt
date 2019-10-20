package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erookies.lib_common.User
import com.erookies.school.data.repository.SearchPeopleRepository

class SPViewModel(private val repository: SearchPeopleRepository) : ViewModel() {
    var userMutableList = MutableLiveData<MutableList<User>>()
    var currentUser = MutableLiveData<User>()
}