CREATE DATABASE "20251_fatec_ipi_poo_p2_Minecraft";

CREATE TABLE tb_jogador_minecraft(
    cod_jogador SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    prob_madeira FLOAT NOT NULL,
    prob_construir FLOAT NOT NULL,
    prob_minerar FLOAT NOT NULL,
    num_vitorias INT NOT NULL,
    num_derrotas INT NOT NULL
);

INSERT INTO tb_jogador_minecraft(
    nome, 
    prob_madeira, 
    prob_construir, 
    prob_minerar, 
    num_vitorias, 
    num_derrotas
)
VALUES
('Steve', 0.3, 0.6, 0.1, 0, 0),
('Alex', 0.3, 0.3, 0.4, 0, 0);