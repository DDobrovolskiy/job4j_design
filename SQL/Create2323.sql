CREATE TABLE type (
	id serial PRIMARY KEY,
	name varchar(32)
);

INSERT INTO type VALUES
(1, 'Молоко'),
(2, 'Сыр'),
(3, 'Картошка'),
(4, 'Сахар'),
(5, 'Хлеб');

CREATE TABLE product (
	id serial PRIMARY KEY,
	name varchar(32),
	type_id int,
	expired_date date, 
	price float
);

INSERT INTO product VALUES
(1, 'Ванильное мороженное', 1, '2021-06-05', 50),
(2, 'Шоколадное мороженное', 1, '2021-05-31', 75),
(3, 'Голландский сыр', 2, '2021-08-15', 300),
(4, 'Белебеевский сыр', 2, '2021-05-11', 550),
(5, 'Лимончела', 4, '2022-05-31', 15),
(6, 'Чипсы', 3, '2021-12-31', 155),
(7, 'Батон', 5, '2021-06-11', 45),
(8, 'Булка', 5, '2021-06-11', 65),
(9, 'Бублик', 5, '2021-06-11', 32),
(10, 'Пирожок', 5, '2021-06-11', 11),
(11, 'Черный хлеб', 5, '2021-06-11', 57),
(12, 'Белый хлеб', 5, '2021-06-11', 69),
(13, 'Серый хлеб', 5, '2021-06-11', 47),
(14, 'Ржаной хлеб', 5, '2021-06-11', 48),
(15, 'Реж хлеб', 5, '2021-06-11', 68),
(16, 'Старый хлеб', 5, '2021-06-11', 10),
(17, 'Новый хлеб', 5, '2021-06-11', 79),
(18, 'Макфа хлеб', 5, '2021-06-11', 54)
