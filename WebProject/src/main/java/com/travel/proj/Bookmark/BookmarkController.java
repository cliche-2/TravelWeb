package com.travel.proj.Bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/bookmarks")
public class BookmarkController {

	@Autowired
	private BookmarkService service;
	
	// post	  생성
	// get	  조회
	// put	  전체수정
	// patch  일부수정
	// delete 삭제
	
}
