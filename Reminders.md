# Spring Master 5 Test Drives Reminders

## 1. Spring Boot Starter Test Dependency

`JUnit`, `Spring Test & Spring Boot Test`, `AssertJ`, `Hamcrest`, `Mockito`, `JSONassert`, `JsonPath`

## 2. Write operations in actuators

|Operation|URL|Method|Command|
|---|---|---|---|
|Rebuild Integration Graph|http://localhost:8081/actuator/integrationgraph|POST| curl 'http://localhost:8081/actuator/integrationgraph' -i -X POST|
|Setup Log Levels|http://localhost:8080/actuator/loggers/{path}|POST| see module [car-parts](./car-parts)|
|Shutdown the application|http://localhost:8080/actuator/shutdown|POST|curl 'http://localhost:8080/actuator/shutdown' -i -X POST
|Drain and return the application startup steps|http://localhost:8080/actuator/startup|POST|curl 'http://localhost:8080/actuator/startup' -i -X POST

## 3. Default Actuator endpoints

`health`, `info`

## 4. Default Logger groups

| Group Name | Package / Class | 
|---|---|
|web | org.springframework.core.codec, org.springframework.http, org.springframework.web |
|sql | org.springframework.jdbc.core, org.hibernate.SQL |


---

[Back](./README.md)
