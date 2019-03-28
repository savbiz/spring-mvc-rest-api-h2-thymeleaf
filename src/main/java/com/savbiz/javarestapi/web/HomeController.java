package com.savbiz.javarestapi.web;

import com.savbiz.javarestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private final ProductRepository productRepository;

  @Autowired
  public HomeController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("/")
  public String root(final Model model) {
    model.addAttribute("products", productRepository.findAll());

    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/logout")
  public String logout() {
    return "login";
  }

  @GetMapping("/access-denied")
  public String accessDenied() {
    return "/error/access-denied";
  }
}