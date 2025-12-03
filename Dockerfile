# Use the official Maven image with Java 17 to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copy the pom.xml file
COPY pom.xml .
# Copy the source directory
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK runtime (Java 17) as the base image for the runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose port 8080 (or whatever port your app uses, default for Spring Boot)
EXPOSE 8080
# Run the application
CMD ["java", "-jar", "app.jar"]