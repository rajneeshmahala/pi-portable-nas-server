package com.devx.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devx.app.ssh.SshClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun TerminalScreen(host: String, user: String, pass: String) {
    val scope = rememberCoroutineScope()
    val ssh = remember { SshClient() }
    var output by remember { mutableStateOf("") }
    var cmd by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        output += withContext(Dispatchers.IO) {
            ssh.connect(host, user, pass) + "\n"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(12.dp)
    ) {
        Text(output, color = Color.Green, modifier = Modifier.weight(1f))

        TextField(
            value = cmd,
            onValueChange = { cmd = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter command") }
        )

        Button(onClick = {
            scope.launch {
                val res = withContext(Dispatchers.IO) { ssh.exec(cmd) }
                output += "$ $cmd\n$res\n"
                cmd = ""
            }
        }) {
            Text("Send")
        }
    }
}