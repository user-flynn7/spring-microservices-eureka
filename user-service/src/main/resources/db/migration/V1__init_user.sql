CREATE TABLE users
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);

INSERT INTO users (name, email)
VALUES ('Alice Ray', 'alice@example.com'),
       ('Bob Singh', 'bob@example.com'),
       ('Charlie Zhao', 'charlie@example.com'),
       ('Diana Patel', 'diana@example.com'),
       ('Evan Kim', 'evan@example.com');