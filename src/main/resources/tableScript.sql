create database IF NOT EXISTS RESUME_DB;
use RESUME_DB;
CREATE TABLE IF NOT EXISTS resume_data(
id int NOT NULL AUTO_INCREMENT,
file_name varchar(255),
email_Id varchar(50) UNIQUE,
content BLOB,
PRIMARY KEY(id)
);