create table produtos(
    id INT not null auto_increment,
    nome VARCHAR2(255),
    preco FLOAT,
    descricao VARCHAR2(255),
    fabricante_id int,

    PRIMARY KEY(id),
    FOREIGN KEY(fabricante_id)
)

create table fabricantes(
    id INT not null auto_increment,
    nome VARCHAR2(255),
    
    PRIMARY KEY(id),
)