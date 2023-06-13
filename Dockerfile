# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8080

CMD ["./app/mvnw", "spring-boot:run"]
