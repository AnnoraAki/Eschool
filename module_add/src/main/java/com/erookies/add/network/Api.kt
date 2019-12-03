package com.erookies.add.network

import com.erookies.add.bean.AddEntry
import com.erookies.lib_common.bean.StatusBean
import com.erookies.lib_common.bean.StatusWrapper
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Create by Cchanges.
 * Time: 2019-12-01
 */
interface Api {
    @POST("/api/purchase")
    fun uploadData(
        @Query("tag") tag: Int,
        @Query("sno") sno: String,
        @Query("time") time: String,
        @Query("where") where: String,
        @Query("number") number: Int,
        @Query("info") info: String
    ): Observable<StatusBean>

    @GET("/api/get_purchase")
    fun getData(
        @Query("tag") tag: Int,
        @Query("sno") sno: String = "0"
    ): Observable<StatusWrapper<List<AddEntry>>>
}