# Behavior Tracker Web

## Project Introduction

Behavior Tracker Web is a simple behavior management system developed using Java Web technologies.

Users can register an account, log in to the system, and manage their daily behavior records. The project follows the MVC architecture and uses JDBC to interact with a MySQL database.

This project was built as a practice project for learning Java Web development, including Servlet, JSP, JDBC, Session management, and CRUD operations.

---

## Features

### User Module

* User Registration
* User Login
* Session Authentication
* Logout
* Login Authentication Filter
### Behavior Management Module

* Add Behavior Record
* View Behavior Records
* Update Behavior Record
* Delete Behavior Record

---

## Technology Stack

### Backend

* Java 17
* Servlet
* JSP
* JDBC

### Database

* MySQL

### Server

* Apache Tomcat 10.1

### Build Tool

* Maven

### Version Control

* Git
* GitHub

---

## Project Structure

src/main/java

├── controller

├── service

├── dao

├── pojo

└── jdbc_util

src/main/webapp

├── index.jsp

├── login.jsp

├── register.jsp

├── behavior-list.jsp

└── edit.jsp

---

## Database Tables

### my_users

| Field      | Type    |
| ---------- | ------- |
| id         | int     |
| users_name | varchar |
| pass_word  | varchar |

### user_record

| Field       | Type     |
| ----------- | -------- |
| id          | int      |
| user_id     | int      |
| type        | varchar  |
| value       | int      |
| create_time | datetime |

---

## How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Create the MySQL database

3. Configure database connection information in jdbc_util

4. Run the project using Tomcat 10.1

5. Visit:

```
http://localhost:8080/
```

---

## Future Improvements

* Bootstrap UI optimization
* Search and filtering
* Data statistics dashboard
* Spring Boot migration
* RESTful API support

---

## Author

Wang Jiale

Computer Science Student

Java Backend Development Learner
