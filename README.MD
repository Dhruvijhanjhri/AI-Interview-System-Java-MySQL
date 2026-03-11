# AI Interview System (Java + MySQL)

This project simulates a real interview process with multiple rounds.

Features
- Candidate Registration
- Aptitude Round
- Technical Round
- HR Interview Round
- Random Question Selection
- Score Calculation
- Result Storage in MySQL
- Leaderboard Display

Tech Stack
- Java
- MySQL
- JDBC
- OOP Concepts
- DAO Design Pattern

Project Structure
src/config → Database connection  
src/dao → Database operations  
src/model → Data models  
src/ui → User interface logic  
src/main → Application entry point  

How to Run

1. Import database using schema.sql
2. Add MySQL connector jar in classpath
3. Compile

javac -cp "lib/mysql-connector-j-9.6.0.jar;src" src/config/*.java src/model/*.java src/dao/*.java src/ui/*.java src/main/*.java

4. Run

java -cp "lib/mysql-connector-j-9.6.0.jar;src" main.Main