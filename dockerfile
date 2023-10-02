FROM openjdk:11-jre-slim
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvn dependency:go-offline
COPY src ./src
CD ["./mvnw","springboot:run"]
