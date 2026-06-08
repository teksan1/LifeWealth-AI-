package com.lifewealthai.data

data class BudgetCategory(
    val name: String,
    val limit: Double,
    val spent: Double = 0.0
)
