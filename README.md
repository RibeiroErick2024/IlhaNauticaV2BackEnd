# IlhaNauticaBackEnd2024- Backend ⛵


O **ILHA NAUTICA** é uma solução inovadora que automatiza o processo de aluguel de quadras de futebol, simplificando a experiência tanto para jogadores quanto para donos de quadras. Este repositório contém o código-fonte do backend, desenvolvido com **Java Spring** e integrado ao banco de dados **PostgreSQL**.

---

## Funcionalidades Principais 🎯

- **Cadastro e Gerenciamento de Usuários**: Criação, edição e exclusão de perfis.  
- **Reserva de Embarcações**: Agendamento rápido e intuitivo.  
- **Gerenciamento de Embarcações**: Adição e remoção de embarcações .  
- **Testes Automatizados**: Garantia de qualidade com cobertura de testes para as principais funcionalidades.  

---

## Tecnologias Utilizadas 🛠️

- **Java Spring Framework**: Criação e gerenciamento de APIs RESTful.  
- **PostgreSQL**: Banco de dados relacional robusto para armazenamento e manipulação de dados.  
- **Spring Data JPA**: Mapeamento objeto-relacional simplificado.  
- **Spring Boot**: Configuração e inicialização rápida do projeto.  
- **Spring Security**: Implementação de autenticação e autorização.  
- **JUnit e Mockito**: Frameworks para testes unitários e de integração.  

---

## Requisitos de Instalação 📋

- **Java 17** ou superior.  
- **Maven**: Para gerenciamento de dependências.  
- **PostgreSQL**: Configurado localmente ou em um servidor remoto.  
- **Banco de dados h2**: O H2 Banco de Dadosé um banco de dadosmodo embarcado servidor . É leve, rápido
---

## Configuração do Projeto 🚀

1. Clone o repositório:  
   ```bash
   git clone https://github.com/RibeiroErick2024/IlhaNauticaV2BackEnd.git

   ```

2. Configure o banco de dados no arquivo `application.properties`:  
   ```properties
**PostgreSQL**
 Configurações do banco de dados
 spring.datasource.url=${DB_URL}
 spring.datasource.username=${DB_USERNAME}
 spring.datasource.password=${DB_PASSWORD}
 spring.datasource.driver-class-name=org.postgresql.Driver
 spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
 

**Banco de dados h2**
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.h2.console.enabled=true
  ```

3. Compile e execute o projeto:  
   ```bash
   mvn spring-boot:run
   ```

---

## Executando os Testes

Para garantir a qualidade do código, o projeto inclui testes automatizados para as principais funcionalidades.  

1. Para executar os testes, use o seguinte comando:  
   ```bash
   mvn test
   ```  

2. Ferramentas utilizadas nos testes:  
   - **JUnit 5**: Para testes unitários.  
   - **Mockito**: Para mocks e simulação de dependências.  


---

## Endpoints Disponíveis

### Usuários  
- `GET /usuarios`: Retorna a lista de usuários.  
- `POST /usuarios`: Cria um novo usuário.  
- `PUT /usuarios/{id}`: Atualiza as informações de um usuário.  
- `DELETE /usuarios/{id}`: Remove um usuário.  

### Reservas  
- `GET /reservas`: Lista todas as reservas.  
- `POST /reservas`: Cria uma nova reserva.  
- `DELETE /reservas/{id}`: Cancela uma reserva existente.  

---

## Contribuição 🤝

Contribuições são bem-vindas! Para colaborar:  

1. Faça um fork do repositório.  
2. Crie uma nova branch para a sua funcionalidade ou correção:  
   ```bash
   git checkout -b minha-feature
   ```  
3. Envie suas alterações:  
   ```bash
   git push origin minha-feature
   ```  
4. Abra um Pull Request detalhando as mudanças.  

---

## Autor

O **ILHA NAUTICA** foi desenvolvido com foco em facilitar o aluguel de embarcações e proporcionar  experiências, intuitiva para todos os usuários.

---

## Licença 📄

Este projeto é licenciado sob a [MIT License](LICENSE).
```
