-- 1 --
CREATE TABLE departments (
	department_id serial PRIMARY KEY,
	department_name varchar(32) NOT NULL
);

INSERT INTO departments VALUES
(1, 'Administration'),
(2, 'Industrial'),
(3, 'Agraric'),
(4, 'Eduation');

CREATE TABLE emploees (
	emploee_id serial PRIMARY KEY,
	emploee_name varchar(32) NOT NULL,
	department_id int NOT NULL
);

INSERT INTO emploees VALUES
(1, 'Gregory G.', 1),
(2, 'Wendy S.', 1),
(3, 'Bill M.', 2),
(4, 'Mott N.', 4),
(5, 'Nika S.', 4);