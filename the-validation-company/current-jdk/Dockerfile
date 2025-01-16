FROM debian:bullseye-slim

WORKDIR /app

COPY current /app/current

COPY the-validation-company.jar /app/app.jar

ENV PATH="/app/current/bin:$PATH"

CMD ["java", "-Dspring.context.exit=onRefresh", "-jar", "/app/app.jar"]
