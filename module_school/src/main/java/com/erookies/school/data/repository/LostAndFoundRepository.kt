package com.erookies.school.data.repository

import com.erookies.lib_common.network.ApiGenerator

class LostAndFoundRepository private constructor(private val network:ApiGenerator){

    companion object{
        private lateinit var INSTANCE:LostAndFoundRepository

        fun getInstance(network: ApiGenerator):LostAndFoundRepository{
            if (!::INSTANCE.isInitialized){
                synchronized(LostAndFoundRepository::class.java){
                    if (!::INSTANCE.isInitialized){
                        INSTANCE = LostAndFoundRepository(network)
                    }
                }
            }
            return INSTANCE
        }
    }
}