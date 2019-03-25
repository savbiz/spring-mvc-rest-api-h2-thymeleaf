package com.savbiz.javarestapi.repository;

import com.savbiz.javarestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ProductRepository extends JpaRepository<Product, Long> {

}
