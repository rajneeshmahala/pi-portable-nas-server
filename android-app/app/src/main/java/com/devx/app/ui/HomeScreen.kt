package com.devx.app.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(Modifier.padding(20.dp)) {
        Text("DevX", fontSize = 32.sp, color = Color.Cyan)
        Text("Made by Rajneesh Mahala", color = Color.Gray)
    }
}