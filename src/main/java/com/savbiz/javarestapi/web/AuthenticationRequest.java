package com.savbiz.javarestapi.web;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AuthenticationRequest implements Serializable {

  private String username;
  private String password;
}