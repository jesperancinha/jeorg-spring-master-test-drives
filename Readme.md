# Spring Master Test Drives

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/jeorg-spring-master-test-drives)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%20Master%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-master-test-drives)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-master-test-drives)
[![jeorg-spring-master-test-drives](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml/badge.svg)](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-test-drives/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/jeorg-spring-master-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/1d960e1b-0c52-4ac0-90eb-d4f06fc97ba0)](https://codebeat.co/projects/github-com-jesperancinha-jeorg-spring-master-test-drives-main)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-test-drives)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-test-drives/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/jeorg-spring-master-test-drives&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/jeorg-spring-master-test-drives/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/jeorg-spring-master-test-drives?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/jeorg-spring-master-test-drives/branch/main/graph/badge.svg?token=2Eh0Oh5ro2)](https://codecov.io/gh/jesperancinha/jeorg-spring-master-test-drives)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/jeorg-spring-master-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/jeorg-spring-master-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/jeorg-spring-master-test-drives.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Introduction

Study Project for the Spring Framework. For more info check the [LogBook](./LogBook.md) file.

#### Stable releases

-   [1.0.0](https://github.com/jesperancinha/jeorg-spring-master-test-drives/tree/1.0.0) - [960c0dbfbe9aef8c11c432c2c380814acf409b37](https://github.com/jesperancinha/jeorg-spring-master-test-drives/tree/1.0.0) - Spring boot 2.7.5
-   [2.0.0](https://github.com/jesperancinha/jeorg-spring-master-test-drives/tree/2.0.0) - [efe08c01f3e67dcb9d18707c9cc662c8ece4bfbc](https://github.com/jesperancinha/jeorg-spring-master-test-drives/tree/2.0.0) - Spring boot 3.0.0

## Specs

1.  Spring: [org.springframework](https://mvnrepository.com/artifact/org.springframework/)
2.  Spring Boot: [org.springframework.boot/spring-boot-starter-parent](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent)

## Build

Note that if you want to build this project from the root, you need to use one of the JDK 11 or upper versions.

<i>See [Hints&Tricks](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Hints%26Tricks.md)
document for more details</i>
```bash
make build
```
> Deprecated
>```bash
>mvn clean install -Dconsolerizer.show=false
>````
## Install JDK 11 using [SDK-MAN](https://sdkman.io/)

```bash
sdk install java 11.0.9.hs-adpt
sdk use java 11.0.9.hs-adpt
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

-   [Mockk](https://mockk.io/)
-   [Spring HATEOAS](https://docs.spring.io/spring-hateoas)
-   [Spring HATEOAS All Classes](https://docs.spring.io/spring-hateoas/docs/current/api/)
-   [Spring Framework All Classes](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
-   [Spring Security All Classes](https://docs.spring.io/spring-security/site/docs/current/api/allclasses.html)
-   [Spring Data Cassandra](https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#preface)
-   [Spring Boot Actuator Web API Documentation](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/)
-   [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
-   [What’s new in Spring Framework 5](https://developer.ibm.com/languages/java/tutorials/j-whats-new-in-spring-framework-5-theedom)
-   [Spring Framework Overview](https://docs.spring.io/spring-framework/docs/5.1.18.RELEASE/spring-framework-reference/overview.html)
-   [Spring Framework Documentation - Current Version](https://docs.spring.io/spring-framework/docs/current/reference/html/index.html)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
