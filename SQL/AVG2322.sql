SELECT AVG(price)
FROM devices;

SELECT p.name, AVG(price) AS Средняя_цена
FROM people AS p
JOIN devices_people AS dp ON p.id = dp.people_id
JOIN devices AS d ON dp.device_id = d.id
GROUP BY p.name
ORDER BY Средняя_цена DESC;

SELECT p.name, AVG(price) AS Средняя_цена
FROM people AS p
JOIN devices_people AS dp ON p.id = dp.people_id
JOIN devices AS d ON dp.device_id = d.id
GROUP BY p.name
HAVING AVG(price) > 70
ORDER BY Средняя_цена DESC;