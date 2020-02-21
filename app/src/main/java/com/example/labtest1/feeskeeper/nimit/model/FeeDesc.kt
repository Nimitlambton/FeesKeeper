package com.example.labtest1.feeskeeper.nimit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity

data class FeeDesc(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var name: String = "",
    var address: String = "",
    var Fees: Double = 0.0,
    var Age: Double = 0.0,
    var date : Date ?
)
