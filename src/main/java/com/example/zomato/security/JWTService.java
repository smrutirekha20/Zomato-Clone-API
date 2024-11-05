package com.example.zomato.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JWTService {

    @Value("${zomato.jwt.secret}")
    private String secret;

    public String generateJWT(String username,long expiringDuration,String role){
        return Jwts.builder()
                .setClaims(Map.of("role",role))
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiringDuration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSigningKey(){
       return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }

    public Claims extractClaims(String token){
       return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(Claims claims){
        return claims.getSubject();
    }

    public Date getIssuedAt(Claims claims){
        return claims.getIssuedAt();
    }
    public Date getExpiringDate(Claims claims){
        return claims.getExpiration();
    }

    public String getRole(Claims claims){
        return claims.get("role",String.class);
    }


}
