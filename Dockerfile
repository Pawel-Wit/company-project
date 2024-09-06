# Use JDK 21 base image from Docker Hub
FROM openjdk:21

# Set working directory
WORKDIR /app

# Copy the built jar file to the container
COPY target/company-crud.jar /app/company-crud.jar

# Expose port (change to the port your app uses)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "company-crud.jar"]

