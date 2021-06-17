package com.travel.proj.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notice")
public class InfoBoardController {

	@Autowired
	private InfoBoardService service;
	
	// 공지 목록 조회
	@GetMapping("")
	public Map getAll() {
		Map map = new HashMap();
		boolean result = false;
		ArrayList<InfoBoard> boardList = null;
		
		try {
			boardList = service.getAll();
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("boardList", boardList);
		map.put("result", result);		
		
		return map;		
	}
	
	
	// 공지 게시글 조회
	@GetMapping("/{num}")
	public Map getOne(@PathVariable("num") int num) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			InfoBoard infoBoard = null;
			infoBoard = service.getInfoBoardByNum(num);
			if(infoBoard != null) {
				map.put("board", infoBoard);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		return map;
	}
	
	
	// 인터셉터
	// 공지 작성 - 관리자만
	@PostMapping("/write")
	public Map add(InfoBoard infoBoard) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			service.add(infoBoard);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		return map;
	}
	
	
	// 공지 삭제 - 관리자만
	@DeleteMapping("/delete/{num}")
	public Map del(@PathVariable("num") int num) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			service.delete(num);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		return map;
	}
	
	
}
