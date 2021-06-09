package com.travel.proj.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.proj.bookmark.Bookmark;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository rep;
	
	// 멤버 추가
	public Member addMember(Member member) {
		return rep.save(member);
	}
	
	// 멤버 수정
	public void editMember(Member member) {
		rep.save(member); // memNum 지정한 객체여야 수정됨
	}
	
	// 멤버 객체 조회
		// 멤버 번호로
	public Member getMemberByMemnum(int memNum) {
		return rep.findById(memNum).orElse(null);
	}
		// 멤버 이메일로
		// 멤버 아이디로
	public Member getMemberByEmail(String email)	{
		int memNum=rep.findMemNumByEmail(email);
		return rep.findById(memNum).orElse(null);
	}
		// 멤버 모두 조회
	public ArrayList<Member> getAll(){
		return (ArrayList<Member>)rep.findAll();
	}
	
	// 멤버 삭제
	public void delMember(int memNum) {
		rep.deleteById(memNum);
	}
	
	// 해당 멤버의 북마크리스트 가져오기
	public ArrayList<Bookmark> getBookmarks(int memNum){
		ArrayList<Bookmark> list = null;
		list = rep.findBookmarksBymemNum(memNum);
		return list;
	}
	

	
	
}
