insert into role (role) values ('Admin'), ('Midle'), ('Junior');
insert into rules (rule) values ('Absolute'), ('Programming'), ('Take to koffe');
insert into users (name, id_role) values ('Petr', 1), ('Dima', 2), ('Sveta', 2), ('Alex', 3);
insert into role_rules (id_role, id_rules) values (1, 1), (1, 2), (2, 2), (3, 2), (3, 3);
insert into state (state) values ('Complite'), ('In progress'), ('Not begin');
insert into category (category) values ('Fast'), ('Slow');
insert into items (text, id_user, id_category, id_state) values
	('Doesnt working server', 2, 1, 1),
	('Buy koffe!!!', 1, 1, 2),
	('Working at home', 3, 2, 3);
insert into attachs (URL, id_item) values ('http:\\www.myKoffe.com\latte', 2);
insert into comments (text, id_item) values ('FAST!!!', 2);