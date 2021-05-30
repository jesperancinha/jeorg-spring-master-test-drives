# Spring Master 5 Test Drives - Test Drives Reminders

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)

---

## 1. Spring Boot Starter Test Dependency

`JUnit`, `Spring Test & Spring Boot Test`, `AssertJ`, `Hamcrest`, `Mockito`, `JSONassert`, `JsonPath`

## 2. Write operations in actuators

|Operation|URL|Method|Command|
|---|---|---|---|
|Rebuild Integration Graph|http://localhost:8081/actuator/integrationgraph|POST| curl 'http://localhost:8081/actuator/integrationgraph' -i -X POST|
|Setup Log Levels|http://localhost:8080/actuator/loggers/{path}|POST| see module [Goals](./Goals.md)|
|Shutdown the application|http://localhost:8080/actuator/shutdown|POST|curl 'http://localhost:8080/actuator/shutdown' -i -X POST
|Drain and return the application startup steps|http://localhost:8080/actuator/startup|POST|curl 'http://localhost:8080/actuator/startup' -i -X POST

## 3. Default Actuator endpoints

1. Via Http: `health`, `info`
2. Via JMX: All of them

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

`MODE_GLOBAL`, `MODE_INHERITABLETHREADLOCAL`, `MODE_THREADLOCAL`

`SYSTEM_PROPERTY` - This variable contains value `spring.security.strategy`, and it is used if configured.

## 7. Where can we use SpEL?

We can use SpEL on a variety of annotations that support SpEL. The ones I have identified so far are:

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

## 14 [@WebMvcTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html) Autoconfiguration

1. Disables full auto-configuration
2. Enables configuration related to MVC tests
3. @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver beans
4. @Component, @Service or @Repository do not get configured
5. Spring Security and MockMvc (include support for HtmlUnit WebClient and Selenium WebDriver).
6. @AutoConfigureMockMvc annotation can be used as an alternative
7. `@AutoConfigureCache`
8. `@AutoConfigureWebMvc`
9. `@AutoConfigureMockMvc`

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

`execution`, `within`, `this`, `target`, `args`, `@target`, `@args`, `@within`, `@annotation`

## 19 [Spring MVC Auto-configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.developing-web-applications.spring-mvc.auto-configuration)

1. Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.
2. Support for serving static resources, including support for `WebJars`.
3. Automatic registration of `Converter`, `GenericConverter`, and `Formatter` beans.
4. Support for `HttpMessageConverters`.
5. Automatic registration of `MessageCodesResolver`.
6. Static `index.html` support.
7. Automatic use of a `ConfigurableWebBindingInitializer` bean.

## 20 [@DataJpaTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html)

1. Disables full auto-configuration
2. Only configuration related to JPA tests.
3. Tests with `@DataJpaTest` are `transactional` and roll back at the end of each test.
4. They use an embedded in-memory database (replacing any explicit or usually auto-configured `DataSource`).
5. The `@AutoConfigureTestDatabase` annotation can be used to override these settings.
6. `@AutoConfigureCache`
7. `@AutoConfigureDataJpa`
8. `@AutoConfigureTestDatabase`
9. `@AutoConfigureTestEntityManager`

## 21 Bean Lifecycle

1. called: `BeanFactoryPostProcessor`#`postProcessBeanFactory` => Bean definitions
2. Bean called: Bean#setSomething => `setter injection`
3. Bean called: `BeanNameAware`#`setBeanName`
4. Bean called: `BeanClassLoaderAware`#`setBeanClassLoader`
5. Bean called: `BeanFactoryAware`#`setBeanFactory`
6. Bean called: `ResourceLoaderAware`#`setResourceLoader`
7. Bean called: `ApplicationEventPublisherAware`#`setApplicationEventPublisher`
8. Bean called: `MessageSourceAware`#`setMessageSource`
9. Bean called: `ApplicationContextAware`#`setApplicationContext`
10. called: `BeanPostProcessor`#`postProcessBeforeInitialization`
11. Bean called: Bean#`postConstruct`
12. Bean called: `InitializingBean`#`afterPropertiesSet`
13. Bean called: Bean#`initMethod` => Custom init
14. called: `BeanPostProcessor`#`postProcessAfterInitialization`
15. Bean called: Bean#`preDestroy`
16. Bean called: `DisposableBean`#`destroy`
17. Bean called: Bean#`destroyMethod` => Custom destroy

## 22 Shutting down a Spring Boot application

1. `ApplicationContext`.close - instance method - programmatically
2. `SpringApplication`.exit - static method using context
3. curl -X POST localhost:port/actuator/shutdown - gracious shutdown

## 23 [MVC Allowed Method Arguments](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments)

`WebRequest`, `NativeWebRequest`,
`javax.servlet.ServletRequest`, `javax.servlet.ServletResponse`,
`javax.servlet.http.HttpSession`,
`javax.servlet.http.PushBuilder`, `java.security.Principal`,
`java.util.TimeZone`, `java.time.ZoneId`, `java.io.InputStream`,
`java.io.Reader`, `java.io.OutputStream`, `java.io.Writer`,
`@PathVariable`, `@MatrixVariable`, `@RequestParam`, `@RequestHeader`,
`@CookieValue`, `@RequestBody`,
`HttpMethod`, `java.util.Locale`,
`HttpEntity<T>`, `@RequestPart`, `java.util.Map`, `org.springframework.ui.Model`,
`org.springframework.ui.ModelMap`,
`RedirectAttributes`, `@ModelAttribute`,
`Errors`, `BindingResult`,
`SessionStatus`, `class-level @SessionAttributes`,
`UriComponentsBuilder`, `@SessionAttribute`, `@RequestAttribute`

Other argument types: from [documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments):

> If a method argument is not matched to any of the earlier values in this table and it is a simple type (as determined by BeanUtils#isSimpleProperty, it is a resolved as a @RequestParam. Otherwise, it is resolved as a @ModelAttribute

## 24 [MVC Allowed return types](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types)

`@ResponseBody`,
`HttpEntity<B>`, `ResponseEntity<B>`,
`HttpHeaders`,
`String`, `View`,
`java.util.Map`, `org.springframework.ui.Model`,
`@ModelAttribute`, `ModelAndView`,
`void`, `DeferredResult<V>`,
`Callable<V>`, `ListenableFuture<V>`, `java.util.concurrent.CompletionStage<V>`,
`java.util.concurrent.CompletableFuture<V>`,
`ResponseBodyEmitter`, `SseEmitter`,
`StreamingResponseBody`,
`Reactive types - Reactor, RxJava, or others through ReactiveAdapterRegistry`,

Other argument types: from [documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types):

> Any return value that does not match any of the earlier values in this table and that is a String or void is treated as a view name (default view name selection through RequestToViewNameTranslator applies), provided it is not a simple type, as determined by BeanUtils#isSimpleProperty. Values that are simple types remain unresolved.

## 25 JPA [Query Creation](https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation)

`Distinct`,`And`,`Or`,`Is, Equals`,`Between`,`LessThan`,`LessThanEqual`,`GreaterThan`,`GreaterThanEqual`,`After`,`Before`,`IsNull, Null`,`IsNotNull, NotNull`,`Like`,`NotLike`,`StartingWith`,`EndingWith`,`Containing`,`OrderBy`,`Not`,`In`,`NotIn`,`True`,`False`,`IgnoreCase`

## 26 [WebAppConfiguration](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/web/WebAppConfiguration.html)

Established the resource path to the root directory of the web application.	By default, it is `src/main/webapp`

## 27 [Spring testing annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring)

`@BootstrapWith`,
`@ContextConfiguration`,
`@WebAppConfiguration`,
`@ContextHierarchy`,
`@ActiveProfiles`,
`@TestPropertySource`,
`@DynamicPropertySource`,
`@DirtiesContext`,
`@TestExecutionListeners`,
`@RecordApplicationEvents`,
`@Commit`,
`@Rollback`,
`@BeforeTransaction`,
`@AfterTransaction`,
`@Sql`,
`@SqlConfig`,
`@SqlMergeMode`,
`@SqlGroup`

## 28 [Spring Boot testing annotations](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)

All [Spring testing annotations](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring) plus:

`@SpyBean`,
`@MockBean`

---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)
