package com.example.labtest1.feeskeeper.nimit.dbConfig

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.labtest1.feeskeeper.nimit.addAct


@Entity(tableName = "Fee_info")
class Fee(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") val u_id: Int,
    @ColumnInfo(name = "User_name") val user_name :String,
    @ColumnInfo(name = "Fee") val feeamount :Int,
    @ColumnInfo(name = "User_age") val user_age :Int,
    @TypeConverters(Converters::class)
    @ColumnInfo(name = "date") val date : String
) 