# Docker Assignment – Spring Boot + PostgreSQL

## Project Overview
This project demonstrates a Spring Boot application running with PostgreSQL using Docker and Docker Compose. It includes multi-stage build, networking, volumes, and security practices.

---

## Technologies Used
- Java
- Spring Boot
- PostgreSQL
- Docker
- Docker Compose

---

## Dockerfile (Multi-Stage Build)

```dockerfile
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
COPY --from=build /app/target/dockerApp.jar app.jar
USER appuser
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]



Run Project
docker compose up --build

Docker Network
docker network create my-app-network

Volumes
docker volume create postgres-data

Backup Volume
docker run --rm -v postgres-data:/source -v %cd%:/backup alpine tar czf /backup/backup.tar.gz -C /source .

Security Features
Non-root user used
Least privilege container
Image scanning supported
Docker Bench security audit used

Docker Bench Security
docker run --rm --privileged docker/docker-bench-security

Conclusion
This project shows how to containerize a Spring Boot application with PostgreSQL using Docker with security and best practices.