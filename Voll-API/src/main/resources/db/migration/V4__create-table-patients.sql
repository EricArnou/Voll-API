CREATE TABLE patients(
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) NOT NULL UNIQUE,
                        cpf VARCHAR(6) NOT NULL UNIQUE,
                        phone VARCHAR(20) NOT NULL,
                        place VARCHAR(100) NOT NULL,
                        neighborhood VARCHAR(100) NOT NULL,
                        cep VARCHAR(9) NOT NULL,
                        state VARCHAR(2) NOT NULL,
                        city VARCHAR(100) NOT NULL,
                        "number" VARCHAR(20),
                        complement VARCHAR(100)
);