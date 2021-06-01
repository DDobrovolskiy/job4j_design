SELECT book_name, publisher_name
FROM books AS b
JOIN publishers AS p ON b.publisher_id = p.publisher_id;

SELECT book_name, publisher_name
FROM books AS b
JOIN publishers AS p ON b.publisher_id = p.publisher_id
WHERE book_name LIKE 'M%';

SELECT book_name AS Книга , publisher_name AS Издательство
FROM books AS b
JOIN publishers AS p USING(publisher_id)
WHERE country IN ('Russia', 'Belarussia')
ORDER BY book_name