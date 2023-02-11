# car-parts 🛠

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/jeorg-spring-master-test-drives)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%205%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-master-test-drives)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/jeorg-spring-master-test-drives.svg)](#)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-master-test-drives)
[![jeorg-spring-master-test-drives](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml/badge.svg)](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-5-test-drives.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-5-test-drives/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/jeorg-spring-master-5-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/1d960e1b-0c52-4ac0-90eb-d4f06fc97ba0)](https://codebeat.co/projects/github-com-jesperancinha-jeorg-spring-master-5-test-drives-main)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/jeorg-spring-master-5-test-drives?branch=main)](https://bettercodehub.com/results/jesperancinha/jeorg-spring-master-5-test-drives)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-5-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-5-test-drives)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-5-test-drives/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/jeorg-spring-master-5-test-drives&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/jeorg-spring-master-5-test-drives/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/jeorg-spring-master-5-test-drives?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/jeorg-spring-master-5-test-drives/branch/main/graph/badge.svg?token=2Eh0Oh5ro2)](https://codecov.io/gh/jesperancinha/jeorg-spring-master-5-test-drives)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)

---

## Introduction

This is a car-parts application where we are going to make an inventory of items that belong to a car and of course learn Spring with it.

## Application Goals

### Goal 1 - Deployment with embedded Jetty Server

In order to get Jetty to run we need to remove Tomcat wich comes along with it:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

Then we can add our spring jetty server dependency:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

### Goal 2 - Using Actuator

First we need to add this dependency:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

By default, the actuator is activated and available on this address:

-  http://localhost:8081/actuator

And the endpoints available by default are health and info only:

1.  http://localhost:8081/actuator/health
2.  http://localhost:8081/actuator/info

We can also activate all health endpoints and only the health endpoints with:

```properties
management.endpoints.web.exposure.include=health
```

This is available with profile `health`.

I made these profiles manually. This means that I intentionally named the profiles available with the name of the actuator we are going to study.

We have a profile called `loggers`, which in this application will allow us to perform some write operations which will allow us to change the log-level of the application.

If we check the loggers endpoint in:

-   http://localhost:8081/actuator/loggers

we'll see a [JSON](./loggers.json) file like this one:

```json
{
  "levels": [
    "OFF",
    "ERROR",
    "WARN",
    "INFO",
    "DEBUG",
    "TRACE"
  ],
  "loggers": {
    "ROOT": {
      "configuredLevel": "INFO",
      "effectiveLevel": "INFO"
    },
    "com": {
      "configuredLevel": null,
      "effectiveLevel": "INFO"
    }
  },
  "groups": {
    "web": {
      "configuredLevel": null,
      "members": [
        "org.springframework.core.codec",
        "org.springframework.http",
        "org.springframework.web",
        "org.springframework.boot.actuate.endpoint.web",
        "org.springframework.boot.web.servlet.ServletContextInitializerBeans"
      ]
    },
    "sql": {
      "configuredLevel": null,
      "members": [
        "org.springframework.jdbc.core",
        "org.hibernate.SQL",
        "org.jooq.tools.LoggerListener"
      ]
    }
  }
}
```

In this file, we can see the log levels being assigned to packages and classes.

We can change this during the server runtime with a request like this:

```bash
curl -X "POST" "http://localhost:8081/actuator/loggers/ROOT" -H "Content-Type: application/json; charset=utf-8"   -d $'{ "configuredLevel": "TRACE" }'
```

We can observe that we see two logs configurations per package or class: `configuredLevel` and `effectiveLevel`.

These two variables follow a rule that may feel quite counter-intuitive.   
This is how it goes:

1.  When `configuredLevel` has a value then `effectiveLevel` is always the same.
2.  When `configuredLevel` is null, it means that the log inherits the level from the parent.
3.  The `configuredLevel` of `ROOT` can, of course, never be null.

We can configure both variables this way:

```bash
curl -X "POST" "http://localhost:8081/actuator/loggers/com" -H "Content-Type: application/json; charset=utf-8"   -d $'{ "effectiveLevel": "TRACE","configuredLevel":"INFO" }'
```

If we want to remove the `configuredLevel` value, we can just send an empty JSON to the matching endpoint:

```bash
curl -X "POST" "http://localhost:8081/actuator/loggers/com" -H "Content-Type: application/json; charset=utf-8"   -d $'{ }'
```

We can also change the logger groups.   
By default, Spring offers these pre-configured groups:

| Group Name | Package / Class | 
|---|---|
|web | org.springframework.core.codec, org.springframework.http, org.springframework.web |
| sql | org.springframework.jdbc.core, org.hibernate.SQL |

We can change them using a command like this:

```bash
curl -X "POST" "http://localhost:8081/actuator/loggers/web" -H "Content-Type: application/json; charset=utf-8"   -d $'{ "configuredLevel": "TRACE" }'
```

We can perform a variety of write operations using actuators:

|Operation|URL|Method|Command|
|---|---|---|---|
|Rebuild Integration Graph|http://localhost:8081/actuator/integrationgraph|POST| curl 'http://localhost:8081/actuator/integrationgraph' -i -X POST|
|Setup Log Levels|http://localhost:8080/actuator/loggers/{path}|POST| see above|
|Shutdown the application|http://localhost:8080/actuator/shutdown|POST|curl 'http://localhost:8080/actuator/shutdown' -i -X POST
|Drain and return the application startup steps|http://localhost:8080/actuator/startup|POST|curl 'http://localhost:8080/actuator/startup' -i -X POST

What's important is there there no other method request possibilities such as a PUT request possibility. Even for a change log we still send a POST. I do not know why a POST is warranted for a change log, but as decribed in the documentation, it has to be a POST.

### Goal 3 - The @Transactional annotation

The `@Transactional` annotation uses AOP proxies in order to create point-cuts for the target methods. Methods are run, this way within a transaction. There are several configurable params for this. They are `transactionManager` which is the `value`, `propagation`, `isolation`, `timeout`, `readOnly`, `rollbackFor`, `noRollbackFor`, `rollbackForClassName`, `noRollbackForClassName`.

In our module, we see that it is difficult to simulate a database timeout since we are working with an [H2](https://www.h2database.com/html/main.html) database. However,if we reduce the `timeout` to a minimum of 1 millisecond, then can see this `@Transactional` property in action, allowing us to test a multitude of variants.

In our case, we will test two distinct aspects of `@Transactional`:

1.  Timeout configuration in nested transactions. Test methods are `createPart` and `createPartTimeout`
2.  Calling inner methods annotated with the transactional annotation. Test methods are `createPartExtra` and `createPartMix`

If we run the unit tests we see that the Parent `@Transactional` on a class level, does not override the methods annotated with the same annotation. Instead, it defines the default configuration should the method not be annotated. The methods annotated with `@Transactional`, define a new `timeout` property. This means that, when we invoke the any method without any annotation, it will inherit the class timeout. In this case, it is 1ms, which, given that it is such a small figure, it will immediately timeout.

For point two we see that when we call the inner methods, we are no longer within the CGLIB proxy. Instead, calling the inner method, will just call the method as if it had no annotation on it. In this case, the proxy isn't called.

The proxy could be called though, if we use ASPECTJ as our transaction mode in `@EnableTransactionManagement`

### Goal 4 - Packaging multiple containers

We can package lots of wars and put them through a container, but essentially, one jar can only be served by one container at one given time.

This is done by the usage of the [spring maven plugin](https://docs.spring.io/spring-boot/docs/2.5.x/maven-plugin/reference/htmlsingle/). First we need to have something like [Docker Desktop](https://www.docker.com/products/docker-desktop).

Here is how can use this plugin:

```bash
mvn spring-boot:build-image
docker run docker.io/library/car-parts:1.0.0-SNAPSHOT
```

We can also customize our container build by changing the configuration from

```xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <image/>
    </configuration>
</plugin>
```

to

```xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <layers>
            <enabled>true</enabled>
        </layers>
        <image>
            <name>car-parts:${project.version}</name>
            <env>
                <BP_JVM_VERSION>14</BP_JVM_VERSION>
            </env>
        </image>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>build-image</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### Goal 5 - Packaging servlet containers

We can package a servlet container of our choice. If we go for an embedded solution, we can choose between Apache Tomcat, Eclipse Jetty or Red Hat Undertow.

In order to continue, let's first of all prevent our image to be created by the default `mvn clean install`. We remove the execution goal and define our MainClass:

```xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <layers>
            <enabled>true</enabled>
        </layers>
        <image>
            <name>car-parts:${project.version}</name>
            <env>
                <BP_JVM_VERSION>11</BP_JVM_VERSION>
            </env>
        </image>
        <mainClass>org.jesperancinha.smtd.carparts.CarPartsLauncher</mainClass>
    </configuration>
</plugin>
```

What is important to know at this point is that the Spring Boot plugin, needs to be instructed to repackage the resulting war create by maven, in the case we want to use an embedded servlet container. In our case we are using Jetty. The repackaging trigger is done by parameter `spring-boot:repackage`. Knowing this, we can creat a one-liner to create our war:

```bash
mvn clean install package spring-boot:repackage
```

We can start our war with a simple `java -jar` command:

```bash
java -jar target/car-parts-1.0.0-SNAPSHOT.war
```

### Goal 6 - Injecting Controllers

Controllers like `@Controller` or `@RestController`, can be injected and that is what we explore on the context unit test in the `CarPartsLauncherTest` class. All controllers can also be regarded as component. They inherit the annotation `@Component`.

Documentation:

1.  [@Controller](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Controller.html)
2.  [@RestController](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
3.  [@Component](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html)

In regard to annotations we need to pay attention to semantics and how annotated components are described. If we look at the documentation, we see that `@Controller` or `@RestController` inherit the `@Component` annotation. They are not referred as to actually being a component. This means that they are not effectively components, although they are treated pretty much as such.

### Goal 7 - Persisting in Cassandra.

The Spring framework does not provide DAO's to access Cassandra in a JPA fashion. Cassandra is a NoSQL database, which follows a very different paradigms. Instead, Spring offers [Spring Data For Apache Cassandra](https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#preface).

For this project, we could add an embedded Cassandra. We could use this one: [Embedded Cassandra](https://nosan.github.io/embedded-cassandra/2.0.4/), but we are using JDK 11, which means that this one won't work for now.   
Since I could not find any suitable candidate, I resorted to using docker for testing:

We download and run a cassandra docker image:

```bash
docker run -p 9042:9042 cassandra
```

In order to start with cassandra, we need the following dependencies:

```xml   
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-cassandra</artifactId>
</dependency>
```

The following are dependencies that are mandatory in order for spring to work. We can think of this in an analogous way as we do with JPA and the PostgreSQL, H2, MySQL dependencies and so forth. We need the correct drivers for this to work and in our case we are using the DataStax driver for Cassandra.

```xml   
<dependency>
	<groupId>com.datastax.oss</groupId>
	<artifactId>java-driver-core</artifactId>
</dependency>
<dependency>
	<groupId>com.codahale.metrics</groupId>
	<artifactId>metrics-core</artifactId>
</dependency>
```

### Goal 8 - Securing Actuator Endpoints

In current spring boot versions, there is no separate security configuration for the actuators. Instead, we can configure this using the [WebSecurityConfigurerAdapter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html). Overriding the [configure](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)) method, we can configure our [HttpSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html) object in order to secure only the `actuator` endpoints, just like we normally would with any other endpoint.

Probably the most basic way to secure an actuator endpoint is by configuring our application properties this way:

```properties
management.endpoints.web.exposure.include=*
spring.autoconfigure.exclude=
spring.security.user.name=admin
spring.security.user.password=admin
```

This way, all available actuator endpoints get to be available. We will be using BASIC authentication given that it is the most basic form, and we want to simplify our illustrations.

Further we need to make some changes in the code:

```java   
  http
        .authorizeRequests()
        .antMatchers("/actuator**")
        .authenticated()
        .and()
        .authorizeRequests()
        .antMatchers("/**")
        .permitAll()
        .and()
        .formLogin()
        .and()
        .csrf().disable();
```

This is just one of the most expressive ways to declare security constraints in Spring. One of the ways to read this is that, everytime we try to access a page, this chain will be triggered and only when a negative condition is found, will we get an unauthorized or unauthenticated message. On the other hand, the first positive constraint found will allow us to access the page. This is the reason why we find in many blog posts that it is better to start from the most restrictive constraint, to the more generic one. If we start restrictive, this means that we will get our application more protected. Remember that the chain follows this order for all the matches found. In our case both `/actuator**` and `/**` match. If we have not logged in yet, then the first match is analysed first. In our specific case, the `/actuator` is analysed first. The authentication fails and we get redirected to the login page.

### Goal 9 - ConditionalOnBean vs ConditionalOnClass

In regard to these two conditions about Bean generation, what we need to understand is that `name` means that we are refering to the canonical form of the class name or just a bean name depending on the annotation, `value` represents the actual classes and finally `type` is also the canonical class name of the bean.

[ConditionalOnClass](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnClass.html) is a condition about the existence of a class in the classpath.
[ConditionalOnBean](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/condition/ConditionalOnBean.html) is a condition about the existence of a bean in the application context.

The parameter `name`, has of course different meanings for the different configurations. This is the reason why `type` has been created in the `ConditionalOnBean` annotation. This way we can use `name`, which semantically means the name of the bean which makes more sense. For `ConditionalOnClass`, `name`, has of course no purposes in naming a bean, and if we talk about the name of a class, it does not make sense to do this in other form than the canonical form.

### Goal 10 - TestRestTemplate

The [TestRestTemplate](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/client/TestRestTemplate.html), is created within a Spring Boot context. It wraps the production graded [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) and uses its own RootUriTemplateHandler. This handler is the LocalHostUriTemplateHandler. It is here that the TestRestTemplate creates the URL. It uses an algorithm that detects if the URL that is used as input parameter is an absolute URL or a reference path to the root. The [LocalHostUriTemplateHandler](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/client/LocalHostUriTemplateHandler.html) creates the absolute URL by checking properties `local.server.port` and `server.servlet.context-path`. The result is a hardcoded concatenation between the current scheme (http/https) plus `://localhost`, plus the port, plus
the context path and finally the relative path that used as parameter.

We can saw that the TestRestTemplate is perfectly aware of the port and the servlet context path being used. There is no need to specify them during an integration test. The possibility to use external URL's is still there in case urls external to the application context need to be accessed.

### Goal 11 - HealthIndicator

In order to implement a [HealthIndicator](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/health/HealthIndicator.html), we need to consider how to implement, if we want it secure and if and how do we want to present the detail.	We have this example with profile `prod`:

```properties   
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=when_authorized
spring.autoconfigure.exclude=
spring.security.user.name=admin
spring.security.user.password=admin
```

The `when_authorided` value, will only allow the disclosure of the health indicator details if the user is authenticated and authorized.	In our example, user `admin` is authorized to access all details.

Finally we can implement one Health endpoint:

```java

@Component
public class PartHealthIndicator implements HealthIndicator {
    private static final String[] CAR_PARTS = new String[]{"Engine", "Transmission", "Gear", "Wheel"};
    private static final Status[] STATUSES = new Status[]{Status.DOWN, Status.UNKNOWN, Status.UP, Status.OUT_OF_SERVICE};

    @Override
    public Health health() {
        int iState = (int) (STATUSES.length * Math.random());
        int iLyrics = (int) (CAR_PARTS.length * Math.random());
        return Health.status(STATUSES[iState]).withDetail("parts", CAR_PARTS[iLyrics]).build();
    }
}
```

This means that an authenticated and authorized user will be able to see something like this using the actuator health endpoint:

```json
{
  "status": "UP",
  "components": {
    "cassandra": {
      "status": "UP",
      "details": {
        "version": "3.11.10"
      }
    },
    "db": {
      "status": "UP",
      "details": {
        "database": "H2",
        "result": 1,
        "validationQuery": "SELECT 1"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 250685575168,
        "free": 9385320448,
        "threshold": 10485760
      }
    },
    "part": {
      "status": "UP",
      "details": {
        "parts": "Transmission"
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

### Goal 12 - Spring MVC / Spring REST / JAX-RS / JERSEY

1.  JAX-RS is a specification of RESTful web services
2.  JERSEY is an implementation of JAX-RS
3.  Spring REST specifies RESTful web services in an alternative way
4.  Spring MVC provides annotations to implement REST services and the MVC pattern

Essentially, the point is that JAX-RS is specifically made to be used with JEE. Spring, on the other hand, offers an alternative solution to this. Using, for example, Jersey and JAX-RS in the same package with Spring MVC works. However, this is an unnecessary usage of resources.

---

## Profiles available

|Profile|Goal|Security|Actuator|
|---|---|---|---|
|Default|Root configuration that configures H2 in memory database and excludes Cassandra|❌|Default: info & health|
|env|Enables the actuator env endpoint only|❌|env|
|health|Enables the actuator health endpoint only|❌|health|
|integrationgraph|Enables the actuator integrationgraph endpoint only|❌|integrationgraph|
|loggers|Enables the actuator loggers endpoint only|❌|loggers|
|prod|Implements BASIC authentication with username/password combination of admin/admin and provides a protected actuator. Cassandra is activated. All actuator endpoints are available|✅|All|
|prod1|Implements BASIC authentication with username/password combination of admin/admin and provides a misconfiguration in protecting protected actuator. Cassandra is activated. All actuator endpoints are available|❌|All|
|prod2|Implements BASIC authentication with username/password combination of admin/admin and provides a protected actuator using a shorter configuration. Cassandra is activated. All actuator endpoints are available|✅|All|
|test|Authentication is not activated and there is no security. All actuator endpoints are available|✅|All|

---

## Technologies used

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/jetty-50.png "Jetty")](https://www.eclipse.org/jetty/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/docker-50.png "Docker")](https://www.docker.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/docker-compose-50.png "Docker Compose")](https://docs.docker.com/compose/)

---

## Study steps

1.  Changing the embedded server to use Jetty:
	
	1. https://codeahoy.com/java/springboot/tutorial/2019/09/01/spring-boot-replace-tomcat-with-jetty-as-the-embedded-server/
	
	2. https://docs.spring.io/spring-boot/docs/1.2.2.RELEASE/reference/html/howto-embedded-servlet-containers.html
	
	3. Remove all Tomcat dependencies

```xml   
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

## References

### Books

-   Cosmina, I. (11th December 2019). <i>Pivotal Certified Professional Core Spring 5 Developer Exam: A Study Guide Using Spring Framework 5</i>. (Second Edition). Apress
-   Sharma, R. (September 2018). <i>Hands-On Reactive Programming with Reactor</i>. (First Edition). Packt
-   Cosmina, I. Harrop, R. Schaefer, C. Ho, C. (October 2017). <i>Pro Spring 5 An In-Depth Guide to the Spring Framework and Its Tools</i>. (Fifth Edition). Apress
-   Winch, R. Mularien, P. (December 2012). <i>Spring Security 3.1</i>. (Second Edition). Packt Publishing
-   Kurniawan, B. Deck, P. (January 2015). <i>Servlet, JSP & Spring MVC</i>. (First Edition). Brainy Software
-   Long, J. (2020). <i>Reactive Spring</i>. (First Edition). Josh Long

### Online

-   [Spring Data Cassandra](https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#preface)
-   [Spring Boot Actuator Web API Documentation](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/)
-   [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
-   [What’s new in Spring Framework 5](https://developer.ibm.com/languages/java/tutorials/j-whats-new-in-spring-framework-5-theedom)
-   [Spring Framework Overview](https://docs.spring.io/spring-framework/docs/5.1.18.RELEASE/spring-framework-reference/overview.html)
-   [Spring Framework Documentation - Current Version](https://docs.spring.io/spring-framework/docs/current/reference/html/index.html)

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/mastodon-20.png "Mastodon")](https://masto.ai/@jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
| [Sessionize](https://sessionize.com/joao-esperancinha/)
| [Spotify](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm?si=b54b89eae8894960)
| [Medium](https://medium.com/@jofisaes)
| [YouTube](https://www.youtube.com/@joaoesperancinha/featured)
| [Instagram](https://www.instagram.com/joaofisaes/)
| [Buy me a coffee](https://www.buymeacoffee.com/jesperancinha)
| [Credly Badges](https://www.credly.com/users/joao-esperancinha)
| [Google Apps](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Docker Images](https://hub.docker.com/u/jesperancinha)
| [Stack Overflow Profile](https://stackoverflow.com/users/3702839/joao-esperancinha)
| [Reddit](https://www.reddit.com/user/jesperancinha/)
| [Dev.TO](https://dev.to/jofisaes)
| [Hackernoon](https://hackernoon.com/@jesperancinha)
| [Code Project](https://www.codeproject.com/Members/jesperancinha)
| [BitBucket](https://bitbucket.org/jesperancinha)
| [GitLab](https://gitlab.com/jesperancinha)
| [Coursera](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
| [FreeCodeCamp](https://www.freecodecamp.org/jofisaes)
| [HackerRank](https://www.hackerrank.com/jofisaes)
| [LeetCode](https://leetcode.com/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [CodeWars](https://www.codewars.com/users/jesperancinha)
| [Code Pen](https://codepen.io/jesperancinha)
| [Hacker Earth](https://www.hackerearth.com/@jofisaes)
| [Khan Academy](https://www.khanacademy.org/profile/jofisaes)
| [Hacker News](https://news.ycombinator.com/user?id=jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
| [LinkedIn](https://www.linkedin.com/in/joaoesperancinha/)
| [Xing](https://www.xing.com/profile/Joao_Esperancinha/cv)
| [Tumblr](https://jofisaes.tumblr.com/)
| [Pinterest](https://nl.pinterest.com/jesperancinha/)
| [Quora](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
| [VMware Spring Professional 2021](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
| [Oracle Certified Professional, Java SE 11 Programmer](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
| [Oracle Certified Professional, JEE7 Developer](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
| [IBM Cybersecurity Analyst Professional](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
| [Certified Advanced JavaScript Developer](https://cancanit.com/certified/1462/)
| [Certified Neo4j Professional](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
| [Deep Learning](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
| [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
