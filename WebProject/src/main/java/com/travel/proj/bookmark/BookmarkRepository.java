package com.travel.proj.bookmark;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer>, CustomRepository {
	
//	// Memnum으로 찾기
//	ArrayList<Bookmark> findByMember(int Memnum);
//	
	// contentid로 찾기
//	Integer countByContentid(); // 반환 데이터타입 맞는지 주의

}
