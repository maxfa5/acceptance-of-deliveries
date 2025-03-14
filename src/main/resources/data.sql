
-- Вставка данных в таблицу product, избегая дубликатов по id
INSERT INTO product (id, name, type, weight)
SELECT 1, 'Apple1', 1, 1.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 1);

INSERT INTO product (id, name, type, weight)
SELECT 2, 'Apple1', 1, 1.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 2);

INSERT INTO product (id, name, type, weight)
SELECT 3, 'Apple1', 1, 2.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 3);

INSERT INTO product (id, name, type, weight)
SELECT 4, 'Pear1', 1, 2.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 4);

INSERT INTO product (id, name, type, weight)
SELECT 5, 'Pear1', 1, 2.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 5);

INSERT INTO product (id, name, type, weight)
SELECT 6, 'Pear1', 1, 1.00
WHERE NOT EXISTS (SELECT 1 FROM product WHERE id = 6);


-- Вставка данных в таблицу product_price, избегая дубликатов по product_id и valid_from (предполагаем, что это уникальная комбинация)
INSERT INTO product_price (product_id, prise, valid_from)
SELECT 1, 3.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 1 AND valid_from = '2023-01-01 00:00:00');

INSERT INTO product_price (product_id, prise, valid_from)
SELECT 2, 3.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 2 AND valid_from = '2023-01-01 00:00:00');

INSERT INTO product_price (product_id, prise, valid_from)
SELECT 3, 3.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 3 AND valid_from = '2023-01-01 00:00:00');

INSERT INTO product_price (product_id, prise, valid_from)
SELECT 4, 5.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 4 AND valid_from = '2023-01-01 00:00:00');

INSERT INTO product_price (product_id, prise, valid_from)
SELECT 5, 7.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 5 AND valid_from = '2023-01-01 00:00:00');

INSERT INTO product_price (product_id, prise, valid_from)
SELECT 6, 8.00, '2023-01-01 00:00:00'
WHERE NOT EXISTS (SELECT 1 FROM product_price WHERE product_id = 6 AND valid_from = '2023-01-01 00:00:00');


-- Вставка данных в таблицу supplier, избегая дубликатов по name (предполагая, что имя уникально)
INSERT INTO supplier (name)
SELECT 'John'
WHERE NOT EXISTS (SELECT 1 FROM supplier WHERE name = 'John');

INSERT INTO supplier (name)
SELECT 'Fred'
WHERE NOT EXISTS (SELECT 1 FROM supplier WHERE name = 'Fred');

INSERT INTO supplier (name)
SELECT 'Andrew'
WHERE NOT EXISTS (SELECT 1 FROM supplier WHERE name = 'Andrew');