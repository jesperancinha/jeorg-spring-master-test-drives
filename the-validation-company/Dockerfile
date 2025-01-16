FROM debian:bullseye-slim

WORKDIR /app

COPY the-validation-company-jre /app/the-validation-company-jre

COPY build/libs/the-validation-company.jar /app/app.jar

ENV PATH="/app/the-validation-company-jre/bin:$PATH"

CMD ["java", "-Dspring.context.exit=onRefresh", "-jar", "/app/app.jar"]
