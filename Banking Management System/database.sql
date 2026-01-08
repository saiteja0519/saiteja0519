-- Create Database
CREATE DATABASE IF NOT EXISTS banking_db;
USE banking_db;

-- Create Accounts Table
CREATE TABLE IF NOT EXISTS accounts (
    account_no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL CHECK (balance >= 0)
);

-- Sample Data (Optional)
INSERT INTO accounts (name, balance) VALUES
('Rahul', 5000),
('Anita', 10000);
