-- Inserir dados na tabela Usuario
INSERT INTO Usuario (nomeCompleto, cpf_cnpj, dataNascimento, genero, telefone, email, senha, categoria)
VALUES 
('João Silva', '12345678909', '1985-06-15', 'Masculino', '11987654321', 'joao.silva@email.com', 'hashed_password_1', 'Cliente'),
('Maria Oliveira', '98765432100', '1990-04-20', 'Feminino', '11912345678', 'maria.oliveira@email.com', 'hashed_password_2', 'Cliente');

-- Inserir dados na tabela Endereco
INSERT INTO Endereco (cidade, latitude, longitude, rua, bairro, numero, complemento, estado, fk_id_usuario)
VALUES 
('São Paulo', -23.5505, -46.6333, 'Rua A', 'Centro', 123, 'Apto 45', 'SP', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva')),
('Rio de Janeiro', -22.9068, -43.1729, 'Rua B', 'Copacabana', 456, '', 'RJ', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'));

-- Inserir dados na tabela Marinheiro
INSERT INTO Marinheiro (categoria, registroMaritimo, nome_, disponibilidade, anosExperiencia, fk_id_usuario)
VALUES 
('Pescador', 'RM123456', 'Carlos Santos', 'Disponível', 5, (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva')),
('Capitão', 'RM654321', 'Ana Costa', 'Indisponível', 10, (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'));

-- Inserir dados na tabela Embarcacao
INSERT INTO Embarcacao (nome, anoFabricacao, tamanho, capacidade, categoria, enderecoEmbarque, disponibilidade, imagem, pet, quantidadeBanheiro, quantidadeCabines, inscricao_IMO, bandeira, fk_id_usuario, fk_id_endereco)
VALUES 
('Barco Azul', '2015-01-01', 25.0, 10, 'Pesca', 'Marina A', TRUE, 'url_imagem_1', FALSE, 2, 3, 'IMO123456', 'Brasil', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva'), (SELECT id_endereco FROM Endereco WHERE rua = 'Rua A')),
('Yate Luxo', '2020-05-15', 40.0, 12, 'Luxo', 'Marina B', TRUE, 'url_imagem_2', TRUE, 3, 5, 'IMO654321', 'Brasil', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'), (SELECT id_endereco FROM Endereco WHERE rua = 'Rua B'));

-- Inserir dados na tabela Pagamento
INSERT INTO Pagamento (banco, numeroCartao, metodoPagamento, valor, dataPagamento)
VALUES 
('Banco do Brasil', '1234567890123456', 'Cartão de Crédito', 1500.00, '2023-10-01'),
('Itaú', '9876543210123456', 'Transferência', 2000.00, '2023-10-05');

-- Inserir dados na tabela Agendamento
INSERT INTO Agendamento (dataInicio, status, dataFinal, fk_id_usuario, fk_id_marinheiro, fk_id_embarcacao)
VALUES 
('2023-11-01', 'Confirmado', '2023-11-05', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva'), (SELECT id_marinheiro FROM Marinheiro WHERE nome_ = 'Carlos Santos'), (SELECT id_embarcacao FROM Embarcacao WHERE nome = 'Barco Azul')),
('2023-11-10', 'Pendente', '2023-11-15', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'), (SELECT id_marinheiro FROM Marinheiro WHERE nome_ = 'Ana Costa'), (SELECT id_embarcacao FROM Embarcacao WHERE nome = 'Yate Luxo'));

-- Inserir dados na tabela Avaliacao
INSERT INTO Avaliacao (comentario, notaMarinheiro, notaEmbarcacao, notaAgendamento, fk_id_usuario, fk_id_agendamento, fk_id_marinheiro, fk_id_embarcacao)
VALUES 
('Ótimo serviço!', 9.5, 8.0, 9.0, (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva'), (SELECT id_agendamento FROM Agendamento WHERE dataInicio = '2023-11-01'), (SELECT id_marinheiro FROM Marinheiro WHERE nome_ = 'Carlos Santos'), (SELECT id_embarcacao FROM Embarcacao WHERE nome = 'Barco Azul')),
('Experiência incrível!', 10.0, 9.0, 10.0, (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'), (SELECT id_agendamento FROM Agendamento WHERE dataInicio = '2023-11-10'), (SELECT id_marinheiro FROM Marinheiro WHERE nome_ = 'Ana Costa'), (SELECT id_embarcacao FROM Embarcacao WHERE nome = 'Yate Luxo'));

-- Inserir dados na tabela Documentos
INSERT INTO Documentos (status, fk_id_usuario, documento, nome)
VALUES 
('Aprovado', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva'), 'documento_em_bytes_1', 'Documentação Barco Azul'),
('Pendente', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'), 'documento_em_bytes_2', 'Documentação Yate Luxo');

-- Inserir dados na tabela usuario_pagamento
INSERT INTO usuario_pagamento (id_usuario, id_pagamento)
VALUES 
((SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva'), (SELECT id_pagamento FROM Pagamento WHERE banco = 'Banco do Brasil')),
((SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'), (SELECT id_pagamento FROM Pagamento WHERE banco = 'Itaú'));

-- Inserir dados na tabela ContaBanco
INSERT INTO ContaBanco (banco, numeroConta, agencia, fk_id_usuario)
VALUES 
('Banco do Brasil', '123456', '1234', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva')),
('Itaú', '654321', '4321', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'));

-- Inserir dados na tabela AprovacaoDocumento
INSERT INTO AprovacaoDocumento (fk_id_documento, status_aprovacao, data_aprovacao, observacoes, fk_id_usuario)
VALUES 
((SELECT id_documento FROM Documentos WHERE nome = 'Documentação Barco Azul'), 'Aprovado', '2023-10-15', 'Documentação completa.', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'João Silva')),
((SELECT id_documento FROM Documentos WHERE nome = 'Documentação Yate Luxo'), 'Pendente', '2023-10-20', 'Aguardando revisão.', (SELECT id_usuario FROM Usuario WHERE nomeCompleto = 'Maria Oliveira'));
INSERT INTO ImagemEmbarcacao (id_imagem, nome, imagem, fk_id_embarcacao)
VALUES 

insert into  ImagemEmbarcacao ( imagem) 
SELECT BulkColumn 
FROM Openrowset( Bulk '...\Downloads\image.png', Single_Blob) as img