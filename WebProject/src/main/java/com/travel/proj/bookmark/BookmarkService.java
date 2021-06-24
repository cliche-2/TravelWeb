package com.travel.proj.bookmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;

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
	public List groupByContentid(int count){
		List<ListVo> results = rep.countGroupByContentid();
//		List<String>cidList = new ArrayList<>();
//		Map map = new HashMap();
		List<BookmarkVo>list = new ArrayList<>();
		
//		for(Tuple t: results) {
//			cidList.add(t.get(0,String.class));
//		}
		
//		for(int i=0; i<count; i++) {
//			cidList.add(results.get(i).get(0,String.class));
//			map.put(results.get(i).get(0,String.class), results.get(i).get(1,String.class));
//		}
		for(int i=0; i<count; i++) {
			BookmarkVo bVo = new BookmarkVo();
			Bookmark bookmark = null;
			String cid= results.get(i).getContentid();
			bookmark= rep.findByContentid(cid);
			bVo.setContentid(cid);
			bVo.setFirstimage(bookmark.getFirstimage());
			bVo.setTitle(bookmark.getTitle());
			list.add(bVo);
		}
		
		
		
		return list;
	}

}
