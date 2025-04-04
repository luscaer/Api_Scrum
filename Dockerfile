FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /appc
COPY --from=builder /app/target/api_scrum-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 1894
ENTRYPOINT ["java", "-jar", "app.jar"]