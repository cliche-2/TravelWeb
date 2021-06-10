package com.travel.proj.member;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.proj.bookmark.Bookmark;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	// email로 memNum찾기
	@Query(value = "SELECT memNum FROM member WHERE email = ?1", nativeQuery = true)
	int findMemNumByEmail(String email);
	
	// memNum으로 bookmark리스트 찾기
	@Query(value = "SELECT bookmarks FROM member WHERE memNum=?1", nativeQuery = true) // 쿼리 필수?
	ArrayList<Bookmark> findBookmarksBymemNum(int memNum);
	
	

}
