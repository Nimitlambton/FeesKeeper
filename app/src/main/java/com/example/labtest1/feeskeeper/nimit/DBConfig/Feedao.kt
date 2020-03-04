package com.example.labtest1.feeskeeper.nimit.DBConfig

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Feedao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)

    fun insertdesc(Feedesc: Feedesc)


    @Query("SELECT * FROM Feedesc")
    fun getGenders(): List<Feedesc>

    @Query("DELETE FROM Feedesc")
    fun delete()


}



