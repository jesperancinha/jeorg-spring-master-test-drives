FROM debian:bullseye-slim

WORKDIR /app

COPY the-validation-company-jre /app/the-validation-company-jre

COPY build/libs/the-validation-company.jar /app/app.jar

ENV PATH="/app/the-validation-company-jre/bin:$PATH"

CMD ["java", "-jar", "/app/app.jar"]
