package com.lifewealthai.data.local

import androidx.room.*

@Dao
interface TransactionDao {

    @Insert
    suspend fun insert(tx: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY timestamp DESC")
    suspend fun getAll(): List<TransactionEntity>

    @Query("SELECT * FROM transactions WHERE type = :type")
    suspend fun getByType(type: String): List<TransactionEntity>
}
