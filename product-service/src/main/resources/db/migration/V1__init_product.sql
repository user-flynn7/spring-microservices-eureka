CREATE TABLE product
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255)     NOT NULL,
    description TEXT,
    price       DOUBLE PRECISION NOT NULL,
    stock       INTEGER          NOT NULL
);

INSERT INTO product (name, description, price, stock)
VALUES ('Quantum Flux Capacitor', 'A component for multiversal drives', 1999.99, 12),
       ('Neural Lace Adapter', 'Connects brainwaves to the cloud', 499.50, 30),
       ('Dark Matter Battery', 'High-density energy source', 899.00, 18),
       ('Holographic Display Module', 'Projects 3D interfaces in mid-air', 1299.75, 25),
       ('Nano-Assembler Kit', 'Builds molecules from scratch', 1499.00, 10);