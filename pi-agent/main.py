
from fastapi import FastAPI, WebSocket, HTTPException
import psutil, platform, socket, time, os
from terminal import terminal_ws

API_TOKEN = os.getenv("DEVX_TOKEN", "devx123")

app = FastAPI(title="DevX Agent")

def auth(token: str):
    if token != API_TOKEN:
        raise HTTPException(status_code=401)

@app.get("/api/system")
def system(token: str):
    auth(token)
    return {
        "hostname": socket.gethostname(),
        "os": platform.platform(),
        "kernel": platform.release(),
        "uptime": int(time.time() - psutil.boot_time())
    }

@app.get("/api/stats")
def stats(token: str):
    auth(token)
    return {
        "cpu": psutil.cpu_percent(),
        "ram": psutil.virtual_memory().percent,
        "disk": psutil.disk_usage("/").percent
    }

@app.websocket("/ws/terminal")
async def terminal(ws: WebSocket):
    await terminal_ws(ws, API_TOKEN)
