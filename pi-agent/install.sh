#!/bin/bash
sudo apt update
sudo apt install -y python3-pip
sudo mkdir -p /opt/devx-agent
sudo cp -r * /opt/devx-agent
pip3 install -r /opt/devx-agent/requirements.txt
echo "DevX Agent Installed"
