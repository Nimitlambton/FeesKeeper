package com.example.labtest1.feeskeeper.nimit.dbConfig

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Fee::class), version = 1, exportSchema = false)

 abstract class FeeDatabase : RoomDatabase() {


    abstract fun feeDao(): FeeDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { database ->
                scope.launch {
                    var fee = database.feeDao()
                    // Delete all content here.
                    fee.deleteAll()



                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: FeeDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): FeeDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FeeDatabase::class.java,
                    "Fee_info_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}