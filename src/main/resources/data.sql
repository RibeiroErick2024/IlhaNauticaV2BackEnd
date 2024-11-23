--  http://localhost:8080/h2-console

-- Inserir dados na tabela Usuario

INSERT INTO Role (id, nome) VALUES (1, 'USER');
INSERT INTO Usuario (id_usuario, nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria, role_id)
VALUES 
('a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'João Silva', '12345678901', '1985-03-15', 'Masculino', '11987654321', 'joao.silva@email.com', 'senha123', 'Cliente', 1);

INSERT INTO Usuario (id_usuario, nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria)
VALUES 
('b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'Maria Oliveira', '98765432109', '1990-07-25', 'Feminino', '21987654321', 'maria@email.com', '$2a$10$Nx1rnokrfOIMMB8rZeCa8eS9MYMz.heshqb.uD6e2436dcPh.GU5S', 'Administrador');

INSERT INTO Endereco (id_endereco, cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('d72bceff-6489-44d7-b370-bb7b4408cfd6', 'Rio de Janeiro', -22.906847, -43.172896, 'Rua do Ouvidor', 'Centro', 150, 'Sala 305', 'RJ', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab');

-- Inserir dados na tabela Endereco
INSERT INTO Endereco (id_endereco, cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'São Paulo', -23.550520, -46.633308, 'Av. Paulista', 'Bela Vista', 1000, 'Apto 501', 'SP', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b');

-- Inserir dados na tabela Embarcacao
INSERT INTO Embarcacao (id_embarcacao, nome, anoFabricacao, fabricante, tamanho, potencia, preco, capacidade, categoria, enderecoEmbarque, disponibilidade, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario)
VALUES 
('b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'Embarcação Azul', 2024, 'Yamaha', 300, 900, 15.0, 20, 'Jet Ski', 'Porto 1', TRUE, TRUE, 2, 5, 'IMO12345', 'Brasil', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab');

INSERT INTO Embarcacao (id_embarcacao, nome, anoFabricacao, fabricante, tamanho, potencia, preco, capacidade, categoria, enderecoEmbarque, disponibilidade, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario, fk_id_endereco)
VALUES 
('d62f3c72-8b23-4d35-94f1-6451e1b18d19', 'Embarcação Verde', 2022, 'DeltaYatchs', 12.60, 54, 12.5, 15, 'Conforto', 'Porto 2', TRUE, FALSE, 1, 3, 'IMO67890', 'Brasil', 'b8a93d7d-6f5c-4cfa-8b23-6d95d699f2ab', 'd72bceff-6489-44d7-b370-bb7b4408cfd6');

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
INSERT INTO Marinheiro (id_marinheiro, nome, categoria, registroMaritimo, disponibilidade, anosExperiencia, fk_id_usuario)
VALUES 
('fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'Carlos Alberto', 'Capitão', '123456', 'Disponível', 5, 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b');

-- Inserir dados na tabela Agendamento
INSERT INTO Agendamento (id_agendamento, dataInicio, status, dataFinal, fk_id_usuario, fk_id_marinheiro, fk_id_embarcacao)
VALUES 
('a728f3e1-9c67-46f0-a3b2-9d0dcd8043c5', '2024-12-01', 'Confirmado', '2024-12-10', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');

-- Inserir dados na tabela Avaliacao
-- INSERT INTO Avaliacao (id_avaliacao, comentario, notaMarinheiro, notaEmbarcacao, notaAgendamento, fk_id_usuario, fk_id_agendamento, fk_id_marinheiro, fk_id_embarcacao)
-- VALUES 
-- ('d517c2e9-d1f4-4b49-90c2-e5fc83f91e56', 'Excelente serviço!', 4.5, 4.0, 5.0, 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'a728f3e1-9c67-46f0-a3b2-9d0dcd8043c5', 'fc83bcb0-ea6c-4f7d-bf01-d8b23d4ff2c5', 'b23f42e2-7e3d-4c68-bdc6-09027dff0fbb');
