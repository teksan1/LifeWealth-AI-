package com.lifewealthai.ai

import com.lifewealthai.data.local.TransactionEntity

object AdvancedAI {

    fun predictNextMonth(transactions: List<TransactionEntity>): Double {

        if (transactions.isEmpty()) return 0.0

        val income = transactions.filter { it.type == "INCOME" }.map { it.amount }.average()
        val expense = transactions.filter { it.type == "EXPENSE" }.map { it.amount }.average()

        val trendFactor = (income - expense) * 0.15

        return income + trendFactor
    }
}
