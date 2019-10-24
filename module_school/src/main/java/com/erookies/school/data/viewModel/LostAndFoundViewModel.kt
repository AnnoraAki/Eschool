package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.repository.LostAndFoundRepository

class LostAndFoundViewModel(private val repository: LostAndFoundRepository) : BaseViewModel() {
    var users = MutableLiveData<MutableList<User>>()
    var currentUser = MutableLiveData<User>()
    var items = MutableLiveData<MutableList<LostAndFoundItemData>>()
}