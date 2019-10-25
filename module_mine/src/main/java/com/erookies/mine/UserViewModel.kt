package com.erookies.mine

<<<<<<< HEAD
import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseViewModel

=======
>>>>>>> e9efc56b3347fce559b41e91831190d4704a4288
/**
 * Create by Cchanges.
 * Time: 2019-10-22
 */
<<<<<<< HEAD
class UserViewModel : BaseViewModel() {
    var user = MutableLiveData<User?>()
    var nickname = user.value?.nickname
        set(value) {
            value ?: return
            field = value
            user.value?.nickname = value
        }
    var avatorUrl = user.value?.avatar
        set(value) {
            value ?: return
            field = value
            user.value?.avatar = value
        }

    init {
        user.value = BaseApp.user
    }



}
=======
>>>>>>> e9efc56b3347fce559b41e91831190d4704a4288
