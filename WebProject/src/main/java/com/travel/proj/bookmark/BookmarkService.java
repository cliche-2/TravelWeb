package com.travel.proj.bookmark;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.proj.member.Member;

@Service
public class BookmarkService {
	
	@Autowired
	private BookmarkRepository rep;
	
	// 북마크 추가
	public Bookmark addBookmark(Bookmark bookmark) {
		return rep.save(bookmark);
	}
	
	// 북마크 제거
	public void delBookmark(int num) {
		rep.deleteById(num);
	}

//	// MemNum로 검색    >> member에서 처리하기
//	public ArrayList<Member> findByMemNum(int memNum){
//		return (ArrayList)rep.findByMemnum(memNum);
//	}
	
	// contentid(여행지)로 검색 > 개수만 리턴
	public int countByContentid(String contentid){
		return (int)rep.countByContentid(contentid);
	}

}
