# syntax=docker/dockerfile:1.4
ARG BUILDPLATFORM
ARG TARGETPLATFORM

# build stage runs on the builder's platform (won't try to pull an armv7 maven image)
FROM --platform=${BUILDPLATFORM} maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn -B package -DskipTests && ls -la /app/target/*.jar

# runtime stage: pull the armv7 runtime image (this tag exists as arm32v7/eclipse-temurin)
FROM --platform=${TARGETPLATFORM} arm32v7/eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
