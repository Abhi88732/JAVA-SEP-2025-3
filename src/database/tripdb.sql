CREATE DATABASE tripdb;
USE tripdb;

CREATE TABLE trip (
                      id INTEGER AUTO_INCREMENT PRIMARY KEY,
                      destination VARCHAR(255) NOT NULL,
                      start_date DATE NOT NULL,
                      end_date DATE NOT NULL,
                      price DOUBLE NOT NULL CHECK (price > 0),
                      status ENUM('PLANNED','ONGOING','COMPLETED') NOT NULL
);
