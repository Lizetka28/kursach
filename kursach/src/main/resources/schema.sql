CREATE TABLE IF NOT EXISTS factory(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
workers INT NOT NULL,
owner VARCHAR(50) NOT NULL
);