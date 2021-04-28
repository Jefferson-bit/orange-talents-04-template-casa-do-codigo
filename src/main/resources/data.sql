INSERT INTO tb_autor (created_At,nome, email, descricao) VALUES (NOW(), 'Cristina', 'cristina@gmail.com', 'fazendo comentários');
INSERT INTO tb_categoria (nome) VALUES ('Eletronicos');
INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_de_paginas,isbn,data_publicacao, autor_id, categoria_id) VALUES
('Clean Code', 'Não precisa segui fielmente o livro', 'Algo aqui', 75.00, 140, 1342245, '2022-10-28', 1, 1);

INSERT INTO tb_livro (titulo,resumo,sumario,preco,numero_de_paginas,isbn,data_publicacao, autor_id, categoria_id) VALUES
('Arquitetura Limpa', 'Livro complexo', 'Dificil entendimento', 55.00, 260, 4312452, '2021-11-30', 1, 1);