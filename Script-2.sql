-- ============================================================
-- SIMULADO SAEP 1
-- SISTEMA DE HOSPITAL PEDIÁTRICO
-- ============================================================
CREATE DATABASE IF NOT EXISTS saep_simulado_1;
USE saep_simulado_1;


-- ============================================================
-- LIMPEZA DAS TABELAS
-- Permite executar novamente o script sem conflito
-- ============================================================

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS consulta;
DROP TABLE IF EXISTS dependente;
DROP TABLE IF EXISTS responsavel;
DROP TABLE IF EXISTS usuario;

SET FOREIGN_KEY_CHECKS = 1;


-- ============================================================
-- TABELA: USUARIO
-- ============================================================

CREATE TABLE if not exists usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);


-- ============================================================
-- TABELA: RESPONSAVEL
-- ============================================================

CREATE TABLE if not exists responsavel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARBINARY(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100)
);


-- ============================================================
-- TABELA: DEPENDENTE
-- ============================================================

CREATE TABLE if not exists dependente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(20),
    alergias VARCHAR(255),
    responsavel_id INT NOT NULL,

    CONSTRAINT fk_dependente_responsavel
        FOREIGN KEY (responsavel_id)
        REFERENCES responsavel(id)
);


-- ============================================================
-- TABELA: CONSULTA
-- ============================================================

CREATE TABLE if not exists consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dependente_id INT NOT NULL,
    data_consulta DATE NOT NULL,
    horario TIME NOT NULL,
    motivo VARCHAR(255),

    CONSTRAINT fk_consulta_dependente
        FOREIGN KEY (dependente_id)
        REFERENCES dependente(id)
);


-- ============================================================
-- DADOS INICIAIS: USUARIOS
-- Senha padrão: 1234
-- ============================================================

INSERT INTO usuario
    (nome, login, senha)
VALUES
    ('Administrador',
     'admin',
     SHA2('1234', 256)),

    ('Recepcao Pediatrica',
     'recepcao',
     SHA2('1234', 256)),

    ('Atendimento',
     'atendimento',
     SHA2('1234', 256));


-- ============================================================
-- DADOS INICIAIS: RESPONSAVEIS
-- CPF armazenado criptografado
-- ============================================================

INSERT INTO responsavel
    (nome, cpf, telefone, email)
VALUES
    (
        'Mariana Costa',
        AES_ENCRYPT('11122233344', 'chave_saep_2026'),
        '47999991111',
        'mariana@email.com'
    ),
    (
        'Rafael Martins',
        AES_ENCRYPT('22233344455', 'chave_saep_2026'),
        '47999992222',
        'rafael@email.com'
    ),
    (
        'Juliana Alves',
        AES_ENCRYPT('33344455566', 'chave_saep_2026'),
        '47999993333',
        'juliana@email.com'
    );


-- ============================================================
-- DADOS INICIAIS: DEPENDENTES
-- ============================================================

INSERT INTO dependente
    (
        nome,
        data_nascimento,
        sexo,
        alergias,
        responsavel_id
    )
VALUES
    (
        'Lucas Costa',
        '2018-05-12',
        'Masculino',
        'Nenhuma alergia informada',
        1
    ),
    (
        'Sofia Martins',
        '2020-08-20',
        'Feminino',
        'Alergia a dipirona',
        2
    ),
    (
        'Pedro Alves',
        '2017-03-15',
        'Masculino',
        'Alergia a amoxicilina',
        3
    );


-- ============================================================
-- DADOS INICIAIS: CONSULTAS
-- ============================================================

INSERT INTO consulta
    (
        dependente_id,
        data_consulta,
        horario,
        motivo
    )
VALUES
    (
        1,
        '2026-10-05',
        '09:00:00',
        'Consulta de rotina'
    ),
    (
        2,
        '2026-10-05',
        '10:30:00',
        'Avaliacao de quadro febril'
    ),
    (
        3,
        '2026-10-06',
        '14:00:00',
        'Retorno pediatrico'
    );


-- ============================================================
-- VERIFICACAO
-- ============================================================

SHOW TABLES;

SELECT * FROM usuario;

SELECT
    id,
    nome,
    CAST(
        AES_DECRYPT(cpf, 'chave_saep_2026')
        AS CHAR
    ) AS cpf,
    telefone,
    email
FROM responsavel;

SELECT * FROM dependente;

SELECT * FROM consulta;


-- ============================================================
-- CONSULTA COMPLETA
-- CONSULTA + DEPENDENTE + RESPONSAVEL
-- ============================================================

SELECT
    c.id AS id_consulta,
    c.data_consulta,
    c.horario,
    c.motivo,

    d.id AS id_dependente,
    d.nome AS nome_dependente,
    d.data_nascimento,
    d.sexo,
    d.alergias,

    r.id AS id_responsavel,
    r.nome AS nome_responsavel,

    CAST(
        AES_DECRYPT(
            r.cpf,
            'chave_saep_2026'
        ) AS CHAR
    ) AS cpf_responsavel,

    r.telefone,
    r.email

FROM consulta AS c

INNER JOIN dependente AS d
    ON c.dependente_id = d.id

INNER JOIN responsavel AS r
    ON d.responsavel_id = r.id

ORDER BY
    c.data_consulta ASC,
    c.horario ASC;