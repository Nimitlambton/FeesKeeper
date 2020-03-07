package com.example.labtest1.feeskeeper.nimit.dbConfig

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Fee_info")

class Fee(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") val u_id: Int,
    @ColumnInfo(name = "User_name") val user_name :String

)