package com.travel.proj.bookmark;

public interface CustomRepository {
	
	// member의 contentid 북마크 여부를 알려줌
	int findByContentidAndMember(String contentid, int member);

}
