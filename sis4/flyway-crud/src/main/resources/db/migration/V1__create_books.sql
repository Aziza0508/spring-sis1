CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published_year INT,
    isbn VARCHAR(32),
    created_at TIMESTAMP DEFAULT NOW()
);