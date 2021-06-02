-- 2 --
SELECT department_name, emploee_name
FROM departments
LEFT JOIN emploees USING (department_id);

SELECT department_name, emploee_name
FROM departments
RIGHT JOIN emploees USING (department_id);

SELECT department_name, emploee_name
FROM departments
FULL JOIN emploees USING (department_id);
-- 3 --
SELECT department_name, emploee_name
FROM departments
LEFT JOIN emploees USING (department_id)
WHERE emploee_name IS NULL;
-- 4 --
SELECT department_name, emploee_name
FROM departments
LEFT JOIN emploees USING (department_id);

SELECT department_name, emploee_name
FROM emploees
RIGHT JOIN departments USING (department_id);