package com.travel.proj.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {

	private String serviceKey="hFsPRQWYdGq2msydGDgKrVrhBgd0Rf7ydXE3xpMsKYYWVCxRxmFmut0xklaGgUuOMRuWH4INxl7dZw4rtjdR4w%3D%3D";
	private String url="";
	private String areaCode = "1"; // 서울 지역코드
	
	public ApiExplorer() {
		// TODO Auto-generated constructor stub
	}
	
	/* 지역 기반 목로 조회 */
	public void areaBasedList() {
	url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
	StringBuilder urlBuilder = new StringBuilder(url);
		
		try {
			// 요청 생성
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey) /*Service Key*/
					  .append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")) /*한 페이지 결과수*/
					  .append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")) /*현재 페이지 번호*/
					  .append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")) /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					  .append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")) /*서비스명=어플명*/
					  .append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")) /*지역코드, 시군구코드*/
					  .append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
					
			URL url = new URL(urlBuilder.toString());
			
			
			// 이하 공통부분
			
			// 연결 설정
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        // 응답 받기
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	
	        // 데이터 저장
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        // 연결 종료
	        rd.close();
	        conn.disconnect();
	        
	        
	        System.out.println(sb.toString());
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	/* ~~ */
	
	/* 공통 */
	
	
}
