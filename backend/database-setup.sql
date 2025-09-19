-- Database and Schema Setup for Café Management System
-- This script creates the database and schemas for MySQL. JPA will handle table creation.

-- Create the main database
CREATE DATABASE IF NOT EXISTS cafe_management_system;

-- Use the database
USE cafe_management_system;

-- Create schemas (MySQL uses databases instead of schemas, but we'll create separate databases for organization)
-- Note: In MySQL, we'll use the main database and prefix tables instead of schemas

-- Grant permissions to root user
GRANT ALL PRIVILEGES ON cafe_management_system.* TO 'root'@'localhost';

-- Create user with password 3427 if it doesn't exist
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY '3427';

-- Grant all privileges to the user
GRANT ALL PRIVILEGES ON cafe_management_system.* TO 'root'@'localhost';
FLUSH PRIVILEGES;