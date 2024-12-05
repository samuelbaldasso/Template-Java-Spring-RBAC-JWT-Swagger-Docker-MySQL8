package com.sbaldasso.combo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {

    private final String jwtSecret = "eyJhbGciOiJIUzUxMiJ9eyJzdWIiOiJzYW0iLCJleHAiOjE2MDgwNjM1NTUsImlhdCI6MTYwODA0NTU1NX0";

    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        long expirationTime = 3600000L;
        return Jwts.builder().setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.ES256, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token, String username){
        final String extracted = extractUsername(token);
        return (extracted.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAll(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return extractAll(token).getSubject();
    }

    public Claims extractAll(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody();
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization ");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        return claims.getExpiration().after(new Date());
    }
}
