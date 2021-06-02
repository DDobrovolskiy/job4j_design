CREATE TABLE kuzov (
	kuzov_id serial PRIMARY KEY,
	kuzov_name varchar(32) NOT NULL
);

INSERT INTO kuzov VALUES
(1, 'Sedan'),
(2, 'Hetchback'),
(3, 'Liftback'),
(4, 'Cabriolet'),
(5, 'Truck');

CREATE TABLE engines (
	engine_id serial PRIMARY KEY,
	engine_name varchar(32) NOT NULL
);

INSERT INTO engines VALUES
(1, 'Honda'),
(2, 'Toyota'),
(3, 'BMW'),
(4, 'LADA');

CREATE TABLE gears (
	gear_id serial PRIMARY KEY,
	gear_name varchar(32) NOT NULL
);

INSERT INTO gears VALUES
(1, 'Auto'),
(2, 'Robot'),
(3, 'Variator'),
(4, 'Mechanics');