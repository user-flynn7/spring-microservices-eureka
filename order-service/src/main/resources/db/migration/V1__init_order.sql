CREATE TABLE orders
(
    id                  BIGSERIAL PRIMARY KEY,
    quantity            INTEGER                     NOT NULL,
    order_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    -- Embedded UserSnapshot fields
    user_id             BIGINT                      NOT NULL,
    user_name           VARCHAR(255),
    user_email          VARCHAR(255),

    -- Embedded ProductSnapshot fields
    product_id          BIGINT                      NOT NULL,
    product_name        VARCHAR(255),
    product_description TEXT,
    product_price       DOUBLE PRECISION
);