package com.template.rest.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private final String securityKey = "askdjhfaskjdhfakjwsdhfaksjhdfkajshdfkjashd";
    //private final Long expiredTime = 1000 * 60L * 60L * 3L; // 유효시간 3시간
    private final Long expiredTime = 1000L * 60L;

    private Key signingKey = null;

    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public JWTService() {
        signingKey = new SecretKeySpec(securityKey.getBytes(StandardCharsets.UTF_8), signatureAlgorithm.getJcaName());
    }

    public String createToken() {
        Date now = new Date();
        return Jwts.builder()
                .setSubject("username") // 보통 username
                .setHeader(createHeader())
                .setClaims(createClaims()) // 클레임, 토큰에 포함될 정보
                .setExpiration(new Date(now.getTime() + expiredTime)) // 만료일
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256"); // 해시 256 사용하여 암호화
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private Map<String, Object> createClaims() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "darkbati"); // username
        claims.put("roles", "test"); // 인가정보
        return claims;
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
    }

    public String getSubject(String token) {
        final String[] username = {null};
        try {
            Jwts.parserBuilder().setSigningKeyResolver(new SigningKeyResolverAdapter() {
                @Override
                public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
                    // implement me
                    username[0] = String.valueOf(claims.get("username1"));

                    return signingKey;
                }
            }).build().parseClaimsJwt(token);
        } catch(Exception e) {
            System.out.println("");
        }

        return username[0];
    }

}
