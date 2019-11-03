package com.erookies.add.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.erookies.add.bean.AddEntry

/**
 * Create by Cchanges.
 * Time: 2019-11-03
 */
@Dao
interface AddEntryDao {
    @Query("SELECT * FROM add_items")
    fun getAllEntrys() : LiveData<List<AddEntry>>
}