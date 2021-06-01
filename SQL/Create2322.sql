create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

INSERT INTO devices VALUES
(1, 'keyboard', 100),
(2, 'mouse', 90),
(3, 'micropfon', 45);

create table people(
    id serial primary key,
    name varchar(255)
);

INSERT INTO people VALUES
(1, 'Dima'),
(2, 'Kolya'),
(3, 'Sveta');

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

INSERT INTO devices_people (device_id, people_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);