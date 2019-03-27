package com.savbiz.javarestapi.web;

import com.savbiz.javarestapi.entity.Product;
import com.savbiz.javarestapi.repository.ProductRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @RequestMapping({"/"})
  public String index(final Model model) {
    model.addAttribute("products", productRepository.findAll());
    return "index";
  }

  @GetMapping("/newproduct")
  public String showSignUpForm(final Product product) {
    return "add-product";
  }

  @PostMapping("/addproduct")
  public String addProduct(@Valid final Product product, final BindingResult result,
      final Model model) {
    if (result.hasErrors()) {
      return "add-product";
    }

    productRepository.save(product);
    model.addAttribute("products", productRepository.findAll());

    return "index";
  }

  @GetMapping("/edit/{id}")
  public String showUpdateForm(@PathVariable("id") final Long id, final Model model) {
    final Product product = productRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));

    model.addAttribute("product", product);

    return "update-product";
  }

  @PostMapping("/update/{id}")
  public String updateProduct(@PathVariable("id") final Long id, @Valid final Product product,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      product.setId(id);
      return "update-product";
    }

    productRepository.save(product);
    model.addAttribute("products", productRepository.findAll());

    return "index";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable("id") final Long id, final Model model) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));

    productRepository.delete(product);
    model.addAttribute("products", productRepository.findAll());

    return "index";
  }
}