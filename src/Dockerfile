# FROM ubuntu: lastest AS build
# RUN apt-get update
# RUN apt-get install openjdk-17-jdk -y
# COPY . .

# RUN apt-get install maven -y
# RUN mvn clean install

# FROM openjdk:17-jdk-slim

# EXPOSE 8080

# COPY --from=build target/testsa-0.0.1-SNAPSHOT.jar

# ENTRYPOINT ["java", : "-jar", :"SNAPSHOT.jar" ]


# Etapa 1: Construção
FROM ubuntu:latest AS build
WORKDIR /app

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
