CREATE TABLE IF NOT EXISTS person (
                                        id BIGSERIAL PRIMARY KEY,
                                        nome VARCHAR(80) NOT NULL,
    sobrenome VARCHAR(80) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    genero VARCHAR(6) NOT NULL
    );