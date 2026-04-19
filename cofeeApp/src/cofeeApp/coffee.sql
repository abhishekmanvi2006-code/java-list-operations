CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE coffee (
    id INT PRIMARY KEY,
    coffee_name VARCHAR(100),
    price INT
);

INSERT INTO coffee VALUES (101, 'Febary', 120);
INSERT INTO coffee VALUES (102, 'Royal', 140);
INSERT INTO coffee VALUES (103, 'Diamond', 180);
INSERT INTO coffee VALUES (264, 'Delux', 950);