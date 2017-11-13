CREATE DATABASE users;
USE users;

CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL ON users.* TO 'student'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE users(
	name VARCHAR(10) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	e_mail VARCHAR(25) NOT NULL
);

INSERT INTO users VALUES
	('Vladislav','Adamovich','+375 29 123-45-67','pchela@gmail.com'),
	('Vladislav','Burak','+375 44 123-45-67','starosta@gmail.com'),
	('Maxim','Belanovski','+375 33 123-45-67','slowman@gmail.com'),
	('Alan','Wake','+375 29 123-17-67','writer@gmail.com'),
	('Jone','Shepard','+111 11 111-11-11','coolboy@gmail.com'),
	('Soup','McTavish','+375 29 876-45-67','ultranagibator@gmail.com'),
	('Tein','Krios','+375 29 123-45-49','assasin123@gmail.com'),
	('Rem','Zero','+375 29 123-16-67','rezero.k@gmail.com'),
	('Subaru','Nastuki','+375 29 456-45-75','subarunotcar@gmail.com'),
	('Grunt','Urdnot','+375 44 123-79-67','gruntthebest@gmail.com'),
	('Vova','Potin','+375 33 754-45-67','potin@gmail.com'),
	('John','Snow','+375 29 123-87-67','snow@gmail.com'),
	('Edward','Snowdan','+375 29 123-87-89','snowdan@gmail.com'),
	('Voronich','Irina','+375 29 435-49-67','voronich@gmail.com'),
