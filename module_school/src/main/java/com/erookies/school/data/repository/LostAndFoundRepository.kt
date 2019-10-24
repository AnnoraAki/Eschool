package com.erookies.school.data.repository


class LostAndFoundRepository private constructor(){

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