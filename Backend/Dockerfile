# Stage 1: Build the Spring Boot JAR
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /Backend

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Compile and package
RUN mvn clean package -DskipTests

# Stage 2: Run the Spring Boot app
FROM eclipse-temurin:17-jre-alpine
WORKDIR /Backend


# Copy built JAR from build stage
COPY --from=build /Backend/target/*.jar products.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "products.jar"]
