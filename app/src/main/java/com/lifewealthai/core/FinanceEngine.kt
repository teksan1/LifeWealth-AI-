package com.lifewealthai.core

import com.lifewealthai.data.Transaction

class FinanceEngine {

    private val transactions = mutableListOf<Transaction>()

    fun addIncome(amount: Int) {
        transactions.add(Transaction("INCOME", amount))
    }

    fun addExpense(amount: Int) {
        transactions.add(Transaction("EXPENSE", amount))
    }

    fun getIncome(): Int =
        transactions.filter { it.type == "INCOME" }.sumOf { it.amount }

    fun getExpenses(): Int =
        transactions.filter { it.type == "EXPENSE" }.sumOf { it.amount }

    fun getBalance(): Int =
        getIncome() - getExpenses()

    fun getAll(): List<Transaction> = transactions
}
