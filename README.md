# Spring Boot REST API with Thymeleaf and H2

A Java 11 example application for managing products, with a Thymeleaf web interface, Spring MVC, Spring Data REST/JPA, Spring Security, an in-memory H2 database and Flyway migrations. It uses Spring Boot 2.1.3.

This is a historical project from 2019 and is no longer actively maintained.

## Run locally

With Java 11 installed, run from the repository root:

```sh
./mvnw spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080). The application uses form login with demonstration accounts configured in [SecurityConfig.java](src/main/java/com/savbiz/javarestapi/config/SecurityConfig.java); their passwords and database settings are in [application.properties](src/main/resources/application.properties). These are local examples, not production credentials or a deployment configuration.

Run the existing tests with `./mvnw test`. The original dependencies and application behavior are unchanged; the legacy build has not been revalidated as part of this documentation cleanup.
