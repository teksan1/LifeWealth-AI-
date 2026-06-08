package com.lifewealthai.ui.charts.render

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lifewealthai.ui.charts.models.ChartData

@Composable
fun SimpleBarChart(data: List<ChartData>) {

    val max = data.maxOf { it.value }

    Column {
        Text("📊 Finance Overview")

        Spacer(Modifier.height(10.dp))

        data.forEach {
            val percent = it.value / max

            Column {
                Text(it.label)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                        .background(Color.LightGray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(percent)
                            .height(18.dp)
                            .background(Color(0xFF4CAF50))
                    )
                }

                Spacer(Modifier.height(8.dp))
            }
        }
    }
}
