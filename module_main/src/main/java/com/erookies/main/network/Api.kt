package com.erookies.main.network

import com.erookies.lib_common.bean.StatusWrapper
import com.erookies.lib_common.bean.User
import com.erookies.main.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Create by Cchanges.
 * Time: 2019-12-02
 */
interface Api {
    @POST("/api/user")
    fun login(@Body loginBody: LoginBean): Observable<StatusWrapper<User>>
}