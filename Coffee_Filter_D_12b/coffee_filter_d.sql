CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price INT
);

INSERT INTO coffee VALUES (101, 'Dalgona', 200);
INSERT INTO coffee VALUES (102, 'Latte', 150);
INSERT INTO coffee VALUES (103, 'Dark Roast', 180);
INSERT INTO coffee VALUES (104, 'Espresso', 120);
INSERT INTO coffee VALUES (105, 'Decaf', 160);