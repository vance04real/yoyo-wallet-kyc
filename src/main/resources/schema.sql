DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL,
surname VARCHAR(250) NOT NULL,
email VARCHAR(250) (250) DEFAULT NULL
);