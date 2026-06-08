package com.lifewealthai.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lifewealthai.ai.AdvancedAI
import com.lifewealthai.ui.charts.FinanceChartMapper
import com.lifewealthai.ui.charts.render.SimpleBarChart
import com.lifewealthai.data.local.TransactionEntity

@Composable
fun DashboardScreen() {

    // MOCK DATA (will be replaced with Room async in next step)
    val transactions = remember {
        mutableStateListOf(
            TransactionEntity(type = "INCOME", category = "Job", amount = 5000.0),
            TransactionEntity(type = "EXPENSE", category = "Rent", amount = 1800.0),
            TransactionEntity(type = "EXPENSE", category = "Food", amount = 600.0)
        )
    }

    val income = transactions.filter { it.type == "INCOME" }.sumOf { it.amount }
    val expense = transactions.filter { it.type == "EXPENSE" }.sumOf { it.amount }
    val balance = income - expense

    val chartData = FinanceChartMapper.map(transactions)
    val prediction = AdvancedAI.predictNextMonth(transactions)

    Column(Modifier.padding(16.dp)) {

        Text("💰 LifeWealth AI – Finance Engine", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(12.dp))

        Card {
            Column(Modifier.padding(12.dp)) {
                Text("Balance: $balance")
                Text("Income: $income")
                Text("Expenses: $expense")
                Text("AI Forecast: $prediction")
            }
        }

        Spacer(Modifier.height(16.dp))

        SimpleBarChart(chartData)

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            transactions.add(TransactionEntity("EXPENSE", "Food", 120.0))
        }) {
            Text("Add Expense")
        }
    }
}
