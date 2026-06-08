package com.lifewealthai.core

data class Transaction(val type: String, val amount: Double)

class FinanceEngine {

    private val transactions = mutableListOf<Transaction>()

    fun addIncome(amount: Double) {
        transactions.add(Transaction("INCOME", amount))
    }

    fun addExpense(amount: Double) {
        transactions.add(Transaction("EXPENSE", amount))
    }

    fun getBalance(): Double {
        val income = transactions.filter { it.type == "INCOME" }.sumOf { it.amount }
        val expense = transactions.filter { it.type == "EXPENSE" }.sumOf { it.amount }
        return income - expense
    }

    fun getIncome(): Double =
        transactions.filter { it.type == "INCOME" }.sumOf { it.amount }

    fun getExpenses(): Double =
        transactions.filter { it.type == "EXPENSE" }.sumOf { it.amount }

    fun getAll(): List<Transaction> = transactions

    // AI forecasting (basic predictive model)
    fun predictNextWeek(): Double {
        if (transactions.isEmpty()) return 0.0

        val avg = transactions.takeLast(10).map { it.amount }.average()
        return avg * 7
    }

    fun cashFlowTrend(): String {
        val balance = getBalance()
        return when {
            balance > 1000 -> "Strong Growth"
            balance > 0 -> "Stable"
            else -> "Negative Flow"
        }
    }
}
