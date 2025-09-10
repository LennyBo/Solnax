# syntax=docker/dockerfile:1.4
ARG BUILDPLATFORM=linux/amd64
ARG TARGETPLATFORM=linux/arm/v7

FROM --platform=${BUILDPLATFORM} maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -B package -DskipTests

FROM --platform=${TARGETPLATFORM} arm32v7/eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
