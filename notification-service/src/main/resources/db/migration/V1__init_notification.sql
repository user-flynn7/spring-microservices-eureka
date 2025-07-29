CREATE TABLE notification
(
    id                  BIGSERIAL PRIMARY KEY,

    user_id             BIGINT                      NOT NULL,
    order_id            BIGINT                      NOT NULL,
    order_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    -- Embedded ProductSnapshot fields
    product_id          BIGINT                      NOT NULL,
    product_name        VARCHAR(255),
    product_price       DOUBLE PRECISION,
    product_description VARCHAR(255),

    quantity            INTEGER                     NOT NULL,
    timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL
);