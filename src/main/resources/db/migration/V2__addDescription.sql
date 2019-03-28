ALTER TABLE PRODUCTS ADD description VARCHAR(255);

INSERT INTO PRODUCTS (id, name, current_price, description)
VALUES (5, 'migratedProduct', '4.10', 'migration works!');