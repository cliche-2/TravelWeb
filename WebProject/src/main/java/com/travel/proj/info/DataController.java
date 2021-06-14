package com.travel.proj.info;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/travel")
public class DataController {

	
	
	
	// 지역별로 Get Mapping
	@GetMapping("/area/{sigungu}")
	public Map showArea(@PathVariable("sigungu") String sigungu) {
		Map map = new HashMap();
		boolean result = false;
		String jsonResult = "";
		
		try {
			// api 콜하기
			ApiExplorer apiEx = new ApiExplorer();
			jsonResult= apiEx.areaBasedList(sigungu);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("jsonResult", jsonResult);
		map.put("result", result);
		
		return map;
	}

		
	// 카테고리별로 Get Mapping
	@GetMapping("{category}")
	public Map showCategory(@PathVariable("category") String category) {
		Map map = new HashMap();
		boolean result = false;
		String jsonResult = "";
		
		System.out.println(category);
		
		try {
			// api 콜하기
			ApiExplorer apiEx = new ApiExplorer();
			jsonResult= apiEx.typeBasedList(category);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		map.put("jsonResult", jsonResult);
		map.put("result", result);
		
		return map;
	}
	
	
	// 카테고리 전체보기 (수정필요 DO NOT USE)
	@GetMapping("")
	public Map showAllCategory() {
		Map map = new HashMap();
		boolean result = false;
		String jsonResult = "";
		
		try {
			ApiExplorer apiEx = new ApiExplorer();
//				jsonResult= apiEx.typeBasedList(category);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 문자열 대신 json 객체 반환하기
		map.put("jsonResult", jsonResult);
		map.put("result", result);
		
		return map;
	}
	
	
	// 세부정보 보기
	@GetMapping("/detail/{contentId}")
	public Map showDetailCommon(@PathVariable("contentId") String contentId) {
		Map map = new HashMap();
		boolean result = false;
		String jsonResult = "";
		
		try {
			ApiExplorer apiEx = new ApiExplorer();
			jsonResult= apiEx.detailCommon(contentId);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject(jsonResult);
		System.out.println( jsonObject.get("response"));
		
		map.put("jsonResult", jsonObject.get("response"));
		map.put("result", result);
		
		return map;
	}
	
		
	
	
	
	
}
