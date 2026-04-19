CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price INT
);

INSERT INTO coffee VALUES (101, 'Espresso', 120);
INSERT INTO coffee VALUES (102, 'Latte', 150);
INSERT INTO coffee VALUES (103, 'Cappuccino', 180);

SELECT * FROM coffee;