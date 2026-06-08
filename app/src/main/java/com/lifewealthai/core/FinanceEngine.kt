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

    // AI placeholder (future upgrade point)
    fun predictNextMonth(): Double {
        val avg = transactions.takeLast(10).sumOf { it.amount } / 10.0
        return if (avg.isNaN()) 0.0 else avg * 30
    }
}
