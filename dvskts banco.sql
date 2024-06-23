CREATE DATABASE dvskts_1;
USE dvskts_1;

CREATE TABLE clientes (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    senha VARCHAR(45),
    email VARCHAR(100),
    cpf VARCHAR(11),
    telefone VARCHAR(11),
    status INT NOT NULL DEFAULT 1
);

INSERT INTO clientes (nome, senha, status) VALUES
('admin', 'admin', 2), 
('Bruno', '123', 1);

CREATE TABLE categorias (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45)
);

CREATE TABLE produtos (
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    descricao VARCHAR(50),
    preco FLOAT,
    quantidade INT,
    imagem VARCHAR(255),
    categoria INT,
    FOREIGN KEY (categoria) REFERENCES categorias(idCategoria)
);

CREATE TABLE carrinho (
    idCarrinho INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT,
    idProduto INT,
    preco FLOAT,
    total FLOAT,
    quantidade INT,
    imagem VARCHAR(255),
    FOREIGN KEY (idCliente) REFERENCES clientes(idCliente),
    FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)
);

CREATE TABLE endereco (
    idEndereco INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT,
    cep VARCHAR(255),
    rua VARCHAR(255),
    numero VARCHAR(255),
    bairro VARCHAR(255),
    complemento VARCHAR(255),
    FOREIGN KEY (idCliente) REFERENCES clientes(idCliente)
);

CREATE TABLE estoque (
    idEstoque INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    quantidade INT,
    FOREIGN KEY (idEstoque) REFERENCES produtos(idProduto)
);

SELECT * FROM clientes;
SELECT * FROM produtos;
