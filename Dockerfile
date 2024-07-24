 # Use the official OpenJDK 21 image as the base image
 FROM openjdk:21-jdk-slim as build

 # Set the working directory in the container
 WORKDIR /app

 # Install Maven
 RUN apt-get update && apt-get install -y maven

 # Copy the pom.xml and src directory
 COPY pom.xml .
 COPY src ./src

 # Build the application
 RUN mvn clean package -DskipTests

 # Create a new stage for the runtime image
 FROM openjdk:21-jdk-slim

 # Set the working directory in the container
 WORKDIR /app

 # Copy the built JAR file from the build stage
 COPY --from=build /app/target/*.jar app.jar

 # Expose the port the app runs on
 EXPOSE 8080

 # ONBUILD instruction for child images
 ONBUILD COPY . /app

 # Run the application
 CMD ["java", "-jar", "app.jar"]