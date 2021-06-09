package com.travel.proj.bookmark;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookmarks")
public class BookmarkController {

	@Autowired
	private BookmarkService service;
	
	// post	  생성
	// get	  조회
	// put	  전체수정
	// patch  일부수정
	// delete 삭제
	
	// 북마크 추가
	@PostMapping("")
	public Map add(Bookmark bookmark) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			service.addBookmark(bookmark);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		
		return map;
		
	}
	
	// 북마크 제거
	@DeleteMapping("/{id}")
	public Map del(@PathVariable("id") int id) {
		Map map = new HashMap();
		boolean result = false;
		try {
			service.delBookmark(id);
			result = true;
		}catch(Exception e) {
			System.out.println(e);
		}
		map.put("result", result);
		return map;
	}
	
	
	// MemberId로 검색
	
	// contentid(여행지)로 검색 > 개수만 리턴
	
}
