# Mini-Project for week 10

## Project Name: Concurrent Banking System

### Day 1: Introduction to Java Threads

Objective: Deeply understand Java Threads through practical coding.

Tasks:
- Task 1: Creating and Starting Threads
  - Sub-Task 1.1: Create a Customer class that implements Runnable and simulates a customer performing a deposit.
  - Sub-Task 1.2: Instantiate and start multiple Customer threads using both the Thread class and Runnable interface. Observe the concurrent execution.


- Task 2: Thread Synchronization
  - Sub-Task 2.1: Implement a BankAccount class with deposit and withdraw methods.
  - Sub-Task 2.2: Introduce a race condition by initiating concurrent deposits and withdrawals. Observe and discuss inconsistencies.
  - Sub-Task 2.3: Resolve the race condition using synchronized methods and blocks.


- Task 3: Hands-on Project: Basic Banking System
  - Sub-Task 3.1: Implement the Bank class, simulating a bank that manages multiple BankAccount instances.
  - Sub-Task 3.2: Ensure that the final account balance is consistent after all transactions.