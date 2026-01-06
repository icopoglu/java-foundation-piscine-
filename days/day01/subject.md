# Day 01: Java Basics & The Memory Model

## Overview
Today is about resetting your C/C++ brain. You will learn how Java handles memory without pointers and how the JVM (Java Virtual Machine) manages data via the Stack and the Heap.

---

## General Rules
1. **No External Libraries:** Use only standard JDK (e.g., Scanner, ArrayList).
2. **Naming Convention:** Class names: `PascalCase`, Method/Variable names: `camelCase`.
3. **Professional Documentation:** Use Javadoc (/** ... */) for your methods.
4. **Memory Awareness:** You must be able to explain where each variable lives.

---

## Mandatory Reading
* **Oracle Docs:** [Language Basics](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
* **Baeldung:** [Java Stack and Heap](https://www.baeldung.com/java-stack-heap)
* **Concepts:** Autoboxing, Integer Cache, Pass-by-value.

---

## Exercise 00: The Cache Experiment
Create a file named `IntegerExperiment.java`. Compare two `Integer` objects with the value `100` using `==`, then do the same for `1000`. 
* Explain in a comment why the result is different.

##  Exercise 01: Device Registry CLI
Create a basic registry system for a device fleet.

### Requirements:
1.  **Class `Device`**:
    * Fields: `private int id`, `private String model`, `private int ramCapacity`.
    * Methods: Necessary getters, setters, and a constructor.
2.  **Class `DeviceRegistryApp`**:
    * Uses a `Scanner` to read input from the console.
    * Stores `Device` objects in an `ArrayList`.
    * Functionality: `Add Device`, `List All Devices`, `Show Total RAM`.

---

## Knowledge Check (For day01_answers.md)
1.  What is the difference between `int` and `Integer`?
2.  Why is Java called "Pass-by-value" even when passing objects?
3.  What happens on the Heap when you set an object reference to `null`?

---

## Submission Instructions
1.  Push your code to: `checkpoints/day01/`
2.  Push your answers to: `checkpoints/day01_answers.md`
3.  Fill your `evaluation.md` for Day 01.