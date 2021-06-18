package com.travel.proj.member;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

// JWT service
@Component
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
		String jwt=null;
		try {
			jwt = Jwts.builder()
					.setHeader(headers)
					.setClaims(payloads)
					.setSubject("memNum") 	// 토큰 용도
					.setExpiration(expTime) 
					// 고정된 key를 바로 사용했지만
					// key를 매번 만들어주는 것도 좋음
					.signWith(SignatureAlgorithm.HS256, key.getBytes("UTF-8")) // sign
					.compact();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jwt;
	}
	
	
	// 토큰 유효성 검사
	public boolean validToken(String jwt) {
		
		try {
			Jws<Claims> claims = Jwts.parser()
					.setSigningKey(key.getBytes("UTF-8"))
					.parseClaimsJws(jwt);
			if(claims.getBody().getExpiration().before(new Date())) {
				return false;
			}
			
			return true;
			
		} catch (JwtException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	 // 검증을 위한 값 추출
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
	
	// 토큰에서 memNum 추출하기
	public int getSubject(String token) {
		int memNum=0;
		try {
			memNum = (int) Jwts.parser().setSigningKey(key.getBytes("UTF-8")).parseClaimsJws(token).getBody().get("memNum");
		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return memNum;
	}
	

}
