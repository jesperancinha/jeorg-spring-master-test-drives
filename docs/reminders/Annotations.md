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

1. `classes` - component classes to load in the Application context. Ex: `@ContextConfiguration(classes = TestConfig.class)`
2. `inheritInitializers` (true)- should context initializers be inherited from parent TestConfiguration
3. `inheritLocations` (true) - should resource or component classes be inherited from parent TestConfiguration
4. `initializers` - context initializer classes. Ex: `@ContextConfiguration(initializers = CustomContextIntializer.class)`
5. `loader` - Which context loader to use in spring
6. `locations` - The actual resource locations. Ex: `@ContextConfiguration(locations = "/test-context.xml", loader = CustomContextLoader.class)`
7. `name` - The name of the context hierarchy level used
8. `value` is an alias for locations. Ex: `@ContextConfiguration("/test-config.xml")`

## 3. [ImportAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/ImportAutoConfiguration.html)

Key factor is that is excludes `spring.factories` and it works like `@EnableAutoConfiguration`.

1. `classes` - autoconfiguration classes that should be imported.
2. `exclude` - specifically excludes some classes
3. `value` is an alias to classes

## 4. [EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html)

It only applies after user-beans have been registered. This means that they get registered anyway even though they are excluded.

1. `exclude` - Excludes specific classes so that they never apply
2. `excludeNames` - Excludes specific class names so that they never apply

## 5 [PropertySource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html)

1. `encoding` - encoding for the file
2. `factory` - a custom PropertySourceFactory
3. `ignoreResourceNotFound` (false) - Throw an exception by default if the resource is not found.
4. `name` - The name of this property source
5. `value` - the resource location. Ex: `@PropertySource("classpath:/com/myco/app.properties")`

## 6 [Transactional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)

1. `isolation` - Transaction isolation level - `Exclusively designed for use with Propagation.REQUIRED or Propagation.REQUIRES_NEW since it only applies to newly started transactions`
2. `label` - Different possible transaction labels
3. `noRollbackFor` - Perform no rollback for a specific class
4. `noRollbackForClassName` - Perform no rollback for a specific class name
5. `propagation` - Defines the propagation type
6. `readOnly` - Does not guarantee to only read. It only flags the database an intention to only read. It's up to the provider to interpret this flag. In that way, optimizations can be allowed to occur.
8. `rollbackFor` - Perform rollback for a specific class
9. `rollbackForClassName` - Perform rollback for a specific class name
10. `timeout` - transaction timeout - `Exclusively designed for use with Propagation.REQUIRED or Propagation.REQUIRES_NEW since it only applies to newly started transactions`
11. `timeoutString` - transaction timeoutString - `Exclusively designed for use with Propagation.REQUIRED or Propagation.REQUIRES_NEW since it only applies to newly started transactions`
12. `transactionManager` - specification of the transaction manager if multiple are available to choose from
13. value - an alias for `transactionManager`
---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)  | [Annotations](./Annotations.md)
