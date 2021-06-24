package com.travel.proj.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private final AuthInterceptor authInterceptor;

	public WebConfig(AuthInterceptor authInterceptor) {
			this.authInterceptor = authInterceptor;
	}
	
	// 어떤요청에 대해 intercept할지 등록.
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("interceptor added");
		registry.addInterceptor(authInterceptor).addPathPatterns("/members/mypage");
		registry.addInterceptor(authInterceptor).addPathPatterns("/members/bookmarks");
		registry.addInterceptor(authInterceptor).addPathPatterns("/members/userlist");
		registry.addInterceptor(authInterceptor).addPathPatterns("/notice/write");
		registry.addInterceptor(authInterceptor).addPathPatterns("/notice/delete/{num}");

	}
	

}
