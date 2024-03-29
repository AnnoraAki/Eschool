package com.erookies.mine.network

import com.erookies.lib_common.bean.User
import com.erookies.lib_common.bean.StatusBean
import com.erookies.lib_common.bean.StatusWrapper
import com.erookies.mine.bean.ChangeBody
import com.erookies.mine.bean.LoginBean
import com.erookies.mine.bean.RegisterBean
import com.erookies.mine.bean.SnoBean
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * Create by Cchanges.
 * Time: 2019-11-11
 */
interface Api {
    @POST("/api/verify")
    fun verify(@Body snoBody: SnoBean): Observable<StatusBean>

    @POST("/api/register")
    fun register(@Body registerBody: RegisterBean): Observable<StatusBean>

    @POST("/api/user")
    fun login(@Body loginBody: LoginBean): Observable<StatusWrapper<User>>

    @POST("/api/pwd_reset")
    fun changePwd(@Body changeBody: ChangeBody): Observable<StatusBean>

    @Multipart
    @POST("/api/up_face")
    fun upAvatar(@Part("sno") sno: RequestBody, @Part file: MultipartBody.Part) : Observable<StatusWrapper<String>>
}