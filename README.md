# Vehicle Diagnostic Trouble Code Tracker

**Student:** Dennis Franks Jr.  
**University:** ECPI University  
**Course:** SDC330 – Java Programming  
**Assignment:** Week 3 Course Project – Class Implementation  
**Date:** October 24, 2026

## Project Description

The Vehicle Diagnostic Trouble Code Tracker is a Java terminal-based application designed to organize and manage vehicle diagnostic information. It allows users to record vehicle details, diagnostic trouble codes (DTCs), symptoms, possible causes, diagnostic test results, and repair or resolution notes.

The purpose of this application is to help automotive technicians organize troubleshooting information and retrieve diagnostic history when investigating vehicle problems.

## Application Features

The application provides seven menu options:

1. Add Vehicle
2. Add Diagnostic Record
3. View Vehicle Records
4. Search Diagnostic Records
5. Update Diagnostic Record
6. Delete Diagnostic Record
7. Exit

## Object-Oriented Programming Concepts

The project demonstrates several Java object-oriented programming concepts:

- **Abstraction:** The `DiagnosticRecord` abstract class provides shared properties and methods.
- **Interfaces:** The `Searchable` interface defines diagnostic record searching.
- **Inheritance:** `TroubleCodeRecord` extends `DiagnosticRecord`.
- **Polymorphism:** Diagnostic records use overridden methods to display record information.
- **Composition:** The `Vehicle` class contains a collection of diagnostic records.
- **Encapsulation:** Private fields and public getters/setters control access to class data.
- **Constructors:** Classes use constructors to initialize objects.
- **Singleton Design Pattern:** `DatabaseManager` provides a shared database manager instance.

## Java Source Files

The `src` folder contains seven Java classes and interfaces:

- `Main.java` – Application entry point.
- `Vehicle.java` – Stores vehicle information and associated diagnostic records.
- `DiagnosticRecord.java` – Abstract class containing shared diagnostic information.
- `TroubleCodeRecord.java` – Represents individual diagnostic trouble code records.
- `Searchable.java` – Interface defining search functionality.
- `DiagnosticTracker.java` – Manages vehicle records, diagnostic records, and terminal menu operations.
- `DatabaseManager.java` – Defines the Singleton database manager structure for future SQLite integration.

## Week 3 Implementation

Week 3 implements the Java classes, constructors, access specifiers, interface, abstract class, inheritance, composition, polymorphism, and terminal-based application functionality.

Vehicle and diagnostic records are currently stored in memory while the program is running.

## Future Development

**Week 4:** Implement SQLite database connectivity using JDBC and persistent create, read, update, and delete (CRUD) operations.

**Week 5:** Complete application testing, documentation, and final project submission.

## Running the Application

1. Open the project folder in Visual Studio Code.
2. Ensure the Java Development Kit (JDK) and Java extensions are installed.
3. Open `src/Main.java`.
4. Run the `Main` class.
5. Follow the terminal menu to manage vehicle diagnostic records.

## Project Status

**Week 3 – Class Implementation Completed and Tested**

SQLite database integration is scheduled for Week 4.
