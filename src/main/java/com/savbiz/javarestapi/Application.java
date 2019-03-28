package com.savbiz.javarestapi;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public ServletRegistrationBean<WebServlet> h2servletRegistration() {
    final ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<>(new WebServlet());
    registration.addUrlMappings("/h2-console/*");
    return registration;
  }
}
