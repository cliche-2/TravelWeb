package com.travel.proj.bookmark;

import java.util.List;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;

public interface CustomRepository {
	
	// member의 contentid 북마크 여부를 알려줌
	int findByContentidAndMember(String contentid, int member);
	
	List<Tuple> countGroupByContentid();
	
	Bookmark findByContentid(String contentid);

}
