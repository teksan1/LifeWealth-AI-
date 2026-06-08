package com.lifewealthai.core

data class Transaction(
    val type: String,
    val amount: Int
)

class FinanceEngine {

    private var balance = 0
    private var income = 0
    private var expenses = 0

    private val transactions = mutableListOf<Transaction>()

    fun addIncome(amount: Int) {
        income += amount
        balance += amount
        transactions.add(Transaction("INCOME", amount))
    }

    fun addExpense(amount: Int) {
        expenses += amount
        balance -= amount
        transactions.add(Transaction("EXPENSE", amount))
    }

    fun getBalance() = balance
    fun getIncome() = income
    fun getExpenses() = expenses
    fun getAll() = transactions
}
