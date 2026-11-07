# Vehicle Diagnostic Trouble Code Tracker

**Student:** Dennis Franks Jr.  
**University:** ECPI University  
**Course:** SDC330 – Java Programming  
**Assignment:** Week 5 Course Project – Final Submission  
**Date:** November 7, 2026

## Project Overview

The Vehicle Diagnostic Trouble Code Tracker is a Java terminal-based application developed to help automotive technicians organize and manage vehicle diagnostic information. The application allows users to maintain vehicle information and diagnostic records, including diagnostic trouble codes (DTCs), symptoms, possible causes, test results, and repair notes.

The project addresses the need for an organized way to document automotive troubleshooting and retrieve previously recorded diagnostic information.

The application was developed over five weeks, beginning with project planning and design, followed by Java class implementation, SQLite database integration, and final documentation.

## Application Features

The application provides seven menu options:

1. Add Vehicle
2. Add Diagnostic Record
3. View Vehicle Records
4. Search Diagnostic Records
5. Update Diagnostic Record
6. Delete Diagnostic Record
7. Exit

Users interact with the application through the terminal. Vehicle and diagnostic information is stored in a SQLite database, allowing records to remain available after the application closes.

## Object-Oriented Programming Concepts

The application demonstrates the following Java programming concepts:

- **Abstraction:** The `DiagnosticRecord` abstract class defines common diagnostic record properties and behaviors.
- **Interfaces:** The `Searchable` interface defines search functionality.
- **Inheritance:** The `TroubleCodeRecord` class extends `DiagnosticRecord`.
- **Polymorphism:** Overridden methods allow diagnostic record information to be displayed through inherited class behavior.
- **Composition:** The `Vehicle` class maintains a collection of associated diagnostic records.
- **Encapsulation:** Private fields and public methods control access to application data.
- **Constructors:** Constructors initialize objects with the appropriate information.
- **Access Specifiers:** Public and private access modifiers help organize and protect class data.
- **Singleton Design Pattern:** The `DatabaseManager` class provides a shared instance for managing database access.

These concepts demonstrate how object-oriented programming can organize a Java application into reusable classes with separate responsibilities.

## SQLite Database Implementation

During Week 4, SQLite database support was integrated using Java Database Connectivity (JDBC).

The application supports the four primary database operations:

- **Create:** Add vehicle information and diagnostic records.
- **Read:** Retrieve vehicle records and search diagnostic information.
- **Update:** Modify existing diagnostic records.
- **Delete:** Remove diagnostic records.

The `DatabaseManager` class manages database connectivity and uses prepared SQL statements for database operations.

SQLite provides persistent data storage, eliminating the need to reenter records every time the application starts.

## Java Source Files

The `src` folder contains the following Java files:

- `Main.java` – Starts the application and initializes the database connection.
- `Vehicle.java` – Represents vehicle information and associated diagnostic records.
- `DiagnosticRecord.java` – Abstract class defining common diagnostic record information.
- `TroubleCodeRecord.java` – Represents individual diagnostic trouble code records.
- `Searchable.java` – Interface defining search functionality.
- `DiagnosticTracker.java` – Handles terminal menu interactions and diagnostic record management.
- `DatabaseManager.java` – Manages SQLite connectivity and database operations using the Singleton design pattern.

## Project Development

### Week 1 – Project Proposal

The Vehicle Diagnostic Trouble Code Tracker was selected as a practical automotive troubleshooting application. The proposal identified the problem, intended users, and planned application features.

### Week 2 – Application Design

The application structure was planned, including Java classes, object-oriented relationships, and database storage requirements.

### Week 3 – Class Implementation

Java classes and interfaces were implemented using inheritance, abstraction, composition, polymorphism, constructors, and access specifiers.

The terminal-based menu and initial application functionality were developed and tested.

### Week 4 – Database Implementation

SQLite database connectivity was added using JDBC.

Database operations were implemented to create, retrieve, update, and delete diagnostic records.

The `DatabaseManager` class was updated to follow the Singleton design pattern based on instructor feedback.

### Week 5 – Final Submission

The final phase focuses on verifying application functionality, updating project documentation, preparing a demonstration video, and publishing the completed application to GitHub.

## Requirements and Implementation Mapping

| Course Requirement | Application Implementation |
|---|---|
| Realistic application | Automotive diagnostic record management |
| Terminal input and output | Interactive diagnostic tracker menu |
| Interface | `Searchable` |
| Abstract class | `DiagnosticRecord` |
| Inheritance | `TroubleCodeRecord` extends `DiagnosticRecord` |
| Composition | `Vehicle` contains diagnostic records |
| Polymorphism | Overridden diagnostic record methods |
| Constructors | Object initialization in application classes |
| Access specifiers | Private fields and public methods |
| SQLite CRUD operations | `DatabaseManager` and diagnostic tracker functionality |
| Documentation | Java comments, project documentation, and README |
| Source code | Organized Java files in the GitHub repository |

## Application Testing

The application was tested in Visual Studio Code during development.

Testing included checking terminal menu functionality, vehicle and diagnostic record operations, SQLite database connectivity, and program execution.

The completed Week 4 application ran successfully without reported errors.

## Challenges and Lessons Learned

One important part of development was integrating Java classes with SQLite database operations while keeping the application organized.

The database implementation required an understanding of JDBC, SQL statements, and the relationship between application objects and stored records.

Instructor feedback also identified an opportunity to improve database connection management through the Singleton design pattern.

This project strengthened my understanding of Java object-oriented programming, database integration, and organizing a software application through multiple development phases.

## Future Improvements

Possible improvements beyond the current course requirements include:

- Adding a graphical user interface.
- Supporting additional vehicle information.
- Expanding diagnostic search options.
- Adding diagnostic reports.
- Providing more detailed repair history.

These features are potential future enhancements and are not part of the current completed application.

## Running the Application

1. Download or clone the GitHub repository.
2. Open the project folder in Visual Studio Code.
3. Ensure the Java Development Kit and Java extensions are installed.
4. Ensure the SQLite JDBC dependency is available in the project configuration.
5. Open `src/Main.java`.
6. Run the `Main` class.
7. Follow the terminal menu to manage vehicle diagnostic records.

## Project Demonstration

**Video Demonstration:** [YouTube demonstration link to be added]

The demonstration will provide an overview of the application, its Java classes, object-oriented programming features, and SQLite database operations.

## Project Summary

The Vehicle Diagnostic Trouble Code Tracker demonstrates the development of a practical Java application using object-oriented programming and relational database storage.

The project began with a proposal and application design, progressed through class implementation and database integration, and concluded with final testing and documentation.

The completed application demonstrates inheritance, abstraction, interfaces, polymorphism, composition, constructors, access specifiers, and SQLite CRUD functionality.

A major success of the project was integrating Java application logic with persistent database storage. One challenge was organizing database connectivity efficiently, which was improved through the Singleton design pattern.

The project provided valuable experience developing a multi-class Java application and applying programming concepts to a realistic automotive diagnostic scenario.