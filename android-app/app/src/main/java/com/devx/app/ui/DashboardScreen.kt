package com.devx.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(onConnect: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text("Raspberry Pi Dashboard")

        Spacer(Modifier.height(16.dp))

        Text("CPU Usage: -- %")
        Text("Memory Usage: -- %")
        Text("Disk Usage: -- %")

        Spacer(Modifier.height(24.dp))

        Button(onClick = onConnect) {
            Text("Open Terminal (Auto-connect root@nas.local)")
        }
    }
}