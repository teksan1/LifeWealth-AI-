package com.lifewealthai.ui.charts

import com.lifewealthai.data.local.TransactionEntity

data class ChartPoint(
    val label: String,
    val value: Float
)

object FinanceChartMapper {

    fun map(transactions: List<TransactionEntity>): List<ChartPoint> {

        val income = transactions.filter { it.type == "INCOME" }.sumOf { it.amount }
        val expense = transactions.filter { it.type == "EXPENSE" }.sumOf { it.amount }

        return listOf(
            ChartPoint("Income", income.toFloat()),
            ChartPoint("Expenses", expense.toFloat()),
            ChartPoint("Net", (income - expense).toFloat())
        )
    }
}
