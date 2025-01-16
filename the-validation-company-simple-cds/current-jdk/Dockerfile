FROM debian:bullseye-slim

WORKDIR /app

COPY current /app/current

COPY the-validation-company-simple-cds.jar /app/app.jar

ENV PATH="/app/current/bin:$PATH"

CMD ["java", "-jar", "/app/app.jar"]
