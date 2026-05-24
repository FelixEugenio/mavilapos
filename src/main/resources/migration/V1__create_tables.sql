CREATE TABLE categories (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       active BOOLEAN DEFAULT TRUE
);

CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          barcode VARCHAR(100),
                          price NUMERIC(10,2) NOT NULL,
                          stock INTEGER NOT NULL,
                          minimum_stock INTEGER,
                          active BOOLEAN DEFAULT TRUE,
                          category_id BIGINT REFERENCES categories(id)
);