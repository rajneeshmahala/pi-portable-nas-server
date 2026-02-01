
import os, pty, asyncio

async def terminal_ws(ws, token):
    await ws.accept()
    auth = await ws.receive_text()
    if auth != token:
        await ws.close()
        return

    pid, fd = pty.fork()
    if pid == 0:
        os.execvp("bash", ["bash"])

    async def read():
        while True:
            data = os.read(fd, 1024)
            await ws.send_text(data.decode(errors="ignore"))

    async def write():
        while True:
            data = await ws.receive_text()
            os.write(fd, data.encode())

    await asyncio.gather(read(), write())
