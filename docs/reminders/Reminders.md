# Spring Master 5 Test Drives - Test Drives Reminders

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)

---

## 1. Spring Boot Starter Test Dependency

`JUnit`, `Spring Test & Spring Boot Test`, `AssertJ`, `Hamcrest`, `Mockito`, `JSONassert`, `JsonPath`

Smaller utilities included:

1. `XmlUnit` - [XmlExpectationsHelper](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/util/XmlExpectationsHelper.html)
2. `AopTest` - [AopTestUtils](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/util/AopTestUtils.html)

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
7. `NEVER` - Throws an exception if a transaction is present. It always executes non-transactionally

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

Established the resource path to the root directory of the web application. By default, it is `src/main/webapp`

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

## 29 [AOP proxies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-pointcuts-designators)

Spring AOP recommends only using `public` method visibility in AOP propxies. For JDK proxies, this is mandatory given that interfaces are also mandatory.

However, in case of `@EnableAspectJAutoProxy(proxyTargetClass = true)`, even though we force the usage of CGLIB proxies in the spring framework, it is still only recommended to use `public` visibility. However, it is still technically possible to use CGLIB proxies with methods with visibility `protected` and `package`.

From [documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-pointcuts-designators):

> Due to the proxy-based nature of Spring’s AOP framework, calls within the target object are, by definition, not intercepted. For JDK proxies, only public interface method calls on the proxy can be intercepted. With CGLIB, public and protected method calls on the proxy are intercepted (and even package-visible methods, if necessary). However, common interactions through proxies should always be designed through public signatures.

## 30 [AOP in Spring](https://docs.spring.io/spring-framework/docs/3.0.x/reference/aop.html)

1. [Runtime Weaving](https://docs.spring.io/spring-framework/docs/3.0.x/reference/aop.html)

> Weaving: linking aspects with other application types or objects to create an advised object. This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.

2. Code is modified during runtime by proxies

> Target object: object being advised by one or more aspects. Also referred to as the advised object. Since Spring AOP is implemented using runtime proxies, this object will always be a proxied object.

3. JDK proxies support `final` classes and methods, purely because they support interfaces. Using the interfaces, it doesn't matter if the concrete `class` is `final` or has `final` methods.
4. [AspectJ Expression Language](https://www.eclipse.org/aspectj/)
5. Spring AOP only supports method execution join points. If ewe look at the available point cut designators, we also see that they only ever work as a filter for method join points.
6. CGLIB constructors get called twice

>The constructor of your proxied object will be called twice. This is a natural consequence of the CGLIB proxy model whereby a subclass is generated for each proxied object. For each proxied instance, two objects are created: the actual proxied object and an instance of the subclass that implements the advice. This behavior is not exhibited when using JDK proxies. Usually, calling the constructor of the proxied type twice, is not an issue, as there are usually only assignments taking place and no real logic is implemented in the constructor.

## 31 Data Source configurations

1. JNDI - When deploying to an application server using `spring.datasource.jndi-name`
2. application.properties - Directly using `spring.datasource.*`
3. Programmatically creating `@Bean` `DataSource` under `@Configuration`
4. Simply adding dependency when using embedded databases like `H2`, `HSQL` or `Derby`

## 32 [Spring DataSource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/datasource/package-summary.html)

#### Interfaces

`ConnectionHandle`,
`ConnectionProxy`,
`SmartDataSource`

#### Classes

`AbstractDataSource`,
`AbstractDriverBasedDataSource`,
`ConnectionHolder`,
`DataSourceTransactionManager`,
`DataSourceUtils`,
`DelegatingDataSource`,
`DriverManagerDataSource`,
`IsolationLevelDataSourceAdapter`,
`JdbcTransactionObjectSupport`,
`LazyConnectionDataSourceProxy`,
`SimpleConnectionHandle`,
`SimpleDriverDataSource`,
`SingleConnectionDataSource`,
`TransactionAwareDataSourceProxy`,
`UserCredentialsDataSourceAdapter`,
`WebSphereDataSourceAdapter`

## 33 [EnableTransactionManagement](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html) advice modes

1. `ASPECTJ` - AspectJ weaving-based advice - Self method invocation supported
2. `PROXY` - JDK proxy-based advice - Self method invocation not supported

## 34 Excluding classes from autoconfiguration

1. [ImportAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/ImportAutoConfiguration.html) - `exclude`
2. [EnableAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/EnableAutoConfiguration.html) - `exclude`

The difference between the above two is that ImportAutoConfiguration is a restrictive annotation.	EnableAutoConfiguration is a general annotation that we can restrict in a declarative way.

## 35 [Supported Monitoring Systems](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.metrics)

`AppOptics`,
`Atlas`,
`Datadog`,
`Dynatrace`,
`Elastic`,
`Ganglia`,
`Graphite`,
`Humio`,
`Influx`,
`JMX`,
`KairosDB`,
`New Relic`,
`Prometheus`,
`SignalFx`,
`Simple (in-memory)`,
`Stackdriver`,
`StatsD`,
`Wavefront`


## 36 Database initialization modes

`spring.datasource.initialization-mode`: 

1. `always` - For real databases
2. `never` - No initialization at all (i.e. if we want to do it programmatically)
3. `embedded` - Specific for embedded

## 37 @AutoConfigure test annotations

1. `@DataCassandraTest`
1. `@DataJdbcTest`
1. `@DataJpaTest`
1. `@DataLdapTest`
1. `@DataMongoTest`
1. `@DataNeo4jTest`
1. `@DataR2dbcTest`
1. `@DataRedisTest`
1. `@JdbcTest`
1. `@JooqTest`
1. `@JsonTest`
1. `@RestClientTest`	
1. `@WebFluxTest`
1. `@WebMvcTest`
1. `@WebServiceClientTest`

## 38 `spring.factories`

1. [Failure Analyzer](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.application.failure-analyzer)
2. Event Listeners
3. Configuration Classes
4. [Environment Post Processors](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.application.customize-the-environment-or-application-context)

## 39 Logs

1. Log4j - Out of the box
2. LogBack - Out of the box
3. Support for JUL - Supported
4. Commons Logging - Internal Logs

## 40 Health indicator statuses severity order

By default property `management.health.status.order` has these values:

`DOWN`, `OUT_OF_SERVICE`, `UP`, `UNKNOWN`

This means that, from left to right, the aggregated state is calculated by the existence of one instance.

Examples:

1. All Unknown and one up => UP
2. All UP and one DOWN => DOWN
3. All Unknown, one out of service and one down => DOWN

## 41 Test tools

`MockRestServiceServer`, `@ContextConfiguration`

---

[Back](../index.md) | [Index](./index.md) | [General Reminders](./Reminders.md) | [Spring Boot](./SpringBoot.md) | [Spring Boot Actuator](./SpringBootActuator.md) | [Goals](./Goals.md)
