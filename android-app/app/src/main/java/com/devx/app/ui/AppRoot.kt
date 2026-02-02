package com.devx.app.ui

import androidx.compose.runtime.*

@Composable
fun AppRoot() {
    var connected by remember { mutableStateOf(false) }

    if (!connected) {
        DashboardScreen { connected = true }
    } else {
        TerminalScreen()
    }
}