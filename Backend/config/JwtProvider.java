package com.socialMedia.config;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {
	private static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	
	public static String generatedToken(Authentication auth) {
		String jwt = Jwts.builder()
				.setIssuer("CodewithSantu").setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() +86400000))
				.claim("email", auth.getName())
				.signWith(key)
				.compact();
		return jwt;
	}
	
	public static String getEmailFromJwtToken(String jwt) {
		jwt = jwt.substring(7);
		
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		
		String email = String.valueOf(claims.get("email"));
		
		return email;
	}
}