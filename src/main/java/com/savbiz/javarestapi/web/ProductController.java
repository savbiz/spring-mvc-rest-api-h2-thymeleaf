package com.savbiz.javarestapi.web;

import com.savbiz.javarestapi.entity.Product;
import com.savbiz.javarestapi.repository.ProductRepository;
import java.util.Optional;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

  @Autowired
  private ProductRepository repository;

  @GetMapping
  public Iterable<Product> findAll() {
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public Optional<Product> find(@PathVariable("id") Long id) {
    return repository.findById(id);
  }

  @PostMapping(consumes = "application/json")
  public Product create(@RequestBody Product product) {
    return repository.save(product);
  }

  @PutMapping(path = "/{id}")
  public Product update(@PathVariable("id") Long id, @RequestBody Product product)
      throws BadHttpRequest {
    if (repository.existsById(id)) {
      product.setId(id);
      return repository.save(product);
    } else {
      throw new BadHttpRequest();
    }
  }
}
