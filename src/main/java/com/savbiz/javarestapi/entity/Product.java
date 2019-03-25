package com.savbiz.javarestapi.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

  @Id
  private Long id;
  private String name;
  private BigDecimal currentPrice;
  private Date lastUpdate;

  @PreUpdate
  protected void onUpdate() {
    lastUpdate = new Date();
  }

}
