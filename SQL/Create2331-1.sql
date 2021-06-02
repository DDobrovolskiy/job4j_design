CREATE TABLE automobiles (
	automobile_id serial PRIMARY KEY,
	automobile_name varchar(32) NOT NULL,
	kuzov_id int NOT NULL,
	engine_id int NOT NULL,
	gear_id int NOT NULL
);

INSERT INTO automobiles VALUES
(1, 'Land Cruser', 5, 2, 1),
(2, 'Camry', 1, 2, 2),
(3, 'BMW x6', 2, 3, 1),
(4, 'I30', 3, 1, 4);