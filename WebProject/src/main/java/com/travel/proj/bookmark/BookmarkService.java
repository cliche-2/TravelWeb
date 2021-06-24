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

//	// MemNum로 검색   
//	public ArrayList<Bookmark> findByMemNum(int memNum){
//		return (ArrayList)rep.findByMember(memNum);
//	}
	
	// contentid와 memnum에 해당하는 booknum 찾기
	public int getBookNum(String contenid, int memNum) {
		int bookNum =0;
		bookNum = rep.findByContentidAndMember(contenid, memNum);
		return bookNum;
	}
	
	// contentid(여행지)로 검색 > 개수만 리턴
	public int countByContentid(String contentid){
		return (int)rep.countByContentid(contentid);
	}

}
