# Day 02: Network Sockets & The "Digital Twin"

## 🎯 Overview
Today, we build the "Nervous System" of your automation project. You will create a TCP Server (Backend) and a Simulated Device (Fake STM32). The goal is to master **Blocking I/O**, **Byte Streams**, **Endianness**, and **Concurrency**.

We are NOT using Strings for communication. We are using **Binary Protocols**, just like a real UART/Industrial Ethernet setup.

---

## 📚 Core Concepts
* **TCP Sockets:** Reliable, connection-based communication (`java.net.Socket`).
* **Input/Output Streams:** `DataInputStream` vs `BufferedReader`. Why we need raw bytes.
* **Endianness:** The generic nightmare. Big Endian (Java/Network) vs Little Endian (ARM/x86).
* **Multi-Threading:** Handling multiple devices simultaneously without freezing the main server.

---

## 🛠️ Exercises

### Exercise 00: The Handshake (Warm-up)
**Directory:** `ex00/`
**Goal:** Establish a basic connection.
* **Server:** Listen on port `5000`. When a client connects, print "Client Connected". Read a line of text and print it.
* **Client:** Connect to `localhost:5000`. Send "Hello Bridge System".
* **Requirement:** Use `try-with-resources` to ensure sockets are closed automatically.

### Exercise 01: The Fake Device (Binary Protocol)
**Directory:** `ex01/`
**Goal:** Simulate an embedded device sending a structured packet.
* **Protocol:** `[Header(1B)] [Cmd(1B)] [Val(2B)]`
    * `Header`: `0xAA` (Sync byte)
    * `Cmd`: `0x01` (Temperature Report)
    * `Val`: `0x0019` (25 Decimal)
* **FakeDevice (Client):** Use `DataOutputStream` to send these bytes.
* **Server:** Read bytes. Check if the first byte is `0xAA`. If not, print "Sync Error". If yes, parse the rest and print: "Command: 1, Value: 25".

### Exercise 02: The Endianness Nightmare (Critical)
**Directory:** `ex02/`
**Goal:** Handle architecture differences.
* **Context:** Java uses **Big Endian** (Most Significant Byte first). STM32 (ARM) uses **Little Endian**.
* **Simulation:** In `FakeDevice`, send the integer `0x12345678` manually as bytes in Little Endian order: `[0x78, 0x56, 0x34, 0x12]`.
* **Server:** Read 4 bytes. If you use `readInt()`, Java will interpret it as `2018915346` (Wrong!).
* **Task:** Write a bitwise logic (`<<`, `|`) to reconstruct the original `0x12345678` correctly from the byte stream.

### Exercise 03: The Multi-Threaded Control Center
**Directory:** `ex03/`
**Goal:** Handle multiple devices.
* **Problem:** In ex01, while the server talks to Device A, Device B cannot connect.
* **Task:**
    * Create a `ClientHandler` class that extends `Thread` (or implements `Runnable`).
    * In `Server.java`, use a `while(true)` loop to accept connections.
    * For every connection, start a new `ClientHandler` thread.
* **Test:** Run 3 instances of `FakeDevice` simultaneously. The Server must show logs for all of them mixed together.

---

## 📝 Engineer's Checklist (Self-Evaluation)
* [ ] Did I handle `IOException` correctly?
* [ ] Do I understand why `read()` blocks the code execution?
* [ ] Can I explain why `0x1234` becomes `0x3412` in Little Endian?
* [ ] Did I verify the "Sync Byte" (0xAA) before processing the payload?