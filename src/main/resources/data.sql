INSERT INTO product (id, name, type, weight) VALUES
(1, 'Apple1', 1, 1.00),
(2, 'Apple1', 1, 1.00),
(3, 'Apple1', 1, 2.00),
(4, 'Pear1', 1, 2.00),
(5, 'Pear1', 1, 2.00),
(6, 'Pear1', 1, 1.00);

INSERT INTO product_price (product_id, prise, valid_from) VALUES
(1, 3.00, '2023-01-01 00:00:00'),
(2, 3.00, '2023-01-01 00:00:00'),
(3, 3.00, '2023-01-01 00:00:00'),
(4, 5.00, '2023-01-01 00:00:00'),
(5, 7.00, '2023-01-01 00:00:00'),
(6, 8.00, '2023-01-01 00:00:00');


INSERT INTO supplier (name) VALUES
('John'),
('Fred'),
('Andrew');
