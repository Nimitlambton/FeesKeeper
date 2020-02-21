package com.example.labtest1.feeskeeper.nimit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labtest1.feeskeeper.nimit.model.FeeDesc

@Database(entities = arrayOf(FeeDesc::class), version = 1)

abstract class FeeDescDatabase : RoomDatabase() {
    // 2
    abstract fun FeeDescDao(): FeeDescDao
    // 3
    companion object {
        // 4
        private var instance: FeeDescDatabase? = null
        // 5
        fun getInstance(context: Context): FeeDescDatabase {
            if (instance == null) {
                // 6
                instance = Room.databaseBuilder( context.applicationContext, FeeDescDatabase::class.java, "PlaceBook").build()
            }
// 7
            return instance as FeeDescDatabase
        }
    } }