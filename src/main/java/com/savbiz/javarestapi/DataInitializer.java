package com.savbiz.javarestapi;


import com.savbiz.javarestapi.entity.User;
import com.savbiz.javarestapi.repository.ProductRepository;
import com.savbiz.javarestapi.repository.UserRepository;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

  @Value("${user.password}")
  private String userPassword;

  @Value("${admin.password}")
  private String adminPassword;


  @Autowired
  ProductRepository productRepository;

  @Autowired
  UserRepository users;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) {
    users.save(User.builder()
        .username("user")
        .password(passwordEncoder.encode(userPassword))
        .roles(Collections.singletonList("ROLE_USER"))
        .build()
    );

    users.save(User.builder()
        .username("admin")
        .password(passwordEncoder.encode(adminPassword))
        .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
        .build()
    );
  }
}