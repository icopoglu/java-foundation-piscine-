# Day 01: Java for Embedded Engineers (Memory & Optimization)

## 🎯 Overview
This module focuses on bridging the gap between Embedded C/C++ memory management and Java's JVM architecture. The goal is to understand the cost of abstractions, memory footprints, and data integrity in high-performance automation systems.

---

## 📚 Core Concepts Covered
* **Stack vs Heap:** Understanding variable lifecycles.
* **Reference Handling:** Analyzing "Pass-by-Value of Reference" vs C Pointers.
* **Immutability:** String Pool mechanics and memory leak prevention using `StringBuilder`.
* **Bitwise Operations:** Implementing CRC logic using pure Java without external libraries.

---

## 🛠️ Exercises

### Exercise 00: The Cost of Abstraction (Primitive vs Wrapper)
**Directory:** `ex00/`
**Objective:** Analyze the performance impact of Autoboxing/Unboxing.
* Measured the CPU time difference between `int` (Stack) and `Integer` (Heap) summation loops (10M iterations).
* **Key Finding:** Wrapper classes introduce significant overhead due to object header memory footprint and GC pressure.

### Exercise 01: Packet Encapsulation
**Directory:** `ex01/`
**Objective:** Simulate a binary communication packet structure.
* Designed a `Packet` class mimicking a C-Struct.
* Implemented strict Encapsulation with Setter validations to prevent invalid protocol states (e.g., negative length).

### Exercise 02: The Reference Trap
**Directory:** `ex02/`
**Objective:** Prove Java's reference passing mechanism.
* Implemented `reset()` and `increment()` methods to demonstrate that reassigning a reference locally does not affect the original object, whereas modifying fields does.
* **Analogy:** Mapped Java references to C-style pointers.

### Exercise 03: Memory Optimization (String vs StringBuilder)
**Directory:** `ex03/`
**Objective:** Prevent memory leaks in high-frequency loops (e.g., UART listeners).
* Simulated a data stream concatenation scenario.
* Proved that `String` concatenation creates thousands of dead objects in Heap, while `StringBuilder` uses a mutable buffer, providing massive performance gains.

### Exercise 04: Algorithmic Logic (CRC-8 & Checksum)
**Directory:** `ex04/`
**Objective:** Implement low-level data verification.
* Wrote a pure logic XOR Checksum calculator.
* Implemented a CRC-8 algorithm using bitwise operators (`& 0xFF`, `^`, `<<`), handling Java's signed byte limitations correctly.

---

## 📝 Engineer's Notes
* Java `byte` is signed (-128 to 127). Bitwise masking (`& 0xFF`) is mandatory when processing binary protocols from hardware.
* Improper use of Wrapper classes in tight loops can cause latency spikes due to Garbage Collection.