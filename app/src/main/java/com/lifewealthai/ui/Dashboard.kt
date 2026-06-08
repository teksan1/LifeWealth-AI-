package com.lifewealthai.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lifewealthai.core.FinanceEngine

@Composable
fun Dashboard(engine: FinanceEngine) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("LifeWealth AI Dashboard", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(12.dp))

        Text("Balance: ${engine.getBalance()}")
        Text("Income: ${engine.getIncome()}")
        Text("Expenses: ${engine.getExpenses()}")

        Spacer(Modifier.height(12.dp))

        Text("AI Forecast (7 days): ${engine.predictNextWeek()}")
        Text("Trend: ${engine.cashFlowTrend()}")

        Spacer(Modifier.height(20.dp))

        Row {
            Button(onClick = { engine.addIncome(100.0) }) {
                Text("+ Income")
            }

            Spacer(Modifier.width(10.dp))

            Button(onClick = { engine.addExpense(40.0) }) {
                Text("+ Expense")
            }
        }
    }
}
