package com.devx.app.ui

import androidx.compose.runtime.*

@Composable
fun AppRoot() {
    var connected by remember { mutableStateOf(false) }
    var host by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    if (!connected) {
        LoginScreen { h, u, p ->
            host = h; user = u; pass = p; connected = true
        }
    } else {
        TerminalScreen(host, user, pass)
    }
}