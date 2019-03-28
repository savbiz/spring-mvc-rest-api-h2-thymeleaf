package com.savbiz.javarestapi.config;

import com.savbiz.javarestapi.security.LoggingAccessDeniedHandler;
import com.savbiz.javarestapi.security.jwt.JwtConfigurer;
import com.savbiz.javarestapi.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  private LoggingAccessDeniedHandler accessDeniedHandler;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
        .httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/auth/signin").permitAll()
        .antMatchers(HttpMethod.GET, "/api/product").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/api/product").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/api/product/add").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/api/product/new").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/api/product/delete/*").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/api/product/update/*").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler)
        .and()
        .apply(new JwtConfigurer(jwtTokenProvider));
  }
}