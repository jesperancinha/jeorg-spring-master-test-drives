FROM eclipse-temurin:21-jre

WORKDIR /app

COPY the-validation-company.jar /app/app.jar

CMD ["java", "-Dspring.context.exit=onRefresh", "-jar", "/app/app.jar"]
