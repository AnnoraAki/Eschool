package com.erookies.school.data.repository

import androidx.annotation.IntDef
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.model.Tag


class LostAndFoundRepository private constructor(){

    /**
     * 如果已加载过数据则值置为 true
     */
    private var hasCached:Boolean = false

    /**
     * @param type 标识加载的是用户发布的失物招领信息还是所有人发布的失物招领信息
     * @return 失物招领信息的列表
     */
    fun loadItemList(@LoadType type:Int):MutableList<LostAndFoundItemData>{
        val items = mutableListOf<LostAndFoundItemData>()
        if (type == DATA_FROM_OTHER){
            //TODO 加载所有人近期发布的失物招领信息
        }else if (type == DATA_FROM_USER){
            //TODO 加载用户发布的失物招领信息
        }
        return items
    }

    fun loadItemDetailInfo(id:String):LostAndFoundItemData{
        val item = LostAndFoundItemData()
        //todo 加载指定id的失物招领信息的详细内容
        return item
    }

    @Retention(AnnotationRetention.SOURCE)
    @Target(AnnotationTarget.PROPERTY,AnnotationTarget.FIELD,AnnotationTarget.VALUE_PARAMETER)
    @IntDef(DATA_FROM_OTHER, DATA_FROM_USER)
    annotation class LoadType

    companion object{

        const val DATA_FROM_USER = 0
        const val DATA_FROM_OTHER = 1

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