# car-parts

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/jeorg-spring-master-5-test-drives)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%205%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-master-5-test-drives)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/jeorg-spring-master-5-test-drives.svg)](#)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-master-5-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-master-5-test-drives)
[![Build Status](https://travis-ci.com/jesperancinha/jeorg-spring-master-5-test-drives.svg?branch=main)](https://travis-ci.com/jesperancinha/jeorg-spring-master-5-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-master-5-test-drives)
[![jeorg-spring-master-5-test-drives](https://github.com/jesperancinha/jeorg-spring-master-5-test-drives/actions/workflows/jeorg-spring-master-5-test-drives.yml/badge.svg)](https://github.com/jesperancinha/jeorg-spring-master-5-test-drives/actions/workflows/jeorg-spring-master-5-test-drives.yml)

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

1. http://localhost:8081/actuator/health
2. http://localhost:8081/actuator/info

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

1. When `configuredLevel` has a value then `effectiveLevel` is always the same.
2. When `configuredLevel` is null, it means that the log inherits the level from the parent.
3. The `configuredLevel` of `ROOT` can, of course, never be null.

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

1. Timeout configuration in nested transactions. Test methods are `createPart` and `createPartTimeout`
2. Calling inner methods annotated with the transactional annotation. Test methods are `createPartExtra` and `createPartMix`

If we run the unit tests we see that the Parent `@Transactional` on a class level, does not override the methods annotated with the same annotation. Instead, the opposite is true. The methods annotated with `@Transactional`, do override the `timeout` property. This means that, when we invoke the any method without any annotation, it will inherit the class timeout. In this case, it is 1ms, which, given that it is such a small figure, it will imediatelly timeout.

For point two we see that when we call the inner methods, we are no longer within the CGLIB proxy. Instead, calling the inner method, will just call the method as if it had no annotation on it. In this case, the proxy isn't called.

### Goal 4 - Packaging multiple containers

We can package lots of wars and put them through a container, but essentially, one jar can only be served by one container.

This is done by the usage of the [spring maven plugin](https://docs.spring.io/spring-boot/docs/2.5.x/maven-plugin/reference/htmlsingle/). First we better have something like [Docker Desktop](https://www.docker.com/products/docker-desktop).

Here is how can use this plugin:

```bash
mvn spring-boot:build-image
docker run  docker.io/library/car-parts:1.0.0-SNAPSHOT
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

The Spring framework does not provide DAO's to access Cassandra in a JPA fashion. Cassandra is a NoSQL database, which follows a very different paradigms.
Instead, Spring offers [Spring Data For Apache Cassandra](https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#preface).

---

## Technologies used

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/jetty-50.png "Jetty")](https://www.eclipse.org/jetty/)

---

## Study steps

1. Changing the embedded server to use Jetty:
	
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

-   [Spring Boot Actuator Web API Documentation](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/)
-   [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
-   [What’s new in Spring Framework 5](https://developer.ibm.com/languages/java/tutorials/j-whats-new-in-spring-framework-5-theedom)
-   [Spring Framework Overview](https://docs.spring.io/spring-framework/docs/5.1.18.RELEASE/spring-framework-reference/overview.html)
-   [Spring Framework Documentation - Current Version](https://docs.spring.io/spring-framework/docs/current/reference/html/index.html)

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)   
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)   
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
