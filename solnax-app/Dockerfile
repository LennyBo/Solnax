FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/solnax-app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]