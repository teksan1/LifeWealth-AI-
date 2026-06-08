package com.lifewealthai.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lifewealthai.core.FinanceEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LifeWealthApp()
        }
    }
}

@Composable
fun LifeWealthApp() {

    val engine = remember { FinanceEngine() }
    var refresh by remember { mutableStateOf(0) }

    fun update() { refresh++ }

    val transactions = remember(refresh) {
        engine.getAll()
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("LifeWealth AI", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(12.dp))

            Text("Balance: ${engine.getBalance()}")
            Text("Income: ${engine.getIncome()}  Expenses: ${engine.getExpenses()}")

            Spacer(Modifier.height(12.dp))

            Row {
                Button(onClick = {
                    engine.addIncome(100)
                    update()
                }) {
                    Text("Add Income")
                }

                Spacer(Modifier.width(10.dp))

                Button(onClick = {
                    engine.addExpense(40)
                    update()
                }) {
                    Text("Add Expense")
                }
            }

            Spacer(Modifier.height(20.dp))

            LazyColumn {
                items(transactions) { t ->
                    Text("${t.type}: ${t.amount}")
                }
            }
        }
    }
}
