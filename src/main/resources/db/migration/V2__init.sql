CREATE TABLE IF NOT EXISTS buyers (
    id bigserial,
    name VARCHAR(255),
    phone_number VARCHAR(255),
    pass VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO products (name, phone_number, pass)
VALUES
    ('name 01', '000001', '001'),
    ('name 02', '000002', '002'),
    ('name 03', '000003', '003'),
    ('name 04', '000004', '004'),
    ('name 05', '000005', '005');

CREATE TABLE IF NOT EXISTS orders (
    id bigserial,
    buyer_id int,
    pass VARCHAR(255)
    PRIMARY KEY(id)
);