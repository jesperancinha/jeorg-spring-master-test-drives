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

Via Http: `health`, `info`
Via JMS: All of them

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
2. `NESTED` - Executes withing a nested transaction. It behaves as `REQUIRED` if no transaction exists.
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

## 13 Spring Factories functions

1. Activate Listeners
2. Add more auto-configuration candidates

## 14 @WebMvcTest Autoconfiguration

1. Disables full auto-configuration 
2. Enables configuration related to MVC tests
3. @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver beans
4. @Component, @Service or @Repository do not get configured
5. Spring Security and MockMvc (include support for HtmlUnit WebClient and Selenium WebDriver).
6. @AutoConfigureMockMvc annotation can be used as an alternative


## 15. Spring  Test Dependency

1. JUnit support
2. Mockito support
3. Doest not include AssertJ
4. It supports EasyMock


## 16. Bean Scopes

1. Singleton (`singleton`)
2. Prototype (`prototype`)
3. Request (`request`)
4. Session (`session`)
5. Global Session (`global-session`)

## 17 [Configuration order](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-external-config)

1. Devtools global settings properties in the $HOME/.config/spring-boot directory when devtools is active.
2. @TestPropertySource annotations on your tests.
3. Test property attributes. Examples are @SpringBootTest and test annotations.
4. Command line arguments.
5. Properties from `SPRING_APPLICATION_JSON` (inline JSON embedded in an environment variable or system property).
6. ServletConfig init parameters.
7. ServletContext init parameters.
8. JNDI attributes from `java:comp/env`.
9. Java System properties (`System.getProperties()`).
10. OS environment variables.
11. A `RandomValuePropertySource` that has properties only in `random.*`.
12. `Profile-specific application properties` outside packaged jar (application-{profile}.properties and YAML variants).
13. `Profile-specific application properties` packaged inside jar (application-{profile}.properties and YAML variants).
14. `Application properties` outside of your packaged jar (application.properties and YAML variants).
15. `Application properties` packaged inside your jar (application.properties and YAML variants). 
16. `@PropertySource` annotations on `@Configuration` classes.
17. Default properties (specified by setting SpringApplication.setDefaultProperties).

## 18 [Supported Pointcut Designators](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-pointcuts-designators)

`execution`, `within`, `this`, `target`, `within`, `this`, `target`, `args`, `@target`, `@args`, `@within`, `@annotation`, `args`, `@target`, `@args`, `@within`, `@annotation`

---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md)
