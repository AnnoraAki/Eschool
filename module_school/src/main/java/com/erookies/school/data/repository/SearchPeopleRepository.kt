package com.erookies.school.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.model.ItemDataWrapper
import com.erookies.school.network.Api
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.erookies.school.data.repository.LostAndFoundRepository.LoadType


class SearchPeopleRepository private constructor(){

    /**
     * @param type 标识加载的是用户发布的失物招领信息还是所有人发布的失物招领信息
     * @return 失物招领信息的列表
     */
    @SuppressLint("CheckResult")
    fun loadItemList(@LoadType type:Int, opreation:(List<ItemData>)->Unit, error:(message:String)->Unit){
        val observable: Observable<ItemDataWrapper> = when(type){
            START_FROM_MAIN -> ApiGenerator.getApiService(Api::class.java).getPeople()
            //加载当前登录用户发布的寻人信息
            else -> ApiGenerator.getApiService(Api::class.java).getPeople()
        }
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({items->
                opreation.invoke(items.data)
            },{
                error.invoke(it.message.toString())
            })
    }

    companion object{
        private lateinit var INSTANCE:SearchPeopleRepository

        fun getInstance():SearchPeopleRepository{
            if (!::INSTANCE.isInitialized){
                synchronized(SearchPeopleRepository::class.java){
                    if (!::INSTANCE.isInitialized){
                        INSTANCE = SearchPeopleRepository()
                    }
                }
            }
            return INSTANCE
        }
    }
}