# Tiyani Bus Services - Passenger Management System

This project is a Java Swing-based GUI application designed to manage a passenger list for the "Tiyani Bus Services." It provides functionalities to add passenger details, view passenger records, and manage data stored in a MySQL database.

## Features

### 1. User-Friendly GUI
   - Easy-to-use graphical interface using Java Swing components.
   - Organised layout with fields for entering passenger information.

### 2. Passenger Management:
   - Add passenger details (First Name, Last Name, Destination, Phone Number).
   - View a list of all passengers.

### 3. Database Integration
   - Data is stored in a MySQL database for persistence.
   - Supports live updates to passenger records.

### 4. Dynamic Table View
   - A table displays all the passenger details retrieved from the database.
   - Option to toggle the table visibility.

### 5. Error Handling
   - Validation for empty fields.
   - Feedback provided for successful or failed operations.

## Technologies Used

 ### Java
  - Core logic, GUI development using Swing, and database interaction through my SQL connector.
 ### MySQL
  - Database to store passenger details.
 ### JDBC
  - Connects the Java application to the MySQL database.


## Prerequisites

Before running the project, ensure the following are installed:

1. Java Development Kit (JDK) - Version 8 or higher.
2. MySQL - A running MySQL server instance.(Ensure you create passenger_details table and then update database connection settings in the Conn class)
4. IDE - NetBeans, IntelliJ IDEA, or Eclipse recommended.
5. Download and install JDBC driver for MySQL

## Installation
1. Clone this repository.
2. Set up a MySQL database with the necessary table (passenger_details).
3. Update database connection settings in the Conn class.
4. Run the project using your preferred IDE (Netbeans, IntelliJ IDEA or Eclipse recommended).

## Usage
1. Run the application.
2. Fill in the form to insert passenger details.
3. Click "View" to toggle the passenger table visibility.
4. Exit the application using the "Exit" button.

## License
 - No Licence

