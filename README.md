
# 🚀 DevX  
### Made by Rajneesh Mahala

DevX is a modern Android-based Raspberry Pi management and developer control platform.
It allows developers to monitor system stats, access a real-time terminal, and manage multiple Raspberry Pi devices from a single mobile app.

---

## ✨ Features
- Android app built with Jetpack Compose
- Raspberry Pi backend agent using FastAPI
- Real-time interactive terminal (WebSocket)
- CPU, RAM, Disk, Temperature monitoring
- Multi-Pi management
- Token-based authentication
- Dark mode developer-friendly UI

---

## 🏗 Architecture

Android App (DevX)
        |
        | HTTPS / WebSocket
        |
Raspberry Pi DevX Agent

---

## 📂 Repository Structure

DevX/
├── pi-agent/
│   ├── main.py
│   ├── terminal.py
│   ├── requirements.txt
│   └── install.sh
│
└── android-app/
    └── app/
        ├── data/
        ├── network/
        └── ui/

---

## 🐧 Raspberry Pi Setup

```bash
git clone https://github.com/rajneeshmahala/pi-portable-nas-server.git
cd DevX/pi-agent
chmod +x install.sh
./install.sh
```

Run agent:
```bash
export DEVX_TOKEN=devx123
uvicorn main:app --host 0.0.0.0 --port 8000
```

---

## 📱 Android App Setup
Open android-app in Android Studio and run on device.

---

## 🛣 Roadmap
- Charts
- Encrypted storage
- QR onboarding
- Docker & GPIO support

---

## 👨‍💻 Author
Rajneesh Mahala

---

## 📄 License
MIT License
