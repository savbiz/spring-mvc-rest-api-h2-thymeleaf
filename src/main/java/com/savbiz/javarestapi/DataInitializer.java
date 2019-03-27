package com.savbiz.javarestapi;


import com.savbiz.javarestapi.entity.Product;
import com.savbiz.javarestapi.entity.User;
import com.savbiz.javarestapi.repository.ProductRepository;
import com.savbiz.javarestapi.repository.UserRepository;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  UserRepository users;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    log.debug("printing all products...");
    this.productRepository.findAll().forEach(v -> log.debug("Product :" + v.toString()));

    this.users.save(User.builder()
        .username("user")
        .password(this.passwordEncoder.encode("password"))
        .roles(Arrays.asList("ROLE_USER"))
        .build()
    );

    this.users.save(User.builder()
        .username("admin")
        .password(this.passwordEncoder.encode("password"))
        .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
        .build()
    );

    log.debug("printing all users...");
    this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
  }
}