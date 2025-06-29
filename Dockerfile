# Use an OpenJDK runtime as the base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your build directory to the container
COPY build/libs/lv-0.0.1-SNAPSHOT-plain.jar lv-0.0.1.jar

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "lv-0.0.1.jar"]