package com.travel.proj.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {

	private String serviceKey=""; 
	private String areaCode = "1"; 	// 서울 지역코드
	private String MobileOS = "ETC";// OS 구분
	private String numOfRows = "10";// 페이지 당 결과 수 - 고정 
	private String pageNo ="1";
	// 현재 페이지 번호 <<<<< 페이지 넘기는 거 수정하기
	// 사용할 데이터 양이 얼마나 되는 지 확인한 후, 최대값 (예를 들어 500) 으로 지정해서, 모든 데이터를 한번에 넘겨 주고 페이지 처리는 vue에서 하도록 할까
	// vue에서 현재 페이지번호(default =1)와 원하는 페이지번호 값 받아오면 백엔드서버에서 처리하는 방식?  
	
	private String arrange ; 	// 정렬 구분: O제목순 P조회순 Q수정일순 R생성일순 
	
	private String contentTypeId;	// 관광타입 ID
	private String sigunguCode	; 	// 시군구코드
	private String keyword;	// 키워드
	private String cat1	;	// 대분류 코드
	private String cat2	;	// 중분류 코드
	private String cat3	;	// 소분류 코드
	
	
	public ApiExplorer() {
		
	}
	
	/* 카테고리 설정하는 method */
	private void setCatCode(String category) {
		switch (category) {
		case "mountains":
			contentTypeId = "12"; cat1="A01"; cat2="A0101"; cat3="A01010400";
			break;
		case "rivers":
			contentTypeId = "12"; cat1="A01"; cat2="A0101"; cat3="A01011800";
			break;
		case "parks":
			contentTypeId = "12"; cat1="A02"; cat2="A0202"; cat3="A02020700";
			break;
		case "palaces":
			contentTypeId = "12"; cat1="A02"; cat2="A0201"; cat3="A02010100";
			break;
		case "landmarks":
			contentTypeId = "12"; cat1="A02"; cat2="A0205"; cat3="A02050600";
			break;
		case "museums": // 지울까.
			contentTypeId = "14"; cat1="A02"; cat2="A0206"; cat3="A02060100";
			break;
		default:
			break;
		}
	} // setCatCode()
	
	
	private void setSigunguCode(String sigungu) {
		switch (sigungu) {
		case "gangnam":
			sigunguCode = "1"; 
			break;
		case "mapo":
			sigunguCode = "13"; 
			break;
		case "dongdaemun":
			sigunguCode = "11"; 
			break;
		case "yongsan":
			sigunguCode = "21"; 
			break;
		case "jongno":
			sigunguCode = "23"; 
			break;
		default:
			break;
		}
	}
	
	
	/* json요청하고 데이터 받는 공통 부분*/
	private String getJsonData(URL url) {
		String result="";
		
		// 데이터 저장
		StringBuilder sb;
		try {
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

			sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
			    sb.append(line);
			}
			
			// 연결 종료
			rd.close();
			conn.disconnect();

	        result = sb.toString();
	        
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return result;
	} // getJsonData()
	
	
	
	/* 지역 기반 목로 조회 */
	public String areaBasedList(String sigungu) {
		String baseUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
		StringBuilder urlBuilder = new StringBuilder(baseUrl);
		String result ="";
		setSigunguCode(sigungu);
		
		
			try {
				// 요청 생성
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey) /*Service Key*/
						  .append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")) /*한 페이지 결과수*/
						  .append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")) /*현재 페이지 번호*/
						  .append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode(MobileOS, "UTF-8")) /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
						  .append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")) /*서비스명=어플명*/
						  .append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")) /*정렬 제목순*/
						  .append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"))
						  .append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")) /*지역코드, 시군구코드*/
						  .append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode(sigunguCode, "UTF-8")) /*지역코드, 시군구코드*/
						  .append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")) /* 목록 또는 개수*/
						  .append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
						
				URL url = new URL(urlBuilder.toString());
//				System.out.println(url);
				result=getJsonData(url);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
	} // areaBasedList()
	
	
	
	/* 타입 기반 목로 조회 */
	public String typeBasedList(String category) {
		String baseurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";
		StringBuilder urlBuilder = new StringBuilder(baseurl);
		String result ="";
		
		setCatCode(category);
		
			try {
				// 요청 생성
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey) /*Service Key*/
						  .append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")) /*한 페이지 결과수*/
						  .append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")) /*현재 페이지 번호*/
						  .append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode(MobileOS, "UTF-8")) /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
						  .append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")) /*서비스명=어플명*/
						  .append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8")) /*지역코드*/
						  .append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("O", "UTF-8")) /*정렬 제목순*/
						  .append("&" + URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode(cat1, "UTF-8")) 
						  .append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode(cat2, "UTF-8")) 
						  .append("&" + URLEncoder.encode("cat3","UTF-8") + "=" + URLEncoder.encode(cat3, "UTF-8")) 
						  .append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
						
				URL url = new URL(urlBuilder.toString());
				result=getJsonData(url);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
	} // typeBasedList()
	
	
	/* 여행지 세부 항목 조회 */
	public String detailCommon(String contentId) {
		String baseurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon";
		StringBuilder urlBuilder = new StringBuilder(baseurl);
		String result ="";
		
			try {
				// 요청 생성
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey) /*Service Key*/
						  .append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")) /*한 페이지 결과수*/
						  .append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")) /*현재 페이지 번호*/
						  .append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode(MobileOS, "UTF-8")) /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
						  .append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")) /*서비스명=어플명*/
						  .append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentId, "UTF-8"))
						  .append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8"))
						  .append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"))
						  .append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
						
				URL url = new URL(urlBuilder.toString());
				result =getJsonData(url);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	} // detailCommon()
	
	
	
	/* 키워드 검색 조회 */
	public String searchKeyword(String keyword) {
		String baseurl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword";
		StringBuilder urlBuilder = new StringBuilder(baseurl);
		String result ="";
		
			try {
				// 요청 생성
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey) /*Service Key*/
						  .append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")) /*한 페이지 결과수*/
						  .append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")) /*현재 페이지 번호*/
						  .append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode(MobileOS, "UTF-8")) /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
						  .append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")) /*서비스명=어플명*/
						  .append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(areaCode, "UTF-8"))
						  .append("&" + URLEncoder.encode("keyword","UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8"))	
						  .append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
						
				URL url = new URL(urlBuilder.toString());
				result =getJsonData(url);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
	} // detailCommon()
	
	
	
}
