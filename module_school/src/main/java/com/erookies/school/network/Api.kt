package com.erookies.school.network

import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.ItemDataWrapper
import io.reactivex.Observable
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.http.*

interface Api{
    @GET("/api/missings_things")
    fun getGoods(@Query("sno") sno:String):Observable<ItemDataWrapper>

    @GET("/api/missings_peoples")
    fun getPeople(@Query("sno") sno:String):Observable<ItemDataWrapper>
}