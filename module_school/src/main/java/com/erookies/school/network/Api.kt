package com.erookies.school.network

import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.ItemDataWrapper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface Api{
    @GET("/api/missings_things")
    fun getGoods():Observable<ItemDataWrapper>

    @GET("/api/missings_peoples")
    fun getPeople():Observable<ItemDataWrapper>
}