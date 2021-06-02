# Spring Master 5 Test Drives - Annotations

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)  | [Annotations](./Annotations.md)

## 1. [DirtiesContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.html)


### Method mode (methodMode)

1. [org.springframework.test.annotation.DirtiesContext.MethodMode - AFTER_METHOD](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.MethodMode.html#AFTER_METHOD)
2. [org.springframework.test.annotation.DirtiesContext.MethodMode - BEFORE_METHOD](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.MethodMode.html#BEFORE_METHOD)

### Class mode (classMode)

1. [org.springframework.test.annotation.DirtiesContext.ClassMode - AFTER_CLASS](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.ClassMode.html#AFTER_CLASS)
2. [org.springframework.test.annotation.DirtiesContext.ClassMode - BEFORE_CLASS](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.ClassMode.html#BEFORE_CLASS)
3. [org.springframework.test.annotation.DirtiesContext.ClassMode - AFTER_EACH_TEST_METHOD](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.ClassMode.html#AFTER_EACH_TEST_METHOD)
4. [org.springframework.test.annotation.DirtiesContext.ClassMode - BEFORE_EACH_TEST_METHOD](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.ClassMode.html#BEFORE_EACH_TEST_METHOD)

### Hierarchy mode (hierarchyMode)

1. [org.springframework.test.annotation.DirtiesContext.HierarchyMode - CURRENT_LEVEL](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.HierarchyMode.html#CURRENT_LEVEL)
2. [org.springframework.test.annotation.DirtiesContext.HierarchyMode - EXHAUSTIVE](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.HierarchyMode.html#EXHAUSTIVE)

## 2. [ContextConfiguration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ContextConfiguration.html) with [examples](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-testing-annotation-contextconfiguration):

1. classes - component classes to load in the Application context. Ex: `@ContextConfiguration(classes = TestConfig.class)`
2. inheritInitializers (true)- should context initializers be inherited from parent TestConfiguration
3. inheritLocations (true) - should resource or component classes be inherited from parent TestConfiguration
4. initializers - context initializer classes. Ex: `@ContextConfiguration(initializers = CustomContextIntializer.class)`
5. loader - Which context loader to use in spring
6. locations - The actual resource locations. Ex: `@ContextConfiguration(locations = "/test-context.xml", loader = CustomContextLoader.class)`
7. name - The name of the context hierarchy level used
8. value is an alias for locations. Ex: `@ContextConfiguration("/test-config.xml")`

## 3. ImportAutoConfiguration

## 4. EnableAutoConfiguration

---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)  | [Annotations](./Annotations.md)
