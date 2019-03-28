package com.savbiz.javarestapi.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  @Value("${security.jwt.token.secret-key:secret}")
  private String secretKey = "secret";

  @Value("${security.jwt.token.expire-length:3600000}")
  private long validityInMilliseconds = 3600000; // 1h

  @Autowired
  private UserDetailsService userDetailsService;

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(String username, List<String> roles) {

    final Claims claims = Jwts.claims().setSubject(username);
    claims.put("roles", roles);

    final Date now = new Date();
    final Date validity = new Date(now.getTime() + validityInMilliseconds);

    return Jwts.builder()//
        .setClaims(claims)//
        .setIssuedAt(now)//
        .setExpiration(validity)//
        .signWith(SignatureAlgorithm.HS256, secretKey)//
        .compact();
  }

  Authentication getAuthentication(String token) {
    final UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));

    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  private String getUsername(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  String resolveToken(HttpServletRequest req) {
    final String bearerToken = req.getHeader("Authorization");

    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }

    return null;
  }

  boolean validateToken(final String token) {
    try {
      final Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

      return !claims.getBody().getExpiration().before(new Date());

    } catch (JwtException | IllegalArgumentException e) {
      throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
    }
  }

}