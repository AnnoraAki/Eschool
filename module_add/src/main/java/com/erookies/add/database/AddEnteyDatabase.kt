package com.erookies.add.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erookies.add.bean.AddEntry

/**
 * Create by Cchanges.
 * Time: 2019-11-03
 */
@Database(version = 1,entities = [AddEntry::class])
abstract class AddEnteyDatabase : RoomDatabase() {
    abstract fun addEntryDao() : AddEntryDao
}