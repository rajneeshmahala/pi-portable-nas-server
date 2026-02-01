package com.devx.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = "DevX", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Made by Rajneesh Mahala", fontSize = 14.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Simple & CI-safe Android App", fontSize = 18.sp)
    }
}