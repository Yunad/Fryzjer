CREATE Table if not exists Users(
user_id int NOT NULL PRIMARY KEY,
name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR (30) NOT NULL
 )