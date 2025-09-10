# syntax=docker/dockerfile:1.4

ARG BUILDPLATFORM=linux/amd64
ARG TARGETPLATFORM=linux/arm/v7

# build stage runs on builder’s platform (no need for armv7 maven image)
FROM --platform=${BUILDPLATFORM} maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn -B package -DskipTests && ls -la /app/target/*.jar

# runtime stage runs on target platform (armv7)
FROM --platform=${TARGETPLATFORM} arm32v7/eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
