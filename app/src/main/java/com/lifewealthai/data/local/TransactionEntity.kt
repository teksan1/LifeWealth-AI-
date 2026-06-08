package com.lifewealthai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: String, // INCOME / EXPENSE
    val category: String,
    val amount: Double,
    val timestamp: Long = System.currentTimeMillis()
)
