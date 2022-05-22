package com.glomaksi.pizzashopbackend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Optional;
import java.util.function.Function;


public class JwtUtils {

    private static final String BEARER = "Bearer";


    public static String createToken(String name, String secretKey, Long validityInMilliseconds) {
        Claims claims = Jwts.claims().setSubject(name);

        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static boolean validateToken(String token, String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Optional<String> getBearerToken(String headerVal) {
        if (headerVal != null && headerVal.startsWith(BEARER)) {
            return Optional.of(headerVal.replace(BEARER, "").trim());
        }
        return Optional.empty();
    }

    private static <T> T getClaimFromToken(String token,
                                           Function<Claims, T> claimsResolver,
                                           String secret) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    	return claimsResolver.apply(claims);
    }

    public static boolean isJwtExpired(String token, String secret) {
        try {
            Date expired = getClaimFromToken(token, Claims::getExpiration, secret);
            return expired.before(new Date());
        } catch (ExpiredJwtException exception) {
            return true;
        }
    }

    public static String getNameFromToken(String token, String secret) {
        return getClaimFromToken(token, Claims::getSubject, secret);
    }
}
