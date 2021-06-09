package com.travel.proj.bookmark;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {
	
//	// Memnum으로 찾기
//	ArrayList<Bookmark> findByMemnum(int Memnum);
//	
	// contentid로 찾기
	ArrayList<Bookmark> findByContentid(int contentid);

}
