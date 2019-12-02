package com.erookies.mine.viewmodel

import androidx.lifecycle.MutableLiveData
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseViewModel
import com.erookies.lib_common.bean.User
import com.erookies.lib_common.extentions.getRequestBody
import com.erookies.lib_common.extentions.safeSubscribeBy
import com.erookies.lib_common.extentions.setSchedulers
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.mine.network.Api
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


/**
 * Create by Cchanges.
 * Time: 2019-10-22
 */
class UserViewModel : BaseViewModel() {
    var user = MutableLiveData<User?>()
    var status = MutableLiveData<Int>()

    init {
        user.value = BaseApp.user
    }

    fun setNickname(str:String) {
        BaseApp.user?.nickname = str
        //todo:网络请求
    }

    fun setAvatar(str:String){
        val sno = user.value?.sno
        sno ?: return
        val file = File(str)
        val body= MultipartBody.Part.createFormData("file", file.name, file.getRequestBody())
        val numBody = sno.toRequestBody("multipart/form-data".toMediaTypeOrNull())
        ApiGenerator.getApiService(Api::class.java)
            .upAvatar(numBody,body)
            .setSchedulers()
            .safeSubscribeBy {
                status.value = it.code
                BaseApp.user?.avatar = it.data
            }.lifeCycle()
    }

    companion object {
        const val CHANGE_SUCCEED = 0
        const val CHANGE_FAILED = 1
    }
}
