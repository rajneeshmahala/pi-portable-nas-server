package com.devx.app.ssh

import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.transport.verification.PromiscuousVerifier

class SshClient {
    private var client: SSHClient? = null

    fun connect(): String {
        client = SSHClient()
        client!!.addHostKeyVerifier(PromiscuousVerifier())
        client!!.connect("nas.local")
        client!!.authPassword("root", "nas")
        return "Connected to root@nas.local"
    }

    fun exec(cmd: String): String {
        val session = client!!.startSession()
        val command = session.exec(cmd)
        val output = command.inputStream.bufferedReader().readText()
        command.join()
        session.close()
        return output
    }
}