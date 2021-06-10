package com.travel.proj.info;

import java.util.HashMap;
import java.util.Map;

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
	@GetMapping("{sigungu}")
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
		
		map.put("jsonResult", jsonResult);
		map.put("result", result);
		
		return map;
	}
	
	
	// 세부정보 보기
	@GetMapping("{contentId}")
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
		
		map.put("jsonResult", jsonResult);
		map.put("result", result);
		
		return map;
	}
	
		
	
	
	
	
}
