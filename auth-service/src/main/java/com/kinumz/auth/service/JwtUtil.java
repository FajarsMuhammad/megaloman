package com.kinumz.auth.service;

import com.kinumz.auth.client.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Value("${token.expiration}")
    private String expiration;

    public String generateToken(UserResponse user, String tokenType) {
        Map<String, String> claims = Map.of("id", user.getId().toString(),
                                            "role", user.getRole());
        return generateToken(claims, tokenType);
    }


    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private String generateToken(Map<String, String> claims, String tokenType) {
        long expMilis = "ACCESS".equalsIgnoreCase(tokenType)
            ? Long.parseLong(expiration) * 1000
            : Long.parseLong(expiration) * 5;

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(claims.get("id"))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expMilis))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
