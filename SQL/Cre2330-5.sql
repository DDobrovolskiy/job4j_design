-- 5 --
CREATE TABLE teens (
	id serial PRIMARY KEY,
	name varchar(32) NOT NULL,
	gender varchar(1) NOT NULL CHECK( gender = 'M' OR gender = 'W')
);

INSERT INTO teens VALUES
(1, 'Dima', 'M'),
(2, 'Sergey', 'M'),
(3, 'Vanya', 'M'),
(4, 'Sveta', 'W'),
(5, 'Masha', 'W'),
(6, 'Lena', 'W');