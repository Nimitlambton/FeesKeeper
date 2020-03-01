package com.example.labtest1.feeskeeper.nimit.DBConfig

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feedesc(@PrimaryKey(autoGenerate = true)

                   @ColumnInfo(name = "Cid") val Cid: Int,
                   @ColumnInfo(name = "Cname") val Cname: String,
                   @ColumnInfo(name = "Cage") val age: Int
)

