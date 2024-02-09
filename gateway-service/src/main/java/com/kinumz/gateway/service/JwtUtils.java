package com.kinumz.gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils{

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    private Key key;

    public JwtUtils(){
        this.key = Keys.hmacShaKeyFor(jwtSigningKey.getBytes());
    }

    public Claims getClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }


}
