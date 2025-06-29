# Build stage
FROM gradle:8.7-jdk17 AS build
WORKDIR /workspace/app

# Copy Gradle files
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

# Download dependencies
RUN gradle --no-daemon dependencies

# Copy source code
COPY src ./src

# Build the application
RUN gradle --no-daemon bootJar

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /workspace/app/build/libs/*.jar app.jar

# Expose the application port (default Spring Boot port)
EXPOSE 8080

# Set the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]