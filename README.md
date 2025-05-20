# 📚 Library_Management_System

## Overview
This project is a console-based Library Management System developed in Java to demonstrate understanding of:
- Object-Oriented Programming (OOP)
- SOLID principles
- Java Collections
- Logging using `java.util.logging`
- Design Patterns (Factory & Observer)

## ✨ Features
- Book Management (Add, Remove, Update, Search)
- Patron Management (Register, Update, View Borrow History)
- Book Lending (Checkout, Return)
- Inventory Tracking (Available vs Borrowed)
- Logging important events

## 🧱 Project Structure
src/
├── models/ → Data models (Book, Patron)
├── services/ → Core logic for books, patrons, lending
├── factories/ → BookFactory using Factory pattern
├── observers/ → Observer pattern to track inventory
├── utils/ → Logger utility
└── Main.java → Test scenario
shell

## 📐 Class Diagram
+----------------+
| Book |
+----------------+
| title |
| author |
| isbn |
| year |
+----------------+
+----------------+
| Patron |
+----------------+
| name |
| id |
| borrowedBooks |
+----------------+
+-------------------+ +--------------------+
| BookService |<----->| BookFactory |
+-------------------+ +--------------------+
+-------------------+ +---------------------+
| LendingService |<----->| InventoryNotifier |
+-------------------+ +---------------------+
↑
+--------------------+
| InventoryObserver |
+--------------------+
+-------------------+
| LoggerUtil |
+-------------------+
