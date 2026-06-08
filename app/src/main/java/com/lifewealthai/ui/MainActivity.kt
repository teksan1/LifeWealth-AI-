package com.lifewealthai.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.lifewealthai.core.FinanceEngine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val engine = remember { FinanceEngine() }

    var screen by remember { mutableStateOf("home") }

    when (screen) {
        "home" -> HomeScreen(
            onStart = { screen = "dashboard" }
        )

        "dashboard" -> DashboardScreen(
            engine = engine,
            onBack = { screen = "home" }
        )
    }
}

@Composable
fun HomeScreen(onStart: () -> Unit) {
    Surface {
        Button(onClick = onStart) {
            Text("Launch LifeWealth AI")
        }
    }
}

@Composable
fun DashboardScreen(engine: FinanceEngine, onBack: () -> Unit) {
    Surface {
        Column {
            Button(onClick = onBack) {
                Text("Back")
            }

            Dashboard(engine)
        }
    }
}
