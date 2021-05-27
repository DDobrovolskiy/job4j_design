create table role (
    id serial primary key,
	role varchar(255) not null,
	unique (role)
);
create table rules (
    id serial primary key,
	rule varchar(255) not null unique
);
create table users (
	id serial primary key,
    name varchar(255) not null,
	id_role int references role(id),
	unique (name)
);
create table role_rules (
	id serial primary key,
	id_role int references role (id),
	id_rules int references rules (id)
);
create table state (
	id serial primary key,
	state varchar(255) not null unique
);
create table category (
	id serial primary key,
	category varchar(255) not null unique
);
create table items (
	id serial primary key,
	text varchar(255) not null,
	id_user int references users (id),
	id_category int references category (id),
	id_state int references state (id)
);
create table attachs (
	id serial primary key,
	URL varchar(255) not null,
	id_item int references items(id)
);
create table comments (
	id serial primary key,
	text text,
	id_item int references items(id)
);