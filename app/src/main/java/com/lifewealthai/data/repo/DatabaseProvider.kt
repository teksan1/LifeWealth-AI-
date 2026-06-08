package com.lifewealthai.data.repo

import android.content.Context
import androidx.room.Room
import com.lifewealthai.data.local.AppDatabase

object DatabaseProvider {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun get(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "lifewealth_db"
            ).build().also { INSTANCE = it }
        }
    }
}
