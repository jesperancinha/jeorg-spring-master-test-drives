FROM debian:bullseye-slim

WORKDIR /app

COPY the-validation-company-jre /app/the-validation-company-jre

# Copy the application JAR
COPY build/libs/the-validation-company.jar /app/app.jar

# Set the PATH to use the custom JRE
ENV PATH="/app/custom-jre/bin:$PATH"

# Run the application
CMD ["java", "-jar", "/app/app.jar"]
