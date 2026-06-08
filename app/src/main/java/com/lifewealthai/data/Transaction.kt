package com.lifewealthai.data

data class Transaction(
    val type: String,
    val amount: Int,
    val timestamp: Long = System.currentTimeMillis()
)
