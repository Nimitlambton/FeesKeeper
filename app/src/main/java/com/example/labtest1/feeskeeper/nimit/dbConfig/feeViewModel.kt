package com.example.labtest1.feeskeeper.nimit.dbConfig

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// Class extends AndroidViewModel and requires application as a parameter.

class feeViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: feeRepo

    // LiveData gives us updated words when they change.
    val allfee: LiveData<List<Fee>>

    init {


           // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.

        val FeeDao = FeeDatabase.getDatabase(application, viewModelScope).feeDao()

        repository = feeRepo(FeeDao)

        allfee = repository.allData
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(fee: Fee) = viewModelScope.launch {

        repository.insert(fee)
    }
    fun delete(id: Int) = viewModelScope.launch {

        repository.del(id)

    }





}