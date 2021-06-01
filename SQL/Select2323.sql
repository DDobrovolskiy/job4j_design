SELECT p.name AS Продукты
FROM product AS p
JOIN type ON p.type_id = type.id
WHERE type.name = 'Сыр';

SELECT name
FROM product
WHERE name LIKE '%мороженное%';

SELECT name
FROM product
WHERE expired_date < CURRENT_DATE;

SELECT name, price
FROM product
WHERE price = (SELECT MAX(price) FROM product);

SELECT t.name, COUNT(p.name) AS Количество
FROM type AS t
JOIN product AS p ON t.id = p.type_id
GROUP BY t.name
ORDER BY Количество DESC;

SELECT p.name
FROM product AS p
JOIN type AS t ON t.id = p.type_id
WHERE t.name IN ('Сыр', 'Молоко');

SELECT t.name, COUNT(p.name) AS Количество
FROM type AS t
JOIN product AS p ON t.id = p.type_id
GROUP BY t.name
HAVING COUNT(p.name) < 10
ORDER BY Количество DESC;

SELECT p.name, t.name
FROM product AS p
JOIN type AS t ON t.id = p.type_id
