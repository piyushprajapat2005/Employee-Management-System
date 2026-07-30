<<<<<<< HEAD
# Employee Management System

A Java Swing desktop application for managing employee records, backed by a MySQL database.

## Features

- Login authentication (`LoginFrame`)
- Add new employees (`AddEmployee`)
- View / search employees in a sortable table (`ViewEmployees`)
- Update employee details (`UpdateEmployee`)
- Remove employees (`RemoveEmployee`)
- Splash screen on startup (`SplashScreen`)

## Tech Stack

- Java Swing (GUI)
- MySQL (`employee_management` database)
- [`net.proteanit.sql.DbUtils`](https://github.com/) for binding `ResultSet` to `JTable`
- [`JCalendar`](https://toedter.com/jcalendar/) (`JDateChooser`) for date input

## Database Setup

The app expects a MySQL database named `employee_management` with `login` and `employee` tables. Connection details are configured in `Conn.java`.

> **Note:** Database credentials are currently hardcoded in `Conn.java`. Update them to match your local MySQL setup before running.

## Running

Entry point: `SplashScreen.main()` → `LoginFrame` → `HomePage`.
=======
# Employee-Management-System
A Java Swing-based Employee Management System with MySQL integration for secure employee record management, authentication, and CRUD operations.
>>>>>>> 95a1522ac660586778a9a6a68ae1f3545c2f5201
