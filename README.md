# Spring Boot Rest API + Thymeleaf + H2 (secured with Spring Securit)

## How to run it

The app has been dockerized so just run the following command to fetch the image from Docker Hub (https://cloud.docker.com/repository/docker/savbiz/java-rest-api).

Here's an example on how to run it:

```
$ docker run -p 8080:8080 savbiz/java-rest-api
``` 
Then the bot will start and the following output will be printed:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.3.RELEASE)

2019-03-28 18:54:07.206  INFO 1 --- [           main] com.savbiz.javarestapi.Application       : Starting Application on 129937e38e42 with PID 1 (/app started by root in /)
2019-03-28 18:54:07.210  INFO 1 --- [           main] com.savbiz.javarestapi.Application       : No active profile set, falling back to default profiles: default
2019-03-28 18:54:08.203  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2019-03-28 18:54:08.316  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 102ms. Found 1 repository interfaces.
2019-03-28 18:54:08.947  INFO 1 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$355fb5f6] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-03-28 18:54:08.987  INFO 1 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.hateoas.config.HateoasConfiguration' of type [org.springframework.hateoas.config.HateoasConfiguration$$EnhancerBySpringCGLIB$$b4e00328] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-03-28 18:54:09.598  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-03-28 18:54:09.636  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-03-28 18:54:09.637  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.16]
2019-03-28 18:54:09.658  INFO 1 --- [           main] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib]
2019-03-28 18:54:09.808  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-03-28 18:54:09.808  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2521 ms
2019-03-28 18:54:09.961  INFO 1 --- [           main] o.s.boot.web.servlet.RegistrationBean    : Servlet webServlet was not registered (possibly already registered?)
2019-03-28 18:54:10.085  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-03-28 18:54:10.342  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-03-28 18:54:10.478  INFO 1 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 5.2.4 by Boxfuse
2019-03-28 18:54:10.488  INFO 1 --- [           main] o.f.c.internal.database.DatabaseFactory  : Database: jdbc:h2:mem:productsdb (H2 1.4)
2019-03-28 18:54:10.519  WARN 1 --- [           main] o.f.c.internal.database.base.Database    : Flyway upgrade recommended: H2 1.4.199 is newer than this version of Flyway and support has not been tested.
2019-03-28 18:54:10.605  INFO 1 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 1 migration (execution time 00:00.021s)
2019-03-28 18:54:10.622  INFO 1 --- [           main] o.f.c.i.s.JdbcTableSchemaHistory         : Creating Schema History table: "PUBLIC"."flyway_schema_history"
2019-03-28 18:54:10.680  INFO 1 --- [           main] o.f.core.internal.command.DbBaseline     : Successfully baselined schema with version: 1
2019-03-28 18:54:10.695  INFO 1 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema "PUBLIC": 1
2019-03-28 18:54:10.697  INFO 1 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema "PUBLIC" to version 2 - addDescription
2019-03-28 18:54:10.729  INFO 1 --- [           main] o.f.core.internal.command.DbMigrate      : Successfully applied 1 migration to schema "PUBLIC" (execution time 00:00.046s)
2019-03-28 18:54:10.910  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
2019-03-28 18:54:11.015  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.7.Final}
2019-03-28 18:54:11.017  INFO 1 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-03-28 18:54:11.261  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
2019-03-28 18:54:11.505  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2019-03-28 18:54:12.312  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2019-03-28 18:54:13.713  INFO 1 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: any request, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@11fb1691, org.springframework.security.web.context.SecurityContextPersistenceFilter@6a26eee6, org.springframework.security.web.header.HeaderWriterFilter@2dbf8cfc, org.springframework.security.web.authentication.logout.LogoutFilter@5ead245, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@1d4e06bb, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@1248f83, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@6e149395, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@1f229c40, org.springframework.security.web.session.SessionManagementFilter@e76134d, org.springframework.security.web.access.ExceptionTranslationFilter@f6e3b67, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@7c1c0892]
2019-03-28 18:54:13.983  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-03-28 18:54:14.320  INFO 1 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2019-03-28 18:54:14.756  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-03-28 18:54:14.761  INFO 1 --- [           main] com.savbiz.javarestapi.Application       : Started Application in 8.104 seconds (JVM running for 8.607)20:55:24.756 [WebSocketClient@785570251-14] INFO com.savbiz.buxtradingbot.bot.SingleTradingBot - Ignoring trading quote as current price 13.66 is not equal to wanted buy price 13.28....
```

## Improvements

* Frontend with Angular can be created so it's easier to handle JWT;
* Use persistant DB (MySQL, PostgreSQL etc...);
* Use HTTPS
* Consider OAuth
* and many more...

### Author
**Savino Bizzoca**