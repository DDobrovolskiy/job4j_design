SELECT automobile_name, kuzov_name, engine_name, gear_name
FROM automobiles
JOIN kuzov USING (kuzov_id)
JOIN engines USING (engine_id)
JOIN gears USING (gear_id);

SELECT kuzov_name, automobile_name
FROM kuzov
LEFT JOIN automobiles USING (kuzov_id)
WHERE automobile_name IS NULL;

SELECT engine_name, automobile_name
FROM engines
LEFT JOIN automobiles USING (engine_id)
WHERE automobile_name IS NULL;

SELECT gear_name, automobile_name
FROM gears
LEFT JOIN automobiles USING (gear_id)
WHERE automobile_name IS NULL;