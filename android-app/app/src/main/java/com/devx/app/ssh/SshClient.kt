package com.devx.app.ssh

import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.transport.verification.PromiscuousVerifier

class SshClient {
    private var client: SSHClient? = null

    fun connect(host: String, user: String, password: String): String {
        client = SSHClient()
        client!!.addHostKeyVerifier(PromiscuousVerifier())
        client!!.connect(host)
        client!!.authPassword(user, password)
        return "Connected to $user@$host"
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