INSERT INTO tb_autor (created_At,nome, email, descricao) VALUES (NOW(), 'Cristina', 'cristina@gmail.com', 'fazendo comentários');

INSERT INTO tb_categoria (nome) VALUES ('Eletronicos');

INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_de_paginas,isbn,data_publicacao, autor_id, categoria_id) VALUES
('Clean Code', 'Não precisa segui fielmente o livro', 'Algo aqui', 75.00, 140, 1342245, '2022-10-28', 1, 1);

INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_de_paginas,isbn,data_publicacao, autor_id, categoria_id) VALUES
('Arquitetura Limpa', 'Livro complexo', 'Dificil entendimento', 55.00, 260, 4312452, '2021-11-30', 1, 1);

INSERT INTO tb_pais (nome) VALUES ('Estados Unidos');
INSERT INTO tb_pais (nome) VALUES ('Portugal');
INSERT INTO tb_pais (nome) VALUES ('Brasil');
INSERT INTO tb_pais (nome) VALUES ('Afeganistão');
INSERT INTO tb_pais (nome) VALUES ('Australia');
INSERT INTO tb_pais (nome) VALUES ('Bélgica');

INSERT INTO tb_estado (nome, pais_id) VALUES ('Texas', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Whashington', 1);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Beja', 2);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Bahia', 3);
INSERT INTO tb_estado (nome, pais_id) VALUES ('Recife', 3);
INSERT INTO tb_estado (nome, pais_id) VALUES ('São Paulo', 3);

INSERT INTO tb_cliente (nome, sobre_nome, email, cpf_ou_cnpj, endereco, complemento, cidade, pais_id, estado_id, telefone, cep)
VALUES('Jefferson', 'Oliveira', 'jefferson@gmail.com', '9804927282', 'Rua São Jose', 'Apartamento', 'Porto Seguro', 3, 3, 98727818, 2887428);

INSERT INTO tb_cliente (nome, sobre_nome, email, cpf_ou_cnpj, endereco, complemento, cidade, pais_id, estado_id, telefone, cep)
VALUES('Madre', 'Teresa', 'madre@gmail.com', '532336334', 'Rua Mauricio Lima', 'Casa', 'Maria Quiteria', 2, 2, 42434, 623243434);


