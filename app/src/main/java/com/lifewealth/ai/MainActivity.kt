package com.lifewealth.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var netWorth by remember { mutableStateOf(0.0) }
            var cashflow by remember { mutableStateOf(0.0) }

            Column {
                Text("💰 LifeWealth AI")
                Text("Net Worth: $")
                Text("Cashflow: $")

                Button(onClick = {
                    netWorth += 200
                    cashflow += 80
                }) {
                    Text("Simulate Income")
                }
            }
        }
    }
}
