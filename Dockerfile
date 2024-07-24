# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-21 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and project files
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Install dependencies and build the application
RUN ./mvnw clean install

# Use the official OpenJDK image to run the application
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
