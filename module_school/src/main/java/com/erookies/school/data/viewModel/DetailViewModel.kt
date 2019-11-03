package com.erookies.school.data.viewModel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.model.SearchPeopleItemData

class DetailViewModel : BaseViewModel() {
    var itemData1 = MutableLiveData<LostAndFoundItemData>()
    var itemData2 = MutableLiveData<SearchPeopleItemData>()

    init {
        itemData2.value = SearchPeopleItemData()
        itemData1.value = LostAndFoundItemData()
    }
}