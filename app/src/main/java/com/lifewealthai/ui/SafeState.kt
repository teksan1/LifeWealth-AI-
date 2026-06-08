package com.lifewealthai.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SafeState<T>(initial: T) {
    var value by mutableStateOf(initial)
}
