# Spring Master 5 Test Drives - Test Drives Reminders

---

## 1. Spring Boot Starter Test Dependency

`JUnit`, `Spring Test & Spring Boot Test`, `AssertJ`, `Hamcrest`, `Mockito`, `JSONassert`, `JsonPath`

## 2. Write operations in actuators

|Operation|URL|Method|Command|
|---|---|---|---|
|Rebuild Integration Graph|http://localhost:8081/actuator/integrationgraph|POST| curl 'http://localhost:8081/actuator/integrationgraph' -i -X POST|
|Setup Log Levels|http://localhost:8080/actuator/loggers/{path}|POST| see module [car-parts](dev/src/jofisaes/jeorg-spring-master-5-test-drives/car-parts)|
|Shutdown the application|http://localhost:8080/actuator/shutdown|POST|curl 'http://localhost:8080/actuator/shutdown' -i -X POST
|Drain and return the application startup steps|http://localhost:8080/actuator/startup|POST|curl 'http://localhost:8080/actuator/startup' -i -X POST

## 3. Default Actuator endpoints

`health`, `info`

## 4. Default Logger groups

| Group Name | Package / Class | 
|---|---|
|web | org.springframework.core.codec, org.springframework.http, org.springframework.web |
|sql | org.springframework.jdbc.core, org.hibernate.SQL |

## 5. Spring MVC / Spring REST / JAX-RS / JERSEY

1. JAX-RS is a specification of RESTful web services
2. JERSEY is an implementation of JAX-RS
3. Spring REST specifies RESTful web services in an alternative way
4. Spring MVC provides annotations to implement REST services and the MVC pattern

## 6. SecurityContextHolder modes

`MODE_GLOBAL`, `MODE_INHERITABLETHREADLOCAL`, `MODE_THREADLOCAL`, `SYSTEM_PROPERTY`

## 7. Where can we use SpEL?

We can use SpEL on a variaty of annotations that support SpEL. The ones I dentified so far are:

1. [@PropertySource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html)
2. [@PreAuthorize](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreAuthorize.html)
3. [@PostAuthorize](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostAuthorize.html)
4. [@PreFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PreFilter.html)
5. [@PostFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/access/prepost/PostFilter.html)
6. [@Value](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html)

## 8. Spring provides the following Mock Objects

1. Environment
2. JNDI
3. Servlet API
3. Portlet API

## 9. HATEOAS automatic configuration

1. ObjectMapper
2. LinkDiscoverer
3. [@EnableHypermediaSupport](https://docs.spring.io/spring-hateoas/docs/current/api/org/springframework/hateoas/config/EnableHypermediaSupport.html)

## 10 @Transactional propagation modes

1. `MANDATORY` - A transaction must exist
2. `NESTED` - Exectus withing a nested transaction
3. `NOT_SUPPORTED` - Stops existing transactions, if any, and executes non-transactional.
4. `REQUIRED` - Always runs in a transactional mode and creates a new transaction if none exists
5. `REQUIRES_NEW` - Creates a new transaction regardless if one already exist
6. `SUPPORTS` - Always executes a query regardless of a transaction exists or not. It will only execute transactional if a transaction already exists.

## 11 Supported MVC template engines

1. Thymeleaf
2. Groovy Markup Templates
3. Velocity & FreeMarker
4. JSP & JSTL
5. Script templates
	1. Handlebars
	2. Mustache
	3. React
	4. EJS
	5. ERB
	6. String templates
6. XSLT
7. Document views (PDF/Excel)
8. JSON Mapping View
9. XML Mapping View

## 12 Transaction API's supported by spring

1. JDO
2. JTA
3. JPA
4. Hibernate
5. JDBC

---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md)
