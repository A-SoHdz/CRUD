INSERT INTO tbl_categories(id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories(id, name) VALUES (2, 'books');
INSERT INTO tbl_categories(id, name) VALUES (3, 'electronics');

INSERT INTO tbl_products(id, name, description, stock, price, status, create_at, category_id)
VALUES (1, 'Nike', 'Nike, Air Force 1/ black and white', 58, 20.10,'created', '2022-07-06','1' )

INSERT INTO tbl_products(id, name, description, stock, price, status, create_at, category_id)
VALUES (2, 'IT', 'horror novel published in 1986 by American writer Stephen King', 30, 15.00,'created', '2022-06-17','2' )

INSERT INTO tbl_products(id, name, description, stock, price, status, create_at, category_id)
VALUES (3, 'Spring Boot', 'It is a solution to create applications based on Spring in a fast, autonomous way and with desirable characteristics for production.',
 87, 5.10,'created', '2022-06-20','3' )
