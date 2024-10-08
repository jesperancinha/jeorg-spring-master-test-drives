# Spring Master Test Drives - Planets 🪐

## Introduction

Using Planets and their different names, distances and compositions, we'll see in this app how to work through important Spring topics.

## 1 - Container, Dependency and IoC

1.  https://springframework.guru/best-practices-for-dependency-injection-with-spring/
2.  https://dzone.com/articles/spring-bean-lifecycle
3.  https://stackoverflow.com/questions/39890849/what-exactly-is-field-injection-and-how-to-avoid-it
4.  https://howtodoinjava.com/spring-core/spring-bean-life-cycle/

We can have different servlet containers package into on single [Spring Boot War](https://spring.io/guides/gs/convert-jar-to-war/) file. Check [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) for details:

```xml   
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-undertow</artifactId>
</dependency>
```

We can use parameter injection in the constructors, method injection for the methods, and we can also inject instances. We can do that by using `@Autowired`, or by using the `@Inject` annotation of JSR-330. We can apply `@Inject` pretty much in the same way as `@Autowired` and the only difference is that we cannot inject `PARAMETER` through it.

A bean has a lifecycle whihc is quite complex when we look at the details. 
By running this application, we can see this result:

```text
called: PlanetFactoryPostProcessor#postProcessBeanFactory BeanFactoryPostProcessor 
Planet called: Planet#setSomething 
Planet called: BeanNameAware#setBeanName 
Planet called: BeanClassLoaderAware#setBeanClassLoader 
Planet called: BeanFactoryAware#setBeanFactory 
Planet called: ResourceLoaderAware#setResourceLoader 
Planet called: ApplicationEventPublisherAware#setApplicationEventPublisher 
Planet called: MessageSourceAware#setMessageSource 
Planet called: ApplicationContextAware#setApplicationContext 
called: PlanetPostBeanProcessor#postProcessBeforeInitialization BeanPostProcessor 
Planet called: Planet#postConstruct 
Planet called: InitializingBean#afterPropertiesSet 
Planet called: Planet#initMethod 
called: PlanetPostBeanProcessor#postProcessAfterInitialization BeanPostProcessor 
Planet called: Planet#preDestroy 
Planet called: DisposableBean#destroy 
Planet called: Planet#destroyMethod 
```

This is an illustration of the following when it comes to a bean lifecycle, assuming the bean implements all necessary interfaces:

1.  Bean metadata is set
2.  Bean constructor is called
3.  Setter injection
4.  Assign bean name
5.  Assign bean class loader
6.  Assign bean factory
7.  Assign resource loader
8.  Assign application event publisher
9.  Assign message source
10. Assign Application Context
11. Process bean before initialization
12. Post Construct
13. AfterPropertiesSet
14. Custom Init method
15. Process bean after initialization
16. Pre Destroy
17. Disposable Bean destroy method
18. Custom Bean destroy method

## 2 - AOP

## 3 - Transactions

## 4 - JPA

1.  https://reflectoring.io/spring-boot-data-jpa-test/
2.  https://zetcode.com/springboot/datajpatest/
3.  https://www.arhohuttunen.com/spring-boot-datajpatest/
4.  https://bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
5.  https://howtodoinjava.com/spring-boot2/testing/datajpatest-annotation/
6.  https://www.javaguides.net/2018/09/spring-data-jpa-repository-testing-using-spring-boot-datajpatest.html

The `@DataJpaTest` annotation allows us to specify that we want to use an embedded database for our tests. We can specify the embedded database we want to use with the `@AutoConfigureTestDatabase` annotation. This is one example:

```java   
@DataJpaTest
@MockBean(Planet.class)
@AutoConfigureTestDatabase(replace= AUTO_CONFIGURED, connection = HSQL)
public class PlanetRepositoryHSQLTest {
```

If we don't specify the database we want to use, Spring will iterate through the supported databases until it finds an available and suitable driver. If we look inside [EmbeddedDatabaseConnection](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/jdbc/EmbeddedDatabaseConnection.html), we find 4 possible values in this order: `NONE`, `H2`, `DERBY` and `HSQL`.
In the code we find this:

```java   
public static EmbeddedDatabaseConnection get(ClassLoader classLoader) {
	EmbeddedDatabaseConnection[] var1 = values();
	int var2 = var1.length;

	for(int var3 = 0; var3 < var2; ++var3) {
					EmbeddedDatabaseConnection candidate = var1[var3];
					if (candidate != NONE && ClassUtils.isPresent(candidate.getDriverClassName(), classLoader)) {
									return candidate;
					}
	}

	return NONE;
}
```

And this is how Spring finds the next best embedded database to use.

## 5 - MVC Basics

## 6 - MVC REST

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
</div>

## 8 - Testing

## 9 - Spring Boot Basics

## 10 - Spring Boot Auto-Configuration

We can use the [ConfigurationProperties](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html) annotation, to specify a group of configuration parameters from the configuration file. In our smtd.earth field group, we have habitable which I explicitly did not declare in the class in order to show what would happen should we use property `ignoreInvalidFields` to `false`, which is its default value:

```text   
***************************
APPLICATION FAILED TO START
***************************

Description:

Binding to target [Bindable@e8e0dec type = org.jesperancinha.smtd.planets.configuration.PlanetConfiguration$$EnhancerBySpringCGLIB$$4463d7b5, value = 'provided', annotations = array<Annotation>[@org.springframework.boot.context.properties.ConfigurationProperties(ignoreInvalidFields=false, ignoreUnknownFields=false, prefix=smtd.earth, value=smtd.earth)]] failed:

    Property: smtd.earth.habitable
    Value: true
    Origin: class path resource [application.properties]:5:22
    Reason: The elements [smtd.earth.habitable] were left unbound.

Action:

Update your application's configuration
```

Finally, we can see that an invalid field, is a value in the properties value that cannot be converted. It is therefore an invalid value. This is our volume field example:

```text   
***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'smtd.earth.volume' to java.lang.Long:

    Property: smtd.earth.volume
    Value: volume
    Origin: class path resource [application.properties]:5:19
    Reason: failed to convert java.lang.String to java.lang.Long

Action:

Update your application's configuration
```

A curious thing about `@ConfigurationProperties`, is that it containes `@Indexed` in its composition. `@Indexed` is a stereotype annotation. We do, however, need to add `@Component` to our configuration class in order for its instance to become injectable.

## 11 - Spring Boot Actuator

## 12 - Spring Boot Testing

---


[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%20Master%205%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-master-test-drives)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/jeorg-spring-master-test-drives.svg)](#)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-master-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-master-test-drives)
[![jeorg-spring-master-test-drives](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml/badge.svg)](https://github.com/jesperancinha/jeorg-spring-master-test-drives/actions/workflows/jeorg-spring-master-test-drives.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-test-drives/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/jeorg-spring-master-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/1d960e1b-0c52-4ac0-90eb-d4f06fc97ba0)](https://codebeat.co/projects/github-com-jesperancinha-jeorg-spring-master-test-drives-main)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/jeorg-spring-master-test-drives?branch=main)](https://bettercodehub.com/results/jesperancinha/jeorg-spring-master-test-drives)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/jeorg-spring-master-test-drives)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/db288a3f092a49fbb60d54ad963a47ed)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-master-test-drives/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/jeorg-spring-master-5-test-drives&utm_campaign=Badge_Coverage)
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
