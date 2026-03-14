# AI Interview System (Java + MySQL)

## Overview

The **AI Interview System** is a Java-based application designed to simulate a real interview environment.
It allows users to practice **Aptitude, Technical, and HR interview rounds** through an interactive system.
The application stores questions and user results in a **MySQL database** and retrieves them dynamically during the interview process.

This project demonstrates the use of **Java programming, JDBC database connectivity, DAO architecture, and Java Swing GUI**.

## Features

* User **Registration and Login**
* **Java Swing GUI** for Login and Dashboard
* Three Interview Rounds:

  * Aptitude Round
  * Technical Round
  * HR Interview Round
* Questions stored and fetched from **MySQL database**
* **Randomized question selection** using SQL
* Automatic **score calculation**
* Final **interview results stored in database**
* Console-based question answering system
* Structured **layered architecture**

## Technologies Used

* Java
* MySQL
* JDBC (Java Database Connectivity)
* Java Swing (GUI)
* Git & GitHub

## Project Architecture

The project follows a **layered architecture** for better maintainability.

```
UI Layer
↓
DAO Layer
↓
Model Layer
↓
Database (MySQL)
```

### Layer Explanation

**UI Layer**

* Handles user interaction
* Contains GUI and interview round interfaces

**DAO Layer**

* Handles all database operations
* Fetches questions and stores results

**Model Layer**

* Represents data objects such as User, Question, and Score

**Config Layer**

* Manages database connection

## Project Structure

```
src
│
├── config
│   └── DBConnection.java
│
├── model
│   ├── User.java
│   ├── Question.java
│   └── ScoreManager.java
│
├── dao
│   ├── UserDAO.java
│   ├── QuestionDAO.java
│   └── ResultDAO.java
│
├── ui
│   ├── LoginGUI.java
│   ├── DashboardGUI.java
│   ├── AptitudeRoundUI.java
│   ├── TechnicalRoundUI.java
│   └── HRRoundUI.java
│
└── main
    └── Main.java
```

## Database Design

### 1. Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);
```

### 2. Questions Table

```sql
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    round VARCHAR(20),
    question TEXT,
    optionA VARCHAR(200),
    optionB VARCHAR(200),
    optionC VARCHAR(200),
    optionD VARCHAR(200),
    correctAnswer VARCHAR(10)
);
```

### 3. Results Table

```sql
CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    aptitude_score INT,
    technical_score INT,
    hr_score INT,
    final_score INT
);
```

## How the System Works

1. User opens the application.
2. User registers with name, email, and password.
3. After registration, the user logs into the system.
4. The dashboard appears with three interview rounds.
5. The user selects a round.
6. Questions are fetched randomly from the database.
7. The user answers questions in the terminal.
8. Scores are calculated automatically.
9. Final results are stored in the MySQL database.

## How to Run the Project

### Step 1: Clone the Repository

```
git clone https://github.com/Dhruvijhanjhri/AI-Interview-System-Java-MySQL.git
```

### Step 2: Setup MySQL Database

Create a database:

```
CREATE DATABASE interview_system;
```

Create the required tables using the SQL scripts provided above.

---

### Step 3: Configure Database Connection

Open:

```
src/config/DBConnection.java
```

Update your database credentials:

```java
String url = "jdbc:mysql://localhost:3306/interview_system";
String user = "root";
String password = "your_password";
```

### Step 4: Compile the Project

```
javac -cp "lib/mysql-connector-j-9.6.0.jar;src" src/config/*.java src/model/*.java src/dao/*.java src/ui/*.java src/main/*.java
```

### Step 5: Run the Application

```
java -cp "lib/mysql-connector-j-9.6.0.jar;src" main.Main
```

## Application Flow

```
Register User
↓
Login via GUI
↓
Dashboard
↓
Select Interview Round
↓
Answer Questions
↓
Score Calculated
↓
Result Stored in Database
```

## Future Improvements

* Add **AI-based answer evaluation**
* Add **difficulty levels for questions**
* Add **performance analytics dashboard**
* Convert system to a **web application**
* Add **voice-based interview simulation**

