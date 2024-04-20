# Use the official Maven image for a build stage
FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
# Pre-download dependencies to cache them
RUN mvn -f /home/app/pom.xml dependency:go-offline

# Then attempt to build
RUN mvn -f /home/app/pom.xml clean package -DskipTests


# Use OpenJDK for running the application
FROM openjdk:17-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
