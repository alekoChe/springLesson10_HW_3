
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, purchase_price int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, price, purchase_price)
VALUES
    ('Product1', 10, 6),
    ('Product2', 15, 10),
    ('Product3', 20, 12),
    ('Product4', 3, 1),
    ('Product5', 19, 15),
    ('Product6', 25, 17),
    ('Product7', 40, 20),
    ('Product8', 55, 35),
    ('Product9', 17, 10),
    ('Product10', 85, 70),
    ('Product11', 27, 11),
    ('Product12', 5, 1),
    ('Product13', 105, 65),
    ('Product14', 155, 100),
    ('Product15', 30, 10),
    ('Product16', 7, 6),
    ('Product17', 19, 12),
    ('Product18', 65, 45),
    ('Product19', 29, 10),
    ('Product20', 3, 1),
    ('Product21', 33, 18);