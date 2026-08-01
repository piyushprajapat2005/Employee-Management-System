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

## Resources / Icons

Background images used by the UI live in `src/main/resources/icons/`. Make sure this folder is on the classpath when running (in IntelliJ IDEA, mark `src/main/resources` as a **Resources Root**), since images are loaded at runtime via `ClassLoader.getSystemResource`.

## Running

Entry point: `SplashScreen.main()` → `LoginFrame` → `HomePage`.
