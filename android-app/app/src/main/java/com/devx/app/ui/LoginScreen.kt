package com.devx.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onConnect: (String, String, String) -> Unit) {
    var host by remember { mutableStateOf("nas.local") }
    var user by remember { mutableStateOf("user") }
    var pass by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Connect to Server")

        OutlinedTextField(host, { host = it }, label = { Text("Host / IP") })
        OutlinedTextField(user, { user = it }, label = { Text("Username") })
        OutlinedTextField(
            pass,
            { pass = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { onConnect(host, user, pass) }) {
            Text("Connect")
        }
    }
}