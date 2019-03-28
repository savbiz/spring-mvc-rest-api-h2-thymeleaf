package com.savbiz.javarestapi.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is mandatory!")
  @NotNull
  private String name;

  @NotNull(message = "Current price is mandatory!")
  private BigDecimal currentPrice;

  private Date lastUpdate;

  @PreUpdate
  protected void onUpdate() {
    lastUpdate = new Date();
  }
}
