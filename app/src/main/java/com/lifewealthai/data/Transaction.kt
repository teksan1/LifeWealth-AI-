package com.lifewealthai.data

data class Transaction(
    val id: Int = 0,
    val type: String,
    val amount: Double,
    val category: String,
    val timestamp: Long = System.currentTimeMillis()
)
