package com.lifewealthai.ai

object PredictionEngine {

    fun predictNextMonth(income: Float, expenses: Float): Float {
        val growth = income * 0.05f
        val costIncrease = expenses * 0.03f
        return income + growth - costIncrease
    }
}
