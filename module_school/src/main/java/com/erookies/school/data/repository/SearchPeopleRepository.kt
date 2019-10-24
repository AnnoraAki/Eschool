package com.erookies.school.data.repository

import com.erookies.lib_common.network.ApiGenerator

class SearchPeopleRepository private constructor(){

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