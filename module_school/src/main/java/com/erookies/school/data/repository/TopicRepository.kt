package com.erookies.school.data.repository

import com.erookies.lib_common.network.ApiGenerator

class TopicRepository private constructor(private val network:ApiGenerator){

    companion object{
        private lateinit var INSTANCE:TopicRepository

        fun getInstance(network: ApiGenerator):TopicRepository{
            if (!::INSTANCE.isInitialized){
                synchronized(TopicRepository::class.java){
                    if (!::INSTANCE.isInitialized){
                        INSTANCE = TopicRepository(network)
                    }
                }
            }
            return INSTANCE
        }
    }
}