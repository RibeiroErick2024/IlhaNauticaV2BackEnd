--  http://localhost:8080/h2-console

INSERT INTO Role (id, nome) 
VALUES 
(1, 'ADMIN'),(2, 'USER');
INSERT INTO Usuario (id_usuario, nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria, fk_id_role)
VALUES 
('a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'João Silva', '12345678901', '1985-03-15', 'Masculino', '11987654321', 'joao.silva@email.com', '$2a$10$1Nz2rmdu/Eqeo4jvdOfVrueZ.LYx2/DxJac0xEsuXV3XFfGBQPT.W"', 'Geral', 2), --Senha123!
('69a2f19b-9d59-4852-8f88-161bd94ccecb','Administrador Sistema', '000000000', '1985-05-01', 'Masculino', '11987654321', 'admin@exemplo.com', '$2a$10$865sbUSyphcLmY13hIZtguR9bWPWq5RRAQdAsBpJpgBpMqItDG8NO', 'Admin', 1),  --Admin123!
('b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'Maria Oliveira', '98765432109', '1990-07-25', 'Feminino', '21987654321', 'maria@email.com', '$2a$10$Nx1rnokrfOIMMB8rZeCa8eS9MYMz.heshqb.uD6e2436dcPh.GU5S', 'Locador', 2); -- Senha456!


INSERT INTO Endereco (id_endereco, cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('d72bceff-6489-44d7-b370-bb7b4408cfd6', 'Rio de Janeiro', -22.906847, -43.172896, 'Rua do Ouvidor', 'Centro', 150, 'Sala 305', 'RJ', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab'),
('c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'São Paulo', -23.550520, -46.633308, 'Av. Paulista', 'Bela Vista', 1000, 'Apto 501', 'SP', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b');

-- Inserir dados na tabela Embarcacao
INSERT INTO Embarcacao (id_embarcacao, nome, anoFabricacao, fabricante, tamanho, potencia, preco, capacidade, categoria, enderecoEmbarque, disponibilidade, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario, fk_id_endereco, regras, descricao) 
VALUES 
('b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'Embarcação Azul', 2024, 'Yamaha', 300, 900, 15.0, 20, 'Jet Ski', 'Porto 1', TRUE, TRUE, 2, 5, 'IMO12345', 'Brasil', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'Somente marinheiros com habilitação para Jet Ski podem operar', 'Embarcação rápida e ideal para aventuras aquáticas, com capacidade para 20 pessoas.'),
('d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'Embarcação Verde', 2022, 'DeltaYatchs', 12.60, 54, 12.5, 15, 'Conforto', 'Porto 2', TRUE, FALSE, 1, 3, 'IMO67890', 'Brasil', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'd72bceff-6489-44d7-b370-bb7b4408cfd6', 'Apenas marinheiros com experiência em navegação de luxo', 'Embarcação confortável para passeios longos, com cabines e banheiros para mais conforto.');

INSERT INTO ImagemEmbarcacao(id_imagem, nome, imagem, fk_id_embarcacao, formato)
VALUES
('88', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-1.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('87', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-2.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('86', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-3.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('85', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-4.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('84', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-5.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('100', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-1.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('101', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-2.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('102', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-3.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('103', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-4.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('104', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-5.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg');

-- Inserir dados na tabela Marinheiro
INSERT INTO Marinheiro (id_marinheiro, nome, categoria, registroMaritimo, disponibilidade, cpf_cnpj, datanascimento, genero, telefone, email, fk_id_usuario) 
VALUES
('fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'Carlos Alberto', 'Jet Ski', '123456', 'Disponível', '12345678901', '1980-06-15', 'Masculino', '11987654321', 'carlos@example.com', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b'),
('8f62cba1-14f7-471f-b4e9-6f762283e1c6', 'João Pedro', 'Iate', '654321', 'Indisponível', '98765432109', '1992-11-20', 'Masculino', '11912345678', 'joao@example.com', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab');

-- Inserir dados na tabela Agendamento
INSERT INTO Agendamento (id_agendamento, dataInicio, status, dataFinal, fk_id_usuario, fk_id_marinheiro, fk_id_embarcacao)
VALUES 
('a728f3e1-9c67-46f0-a3b2-9d0dcd8043c5', '2024-12-01', 'Confirmado', '2024-12-10', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');

INSERT INTO Avaliacao (id_avaliacao, comentario, notamarinheiro, notaembarcacao, notaagendamento, fk_id_usuario, fk_id_embarcacao)
VALUES 
(1, 'Ótima experiência, marinheiro muito experiente e embarcação excelente!', 5, 5, 5, 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');



--  http://localhost:8080/h2-console

INSERT INTO Role (id, nome) 
VALUES 
(1, 'ADMIN'),(2, 'USER');
INSERT INTO Usuario (id_usuario, nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria, fk_id_role)
VALUES 
('a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'João Silva', '12345678901', '1985-03-15', 'Masculino', '11987654321', 'joao.silva@email.com', '$2a$10$1Nz2rmdu/Eqeo4jvdOfVrueZ.LYx2/DxJac0xEsuXV3XFfGBQPT.W"', 'Geral', 2), --Senha123!
('69a2f19b-9d59-4852-8f88-161bd94ccecb','Administrador Sistema', '000000000', '1985-05-01', 'Masculino', '11987654321', 'admin@exemplo.com', '$2a$10$865sbUSyphcLmY13hIZtguR9bWPWq5RRAQdAsBpJpgBpMqItDG8NO', 'Admin', 1),  --Admin123!
('b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'Maria Oliveira', '98765432109', '1990-07-25', 'Feminino', '21987654321', 'maria@email.com', '$2a$10$Nx1rnokrfOIMMB8rZeCa8eS9MYMz.heshqb.uD6e2436dcPh.GU5S', 'Locador', 2); -- Senha456!


INSERT INTO Endereco (id_endereco, cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('d72bceff-6489-44d7-b370-bb7b4408cfd6', 'Rio de Janeiro', -22.906847, -43.172896, 'Rua do Ouvidor', 'Centro', 150, 'Sala 305', 'RJ', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab'),
('c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'São Paulo', -23.550520, -46.633308, 'Av. Paulista', 'Bela Vista', 1000, 'Apto 501', 'SP', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b');

-- Inserir dados na tabela Embarcacao
INSERT INTO Embarcacao (id_embarcacao, nome, anoFabricacao, fabricante, tamanho, potencia, preco, capacidade, categoria, enderecoEmbarque, disponibilidade, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario, fk_id_endereco, regras, descricao) 
VALUES 
('b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'Embarcação Azul', 2024, 'Yamaha', 300, 900, 15.0, 20, 'Jet Ski', 'Porto 1', TRUE, TRUE, 2, 5, 'IMO12345', 'Brasil', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'Somente marinheiros com habilitação para Jet Ski podem operar', 'Embarcação rápida e ideal para aventuras aquáticas, com capacidade para 20 pessoas.'),
('d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'Embarcação Verde', 2022, 'DeltaYatchs', 12.60, 54, 12.5, 15, 'Conforto', 'Porto 2', TRUE, FALSE, 1, 3, 'IMO67890', 'Brasil', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'd72bceff-6489-44d7-b370-bb7b4408cfd6', 'Apenas marinheiros com experiência em navegação de luxo', 'Embarcação confortável para passeios longos, com cabines e banheiros para mais conforto.');

INSERT INTO ImagemEmbarcacao(id_imagem, nome, imagem, fk_id_embarcacao, formato)
VALUES
('88', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-1.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('87', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-2.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('86', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-3.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('85', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-4.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('84', 'Delta 41', FILE_READ('src/main/resources/static/veleiro/delta/delta-5.webp'),'d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'image/webp'),
('100', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-1.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('101', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-2.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('102', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-3.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('103', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-4.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg'),
('104', 'Yamaha VX-C', FILE_READ('src/main/resources/static/jetski/yamaha-jetski-5.jpg'),'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'image/jpeg');

-- Inserir dados na tabela Marinheiro
INSERT INTO Marinheiro (id_marinheiro, nome, categoria, registroMaritimo, disponibilidade, cpf_cnpj, datanascimento, genero, telefone, email, fk_id_usuario) 
VALUES
('fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'Carlos Alberto', 'Jet Ski', '123456', 'Disponível', '12345678901', '1980-06-15', 'Masculino', '11987654321', 'carlos@example.com', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b'),
('8f62cba1-14f7-471f-b4e9-6f762283e1c6', 'João Pedro', 'Iate', '654321', 'Indisponível', '98765432109', '1992-11-20', 'Masculino', '11912345678', 'joao@example.com', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab');

-- Inserir dados na tabela Agendamento
INSERT INTO Agendamento (id_agendamento, dataInicio, status, dataFinal, fk_id_usuario, fk_id_marinheiro, fk_id_embarcacao)
VALUES 
('a728f3e1-9c67-46f0-a3b2-9d0dcd8043c5', '2024-12-01', 'Confirmado', '2024-12-10', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');

INSERT INTO Avaliacao (id_avaliacao, comentario, notamarinheiro, notaembarcacao, notaagendamento, fk_id_usuario, fk_id_embarcacao)
VALUES 
(1, 'Ótima experiência, marinheiro muito experiente e embarcação excelente!', 5, 5, 5, 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');


