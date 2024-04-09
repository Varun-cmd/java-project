package org.example.jwt.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.jwt.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTservice {
    private String SECRET_KEY="f930745f97f4eee8b0b126baa03b116264562aa05b34a436b5aa2cb2e1b3dc98";


   private Claims extractAllClaims(String token){
       return Jwts
               .parser()
               .verifyWith(getSigninKey())
               .build()
               .parseSignedClaims(token)
               .getPayload();
   }

   // return specific detail from the payload

    public String extractUsername(String token){
       return extractClaim(token, Claims::getSubject);
    }
    public boolean isValid(String token, UserDetails user){
       String username=extractUsername(token);
       return(username.equals(user.getUsername())) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
       return extractClaim(token,Claims::getExpiration);
    }


    private <T> T extractClaim (String token , Function<Claims,T> resolver){
       Claims claims = extractAllClaims(token);
       return resolver.apply(claims);
    }









    public String generateToken(User user){
        String token= Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+24*60*60*1000)) // token valid for 24 hours
                .signWith(getSigninKey())
                .compact();
        return token;
    }

    private SecretKey getSigninKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
