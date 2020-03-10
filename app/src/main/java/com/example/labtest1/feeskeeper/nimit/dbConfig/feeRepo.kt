package com.example.labtest1.feeskeeper.nimit.dbConfig

import androidx.lifecycle.LiveData

class feeRepo(private val feeDao: FeeDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    val allData: LiveData<List<Fee>> = feeDao.getalldata()

    suspend fun insert(fee: Fee) {
        feeDao.insert(fee)
    }

    suspend fun del(fee: Int) {
        feeDao.deleteByUserId(fee)
    }

}