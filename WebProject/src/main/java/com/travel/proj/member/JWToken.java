package com.travel.proj.member;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWToken {
	
	final String key = "secretKey";
	
	
	
	
	public String createToken(int memNum) {
		// Token Header
		Map headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "HS256");
		
		// Token Payload
		Map payloads = new HashMap<>();
		payloads.put("memNum", memNum);
		
		// expiration Time
		Date expTime = new Date();
		Long timeLength = 1000*60L*60L*2L; // 2H
		expTime.setTime(expTime.getTime() + timeLength);
		
		// Token Builder
		String jwt = Jwts.builder()
				.setHeader(headers)
				.setClaims(payloads)
				.setSubject("memNum") 	// 토큰 용도
				.setExpiration(expTime) 
				.signWith(SignatureAlgorithm.HS256, key.getBytes()) // sign
				.compact(); // create token
		
		return jwt;
	}
	
	
	
	 // 필터?
	public Map verifyJWT(String jwt) throws UnsupportedEncodingException{
		
		Map claimMap = null;
		
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(key.getBytes("UTF-8"))
					.parseClaimsJws(jwt) // parsing and verifying
					.getBody();
			
			claimMap = claims;
			
		} catch (ExpiredJwtException e) { 
			// Token Expired
			e.printStackTrace();
			return null;
			
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return claimMap;
	}
	
	

}
