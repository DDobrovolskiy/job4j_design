-- 5 --
SELECT m.name, w.name
FROM teens AS m
CROSS JOIN teens AS w
WHERE w.gender = 'W' AND m.gender = 'M'