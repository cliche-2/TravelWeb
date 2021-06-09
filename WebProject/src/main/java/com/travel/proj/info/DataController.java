package com.travel.proj.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class DataController {

	// 카테고리별로 Get Mapping
	@GetMapping("mountains")
	public Map showMountain1() {
		Map map = new HashMap();
		boolean result = false;
		
		
		
		return map;
	}
	
	
	
	
}
