package com.devx.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devx.app.ssh.SshClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun TerminalScreen() {
    val scope = rememberCoroutineScope()
    val ssh = remember { SshClient() }

    var output by remember { mutableStateOf("") }
    var cmd by remember { mutableStateOf("") }
    var connected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text("DevX SSH Terminal", color = Color.Green, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            scope.launch {
                output += withContext(Dispatchers.IO) {
                    ssh.connect("nas.local", "user", "PASSWORD_HERE") + "\n"
                }
                connected = true
            }
        }) {
            Text("Connect")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(output, color = Color.Green, modifier = Modifier.weight(1f))

        if (connected) {
            TextField(
                value = cmd,
                onValueChange = { cmd = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Enter command") }
            )

            Button(onClick = {
                scope.launch {
                    val res = withContext(Dispatchers.IO) { ssh.exec(cmd) }
                    output += "$ user@nas.local $ $cmd\n$res\n"
                    cmd = ""
                }
            }) {
                Text("Send")
            }
        }
    }
}