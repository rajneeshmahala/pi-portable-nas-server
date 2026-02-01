package com.devx.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    var connected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(24.dp)
    ) {
        Text("DevX Terminal", fontSize = 30.sp, color = Color.Cyan)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { connected = true },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF22C55E))
        ) {
            Text("Connect to user@nas.local", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (connected) {
            Text(
                text = "Connected to nas.local\n\n$ ssh user@nas.local",
                color = Color(0xFF22C55E),
                fontSize = 14.sp
            )
        }
    }
}