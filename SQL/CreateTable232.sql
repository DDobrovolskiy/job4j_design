CREATE TABLE publishers (
	publisher_id int PRIMARY KEY,
	publisher_name varchar(10),
	country varchar(10)
);

INSERT INTO publishers VALUES
(1, 'Unikod', 'Russia'),
(2, 'Vostok', 'Russia'),
(3, 'Bilbo', 'Belarussia'),
(4, 'Central', 'UK');

CREATE TABLE books (
	book_id int PRIMARY KEY,
	book_name varchar(32),
	publisher_id int REFERENCES publishers(publisher_id)
);

INSERT INTO books VALUES
(1, 'Histeria', 1),
(2, 'Moskovia', 1),
(3, 'Garry Potter', 4),
(4, 'Bat''ko!', 3);
