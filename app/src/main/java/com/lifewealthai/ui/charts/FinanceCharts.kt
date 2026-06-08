package com.lifewealthai.ui.charts

import androidx.compose.runtime.Composable
import com.lifewealthai.ui.charts.models.ChartData

@Composable
fun FinanceCharts(income: Float, expenses: Float) {

    val data = listOf(
        ChartData("Income", income),
        ChartData("Expenses", expenses),
        ChartData("Savings", income - expenses)
    )

    androidx.compose.runtime.Composable {
        com.lifewealthai.ui.charts.render.SimpleBarChart(data)
    }
}
