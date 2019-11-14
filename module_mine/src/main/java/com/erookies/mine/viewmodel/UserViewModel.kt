package com.erookies.mine.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.bean.User


/**
 * Create by Cchanges.
 * Time: 2019-10-22
 */
class UserViewModel : BaseViewModel() {
    var user = MutableLiveData<User?>()

    init {
        user.value = BaseApp.user
    }

    fun setNickname(str:String) {
        user.value?.nickname = str
        //todo:网络请求
    }

    fun setAvatar(str:String){
        user.value?.avatar = str
        //todo 网络请求
    }

}
