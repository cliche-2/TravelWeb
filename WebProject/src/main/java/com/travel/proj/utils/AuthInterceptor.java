package com.travel.proj.utils;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.travel.proj.member.JWToken;


@Component
public class AuthInterceptor implements HandlerInterceptor {
	// WebConfig에 저장된 요청이 해당되어 이 인터셉터가 실행되어
	// preHandle method를 호출한다.


	private AuthExtractor authExtractor;
	private JWToken jwToken;
	
	
	
	public AuthInterceptor(AuthExtractor authExtractor, JWToken jwToken) {
		super();
		this.authExtractor = authExtractor;
		this.jwToken = jwToken;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		
		// token 추출
		String cookie = request.getHeader("cookie");
		String jwt = cookie.substring(6);
		System.out.println("TOKENS="+jwt);
		
		//test
		Enumeration<String> em = request.getHeaderNames();
	    while(em.hasMoreElements()){
	        String name = em.nextElement() ;
	        String val = request.getHeader(name) ;
	        System.out.println(name + " : " + val) ;
	    }


//		String token = authExtractor.extract(request, "a");
		//if (StringUtils.isEmpty(token)) {
		if(jwt == null || jwt.isEmpty()) {
			throw new IllegalArgumentException("there is no token");
		}
		
//		if(!jwToken.validToken(token)) {
//			throw new IllegalArgumentException("유효하지 않은 토큰");
//		}
		
		// token decoding
		Map claimMap = new HashMap(); 
		try {
			claimMap = jwToken.verifyJWT(jwt);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("VERIFY="+claimMap);
		int memNum = jwToken.getSubject(jwt);
		
		// decoding한 값 settting
		request.setAttribute("memNum", memNum);
		
		return true;
	}
}
