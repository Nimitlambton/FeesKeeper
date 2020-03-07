package com.example.labtest1.feeskeeper.nimit.dbConfig

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeeDao {
    //get all data
    @Query("SELECT * from fee_info")
    fun getalldata(): LiveData<List<Fee>>
    //insert all data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(fee : Fee)
    //Delete all data
    @Query("DELETE FROM fee_info")
    suspend fun deleteAll()

}