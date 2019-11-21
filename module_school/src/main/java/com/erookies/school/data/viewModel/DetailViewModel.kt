package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.school.data.model.ItemData

class DetailViewModel : BaseViewModel() {
    var itemData = MutableLiveData<ItemData>()

    init {
        itemData.value = ItemData()
    }
}