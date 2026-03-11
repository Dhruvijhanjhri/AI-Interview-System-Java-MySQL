CREATE DATABASE ai_interview_system;

USE ai_interview_system;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    round VARCHAR(20),
    question TEXT,
    optionA VARCHAR(255),
    optionB VARCHAR(255),
    optionC VARCHAR(255),
    optionD VARCHAR(255),
    correctAnswer VARCHAR(1)
);

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    aptitude_score INT,
    technical_score INT,
    hr_score INT,
    final_score INT
);