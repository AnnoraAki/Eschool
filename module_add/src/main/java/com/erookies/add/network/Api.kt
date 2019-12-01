package com.erookies.add.network

import com.erookies.add.bean.AddEntry
import com.erookies.lib_common.bean.StatusBean
import com.erookies.lib_common.bean.StatusWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
interface Api {
    @POST("/api/purchase")
    fun uploadData(
        @Field("tag") tag: Int,
        @Field("sno") sno: String,
        @Field("time") time: String,
        @Field("where") where: String,
        @Field("number") number: Int,
        @Field("info") info: String
    ): Observable<StatusBean>

    @GET("/api/get_purchase/")
    fun getData(
        @Query("tag") tag: Int,
        @Query("sno") sno: String = "0"
    ): Observable<StatusWrapper<List<AddEntry>>>
}