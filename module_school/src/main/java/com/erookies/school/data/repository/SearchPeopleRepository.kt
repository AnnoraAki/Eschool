package com.erookies.school.data.repository

import com.erookies.lib_common.network.ApiGenerator

class SearchPeopleRepository private constructor(private val network:ApiGenerator){

    companion object{
        private lateinit var INSTANCE:SearchPeopleRepository

        fun getInstance(network: ApiGenerator):SearchPeopleRepository{
            if (!::INSTANCE.isInitialized){
                synchronized(SearchPeopleRepository::class.java){
                    if (!::INSTANCE.isInitialized){
                        INSTANCE = SearchPeopleRepository(network)
                    }
                }
            }
            return INSTANCE
        }
    }
}