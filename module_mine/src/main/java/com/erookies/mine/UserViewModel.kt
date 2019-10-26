package com.erookies.mine

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseViewModel


/**
 * Create by Cchanges.
 * Time: 2019-10-22
 */
class UserViewModel : BaseViewModel() {
    private var user = BaseApp.user
    var nickname = MutableLiveData<String>()
    var avatarUrl = MutableLiveData<String>()

    init {
        nickname.value = if(BaseApp.isLogin) user?.nickname else "暂未登陆"
        avatarUrl.value = if(BaseApp.isLogin) user?.avatar else "暂未登陆"
    }

    fun setNickname(str:String) {
        user?.nickname = str
        nickname.value = str
        //todo:网络请求
    }

    fun setAvatar(str:String){
        user?.avatar = str
        avatarUrl.value = str
        //todo 网络请求
    }

}
