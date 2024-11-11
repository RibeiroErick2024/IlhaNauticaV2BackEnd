--  http://localhost:8080/h2-console

-- Inserir dados na tabela Usuario
INSERT INTO Usuario (id_usuario, nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria)
VALUES 
('a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'João Silva', '12345678901', '1985-03-15', 'Masculino', '11987654321', 'joao.silva@email.com', 'senha123', 'Cliente');

-- Inserir dados na tabela Endereco
INSERT INTO Endereco (id_endereco, cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('c7f34a68-6873-4d79-92fe-dfa67fe2cc1e', 'São Paulo', -23.550520, -46.633308, 'Av. Paulista', 'Bela Vista', 1000, 'Apto 501', 'SP', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b');

-- Inserir dados na tabela Embarcacao
INSERT INTO Embarcacao (id_embarcacao, nome, anoFabricacao, tamanho, capacidade, categoria, enderecoEmbarque, disponibilidade, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario, fk_id_endereco)
VALUES 
('b23f42e2-7e3d-4c68-bdc6-09027dff0fbb', 'Embarcação Azul', '2020-05-01', 15.0, 20, 'Luxo', 'Porto 1', TRUE, TRUE, 2, 5, 'IMO12345', 'Brasil', 'a3e2e11d-4b7a-47f1-b3fc-812f3c3a9b8b', 'c7f34a68-6873-4d79-92fe-dfa67fe2cc1e');

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