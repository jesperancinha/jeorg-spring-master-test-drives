# Spring Master Test Drives - Bank Company 🏦

## Introduction

Banking app

## 1 - Container, Dependency and IoC

1.  https://springframework.guru/best-practices-for-dependency-injection-with-spring/
2.  https://dzone.com/articles/spring-bean-lifecycle
3.  https://stackoverflow.com/questions/39890849/what-exactly-is-field-injection-and-how-to-avoid-it
4.  https://howtodoinjava.com/spring-core/spring-bean-life-cycle/
5.  https://docs.spring.io/spring-framework/docs/3.0.x/reference/expressions.html
6.  https://docs.spring.io/spring-integration/docs/current/reference/html/spel.html#spel
7.  https://www.dev2qa.com/spring-expression-language-example-vs/
8.  https://dzone.com/articles/beginners-guide-to-spring-expression-language-with

A [SpEL](https://docs.spring.io/spring-framework/docs/3.0.x/reference/expressions.html), can be built using essentially two forms:

1.  using `$`, we inject a variable name
2.  using `#`, we inject an expression

If we use an expression, we can include within it, a variable name by using the normal definition within single quotes. I have implemented these examples for this module:

```java
@Value("#{ systemProperties['user.region'] }")
private String region;

@Value("#{ systemProperties['user.country'] }")
private String country;
@Value("#{'${jeorg.bank.salaries}'.split(',').?[new Integer(#this) > 10]}")
private List<Long> salaries;

@Value("#{ T(java.lang.Math).random() * 100.0 }")
private Long randomNumber;

@Value("${jeorg.bank.salaries}")
private String salariesString;

@Value("#{#root.toString()}")
private String bankContextString;
```

Injection of beans can be done in very unusual ways. Probably not the highest quality of ways, but we can also inject beans by using one of th ApplicationContext interfaces. One of the, the `BeanFactory`, can be used this way:

```java
@Autowired
private BeanFactory beanFactory;

        ...

final var bankCompanyUserRepository=(BankCompanyUserRepository)beanFactory.getBean("bankCompanyUserRepository");
```

## 2 - AOP

## 3 - Transactions

1.  https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html
2.  https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html
3.  https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/transaction.html

The annotation `@Transactional` contains a very interesting property called `readOnly`. This property could semantically have a better name like `maybeReadOnly`, `tryReadOnly`, `tryNotToRead`, or anything that would suggest an attempt to reject write operations. What in reality, this property does, is that it tells Spring to hint the Transaction manager that it should not allow write operations. The Transaction manager may or may not interpret this hint correctly. Having said this, what this property also does is allow optimizations to occur for read operations during runtime. This of course depends on how the Transaction manager interprets the hint given by the Spring Framework.

We can configure many `@Transactional` propagation types:

1.  `MANDATORY` - A transaction must exist
2.  `NESTED` - Exectus withing a nested transaction
3.  `NOT_SUPPORTED` - Stops existing transactions, if any, and executes non-transactional.
4.  `REQUIRED` - Always runs in a transactional mode and creates a new transaction if none exists
5.  `REQUIRES_NEW` - Creates a new transaction regardless if one already exist
6.  `SUPPORTS` - Always executes a query regardless of a transaction exists or not. It will only execute transactional if a transaction already exists.

None of the transactional modes are the same, and they server very different purposes. The `SUPPORTS` propagation type can be sometimes confused with `REQUIRED`. The difference is that `REQUIRED` only fails if a transaction isn't possible to create.
`SUPPORTS` however, doesn't make it mandatory to create a transaction.

## 4 - JPA

1.  https://reflectoring.io/spring-boot-data-jpa-test/
2.  https://zetcode.com/springboot/datajpatest/
3.  https://www.arhohuttunen.com/spring-boot-datajpatest/
4.  https://bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
5.  https://howtodoinjava.com/spring-boot2/testing/datajpatest-annotation/
6.  https://www.javaguides.net/2018/09/spring-data-jpa-repository-testing-using-spring-boot-datajpatest.html

## 5 - MVC Basics

## 6 - MVC REST

1.  https://spring.io/guides/gs/serving-web-content/

## 7 - Security

1.  https://dzone.com/articles/what-does-spring-delegatingfilterproxy-do
2.  https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/filter/DelegatingFilterProxy.html
3.  https://stackoverflow.com/questions/6725234/whats-the-point-of-spring-mvcs-delegatingfilterproxy
4.  https://springbootdev.com/2017/09/09/spring-security-delegatingfilterproxy/
5.  https://www.youtube.com/watch?v=lxmBJmUhqss
6.  https://www.youtube.com/watch?v=xEnvAAhMGu4
7.  https://github.com/jzheaux/springone2019
8.  https://github.com/jzheaux/springone2020
9.  https://www.youtube.com/watch?v=TDuVY8PFU3Q
10. https://docs.spring.io/spring-security/site/docs/4.2.20.RELEASE/apidocs/org/springframework/security/core/context/SecurityContextHolder.html
11. https://programmersought.com/article/63182958726/
12. https://javarevisited.blogspot.com/2018/02/what-is-securitycontext-and-SecurityContextHolder-Spring-security.html#axzz6w2sHEiVK
13. https://docs.spring.io/spring-security/site/docs/3.0.x/reference/technical-overview.html
14. https://www.mfvitale.me/blog/2021/02/24/security.context.and.concurrency.html
15. https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se
16. https://dzone.com/articles/what-does-spring-delegatingfilterproxy-do

<div align="center">
      <a title="5. Spring Security is Servlet Filter Based - DelegatingFilterProxy, FilterChainProxy and More... by Miss Xing" href="https://www.youtube.com/watch?v=lxmBJmUhqss">
     <img 
          src="https://img.youtube.com/vi/lxmBJmUhqss/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Spring Security Patterns @ SpringOne" href="https://www.youtube.com/watch?v=xEnvAAhMGu4">
     <img 
          src="https://img.youtube.com/vi/xEnvAAhMGu4/0.jpg" 
          style="width:10%;">
      </a>
      <a title="[Spring Boot Security] #19 Database Authentication - Implement User Details Service" href="https://www.youtube.com/watch?v=TDuVY8PFU3Q">
     <img 
          src="https://img.youtube.com/vi/TDuVY8PFU3Q/0.jpg" 
          style="width:10%;">
      </a>
      <a title="4 . The need of DelegatingFilterProxy - the entry point of Spring Security" href="https://www.youtube.com/watch?v=JP5XC6PUe8M">
     <img 
          src="https://img.youtube.com/vi/JP5XC6PUe8M/0.jpg" 
          style="width:10%;">
      </a>
</div>

In terms os security we need to implement our own persistence layer for our `BankCompanyUser`. `UserDetails`, have to exist within the application since this is the type that enables Authentication to exist. In the `UserDetails`, identifiable data can be stored, plus password, granted authorities, if the user is enabled, non-locked, non-expired and if the credentials are non-expired.

Storing our user or how we store it, is entirely custom-made by the developer.

In the `SecurityContextHolder` class, we find different ways to implement the strategy and also which system variable is being used:

```java
public static final String MODE_THREADLOCAL="MODE_THREADLOCAL";
public static final String MODE_INHERITABLETHREADLOCAL="MODE_INHERITABLETHREADLOCAL";
public static final String MODE_GLOBAL="MODE_GLOBAL";
public static final String SYSTEM_PROPERTY="spring.security.strategy";
private static String strategyName=System.getProperty("spring.security.strategy");
private static SecurityContextHolderStrategy strategy;
private static int initializeCount=0;
```

Your IDE might say that the property `spring.security.strategy` cannot be found, but it is there 😉. This property is not a mode. Instead, it is the default Strategy creatd when starting the container. It is no longer re-read after that.

In short, there are only three strategy modes and we can define them shortly like this:

1.  `MODE_THREADLOCAL` - The principal isn't shared to new thread, but the same context and principal are accessed throughout the execution of the thread.
2.  `MODE_INHERITABLETHREADLOCAL` - Every new thread gets a new context, with the same principal. Changes in the generated contexts do not affect the others. For that we need to use a `DelegatingSecurityContextExecutorService`.
3.  `MODE_GLOBAL` - The context is shared. Every new thread shares the same principal.

The `DelegatingFilterProxy` resolves the `filterChain` and it gets registered in the `SecurityFilterAutoConfiguration` class, which creates a bean of type `DelegatingFilterProxyRegistrationBean` under the name `springSecurityFilterChain`.

## 8 - Testing

1.  https://docs.spring.io/spring-framework/docs/4.3.12.RELEASE/spring-framework-reference/html/unit-testing.html
2.  https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html

## 9 - Spring Boot Basics

1.  https://springframework.guru/spring-external-configuration-data/
2.  https://mkyong.com/spring/spring-propertysources-example/

## 10 - Spring Boot Auto-Configuration

1.  https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.developing-auto-configuration
2.  https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-external-config

Spring Boot auto-configuration `spring.factories` can affect the way the `Environment` and the `ApplicationContext` are configured during startup. This is because they can register custom listeners and extra register extra custom configurations.

## 11 - Spring Boot Actuator

1.  https://dzone.com/articles/maven-git-commit-id-plugin
2.  https://codeboje.de/spring-boot-info-actuator/
3.  https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.endpoints.exposing

We can add a lot of information to our `info` actuator endpoint. This has to be done before starting the server. In our example we'll see a few examples:

1.  Adding Maven Build information
2.  Adding custom data in the properties file
3.  Adding Git data

In order to add maven, we can rely on a simple replacement function provided by maven. For that we need to add this to our `pom.xml` file:

```xml   
<resources>
	<resource>
			<directory>src/main/resources</directory>
			<filtering>true</filtering>
	</resource>
</resources>
```

Our `spring-boot-maven-plugin` needs to have these `executions` properly configured:

```xml   
<executions>
		<execution>
						<goals>
										<goal>build-info</goal>
										<goal>repackage</goal>
						</goals>
		</execution>
</executions>
```

We can also add custom properties to our `application.properties` file. They all only need to start with `info`:

```properties   
info.app.name = @project.name@
info.app.groupId = @project.groupId@
info.app.artifactId = @project.artifactId@
info.app.version = @project.version@
info.cowabunga=cowabunga
```

Adding the GIT repo information is as easy as adding the following plugin with its configuration:

```xml   
<plugin>
    <groupId>pl.project13.maven</groupId>
    <artifactId>git-commit-id-plugin</artifactId>
    <version>3.0.1</version>
    <executions>
        <execution>
            <id>get-the-git-infos</id>
            <goals>
                <goal>revision</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <dotGitDirectory>${project.basedir}/.git</dotGitDirectory>
        <prefix>git</prefix>
        <verbose>false</verbose>
        <generateGitPropertiesFile>true</generateGitPropertiesFile>
        <generateGitPropertiesFilename>${project.build.outputDirectory}/git.properties</generateGitPropertiesFilename>
        <format>properties</format>
        <gitDescribe>
            <skip>false</skip>
            <always>false</always>
            <dirty>-dirty</dirty>
        </gitDescribe>
    </configuration>
</plugin>
```

And if we want even more detail to be shown, we can also configure the `management` configuration for that:

```properties
management.info.git.mode=full
```

With all set and configured we should be getting two files:

1.  `git.properties`, on the root of the classpath
2.  `build-info.propertis`, on the META-INF directory

Running our Spring Boot application, we'll see that our actuator located at http://localhost:8081/actuator/info, now contains information like this one:

```json
{
  "app": {
    "name": "Bank Company",
    "groupId": "org.jesperancinha.smtd",
    "artifactId": "bank-company",
    "version": "1.0.0-SNAPSHOT"
  },
  "cowabunga": "cowabunga",
  "git": {
    "local": {
      "branch": {
        "ahead": "0",
        "behind": "0"
      }
    },
    "commit": {
      "message": {
        "short": "\uD83C\uDF31 jeorg-spring-master-test-drives - \uD83C\uDFE6 - BankCompany - app and build for the Info actuator",
        "full": "\uD83C\uDF31 jeorg-spring-master-test-drives - \uD83C\uDFE6 - BankCompany - app and build for the Info actuator"
      },
      "user": {
        "name": "Joao Esperancinha",
        "email": "jofisaes@gmail.com"
      },
      "time": "2021-05-27T20:41:07Z"
    },
    "branch": "main",
    "build": {
      "time": "2021-05-27T21:04:27Z",
      "version": "1.0.0-SNAPSHOT",
      "user": {
        "name": "Joao Esperancinha"
      }
    }
  },
  "build": {
    "artifact": "bank-company",
    "name": "Bank Company",
    "time": "2021-05-27T21:04:23.456Z",
    "version": "1.0.0-SNAPSHOT",
    "group": "org.jesperancinha.smtd"
  }
}
```

I removed some nodes because the retrieve GIT information is quite extensive and probably not recommended using in production.

As described in section [6.2.2. Exposing Endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.endpoints.exposing) of the actuator documentation, the actuator exposes all endpoints via `JMX` by default. Via `HTTP`, we only have `info` and `health` as default available endpoints.

## 12 - Spring Boot Testing

1.  https://howtodoinjava.com/spring-boot2/testing/springboot-test-configuration/
---


[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%20Master%205%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-master-test-drives)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/jeorg-spring-master-test-drives.svg)](#)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-master-test-drives)
[![jeorg-spring-master-test-drives](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml/badge.svg)](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-test-drives/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/jeorg-spring-master-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/1d960e1b-0c52-4ac0-90eb-d4f06fc97ba0)](https://codebeat.co/projects/github-com-jesperancinha-jeorg-spring-master-test-drives-main)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/jeorg-spring-master-test-drives?branch=main)](https://bettercodehub.com/results/jesperancinha/jeorg-spring-master-5-test-drives)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-5-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-5-test-drives)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-5-test-drives/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/jeorg-spring-master-5-test-drives&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/jeorg-spring-master-5-test-drives/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/jeorg-spring-master-5-test-drives?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/jeorg-spring-master-5-test-drives/branch/main/graph/badge.svg?token=2Eh0Oh5ro2)](https://codecov.io/gh/jesperancinha/jeorg-spring-master-5-test-drives)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Introduction

Welcome to [JEOrg Spring Master Test Drives](https://github.com/jesperancinha/jeorg-spring-master-5-test-drives).   
In these series we will only have master projects available. We won't be looking at the basics of Spring 5.   
That will still occur in my other repo: [JEOrg Spring 5 Test Drives](https://github.com/jesperancinha/jeorg-spring-5-test-drives).

The setting in this repo is essentially about details.   
So for example if we are looking at a `@Transactional` annotation, we won't just be looking at what a `@Transactional` does.   
Further, we will be looking at what each single parameter of `@Transactional` actually does.

Please use this repo for your studies only if you already have enough baggage from the Spring Framework. We will avoid paying attention to basic Spring concepts.

Please have a look at our page where the description of the in-depth subjects investigated and related web resources are provided: [Technology](./Technology.md).

Also, please check our [Reminders](./reminders/Reminders.md) page, where short descriptions are presented in a flash card fashion for specific theoretical aspects of the Spring Framework.

We all know, in a way, what Spring Boot is, but sometimes it is very important to explain what it actually is. Find more in our [Spring Boot](./reminders/SpringBoot.md) section.

João Esperancinha 2021/05/22

## Build

Note that if you want to build this project from the root, you need to use one of the JDK 11 or upper versions.

<i>See [Hints&Tricks](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Hints%26Tricks.md)
document for more details</i>
```bash
mvn clean install -Dconsolerizer.show=false
```

## Install JDK 11 using [SDK-MAN](https://sdkman.io/)

```bash
sdk install java 11.0.9.hs-adpt
sdk use java 11.0.9.hs-adpt
```

## Run Codecov

```bash
mvn clean test -Dconsolerizer.show=false
bash <(curl -s https://codecov.io/bash)
```

## Sequence Diagram

```mermaid

sequenceDiagram
    participant USER
    participant SPRING
    participant SPRING CORE Docs
    participant SPRING Details
    participant SPRING Packaging
    participant Spring Professional
    
    rect rgb(1,130,25)
    
    USER->>SPRING: User studies spring
    
    SPRING->>SPRING CORE Docs: User dives into Spring Core Docs
    
    SPRING CORE Docs->>SPRING Details: User thinks about using all annotation params
    
    SPRING Details->>SPRING Packaging: User checks out packaging possibilities with containers
    
    SPRING Details->>Spring Professional: User becomes
 
    loop Keep updated
         Spring Professional->>SPRING: User studies again
    end
    end
```

<i>Note: You need a Mermaid plugin extension</i>

i.e. [mermaid-plugin](https://chrome.google.com/webstore/detail/mermaid-diagrams/phfcghedmopjadpojhmmaffjmfiakfil/related)

## Tech-stack Cloud

`@Transational timeout`, `TestRestTemplate`, `HealthIndicator`, `actuator`, `Embedded`, `JPA`, `Big Data`
`Cassandra support`, `Transaction under Transaction`, `Health indicators`, `packaging`
`containers`, `tomcat`, `jetty`

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

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
