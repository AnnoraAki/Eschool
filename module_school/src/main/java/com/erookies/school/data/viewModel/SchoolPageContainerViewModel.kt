package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel

class SchoolPageContainerViewModel : BaseViewModel() {
    var buttonIndex = MutableLiveData<Int>()

    init {
        buttonIndex.value = 0
    }

    fun change(){
        if (buttonIndex.value == 0){
            buttonIndex.value = 1
        }else{
            buttonIndex.value = 0
        }
    }
}