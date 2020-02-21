package com.example.labtest1.feeskeeper.nimit.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.OnConflictStrategy.IGNORE
import com.example.labtest1.feeskeeper.nimit.model.FeeDesc



@Dao

interface   FeeDescDao {

    @Query("SELECT * FROM FeeDesc")
    fun loadAll(): LiveData<List<FeeDesc>>

    @Query("SELECT * FROM FeeDesc WHERE id = :bookmarkId")
    fun loadBookmark(bookmarkId: Long): FeeDesc

    @Query("SELECT * FROM FeeDesc WHERE id = :bookmarkId")

    fun loadLiveBookmark(bookmarkId: Long): LiveData<FeeDesc>

    @Insert(onConflict = IGNORE)
    fun insertBookmark(bookmark: FeeDesc): Long

    @Update(onConflict = REPLACE)
    fun updateBookmark(bookmark: FeeDesc)

    @Delete
    fun deleteBookmark(bookmark: FeeDesc)



}