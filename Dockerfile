# Etapa 1: Construção
FROM ubuntu:latest AS build
WORKDIR /app

# Instala o OpenJDK 17 e Maven no contêiner Ubuntu
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven

# Copia os arquivos do projeto para o contêiner
COPY . .

# Compila o projeto e cria o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM openjdk:17-jdk-slim
WORKDIR /app

# Expõe a porta padrão da aplicação
EXPOSE 8080

# Copia o .jar gerado na etapa de build para o contêiner final
COPY --from=build /app/target/testsa-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
