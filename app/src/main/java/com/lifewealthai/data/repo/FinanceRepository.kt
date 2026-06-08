package com.lifewealthai.data.repo

import com.lifewealthai.data.local.TransactionEntity

class FinanceRepository(
    private val dao: com.lifewealthai.data.local.TransactionDao
) {

    suspend fun addIncome(amount: Double, category: String = "Income") {
        dao.insert(TransactionEntity(type = "INCOME", category = category, amount = amount))
    }

    suspend fun addExpense(amount: Double, category: String) {
        dao.insert(TransactionEntity(type = "EXPENSE", category = category, amount = amount))
    }

    suspend fun getAll() = dao.getAll()

    suspend fun getIncome() = dao.getByType("INCOME")

    suspend fun getExpenses() = dao.getByType("EXPENSE")
}
