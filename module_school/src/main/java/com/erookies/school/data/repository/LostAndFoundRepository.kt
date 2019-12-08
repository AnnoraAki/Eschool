package com.erookies.school.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.IntDef
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.lib_common.config.START_FROM_USER
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.ItemDataWrapper
import com.erookies.school.network.Api
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class LostAndFoundRepository private constructor(){

    /**
     * @param type 标识加载的是用户发布的失物招领信息还是所有人发布的失物招领信息
     * @return 失物招领信息的列表
     */
    @SuppressLint("CheckResult")
    fun loadItemList(@LoadType type:Int, operation:(List<ItemData>)->Unit, error:(message:String)->Unit){
        val body = when(type){
            START_FROM_MAIN ->  "0"
            else -> BaseApp.user?.stuNum.toString()
        }

        val observable:Observable<ItemDataWrapper> = ApiGenerator.getApiService(Api::class.java).getGoods(
            body
        )
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({items->
                Log.d("LostAndFoundRepository",items.data.toString())
                operation.invoke(items.data)
            },{
                error.invoke(it.message.toString())
            })
    }

    @Retention(AnnotationRetention.SOURCE)
    @Target(AnnotationTarget.PROPERTY,AnnotationTarget.FIELD,AnnotationTarget.VALUE_PARAMETER)
    @IntDef(START_FROM_MAIN, START_FROM_USER)
    annotation class LoadType

    companion object{

        private lateinit var INSTANCE:LostAndFoundRepository

        fun getInstance():LostAndFoundRepository{
            if (!::INSTANCE.isInitialized){
                synchronized(LostAndFoundRepository::class.java){
                    if (!::INSTANCE.isInitialized){
                        INSTANCE = LostAndFoundRepository()
                    }
                }
            }
            return INSTANCE
        }
    }
}