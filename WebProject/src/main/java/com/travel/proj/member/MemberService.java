package com.travel.proj.member;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.proj.bookmark.Bookmark;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository rep;
	
	// 멤버 추가
	public Member addMember(Member member) {
		Date date = new Date();
		member.setRegDate(date);
		return rep.save(member);
	}
	
	// 멤버 수정
	public void editMember(Member member) {
		rep.save(member); // memNum 지정한 객체여야 수정됨
	}
	
	// 로그인 체크
	public boolean loginSuccess(Member member) {
		boolean result =  false;
		int memNum= 0;
		memNum = rep.findMemNumByEmail(member.getEmail());
		
		if(memNum>0) {// 아이디 없음
			String pw = (rep.findById(memNum).orElse(null)).getPassword();
			if(pw.equals(member.getPassword())) {
				result = true;
			}
		}
		
		return result;
	}
	
	// 멤버 객체 조회	
		// 멤버 번호로
	public Member getMemberByMemnum(int memNum) {
		return rep.findById(memNum).orElse(null);
	}
		// 멤버 이메일로
	public Member getMemberByEmail(String email)	{
		int memNum=0;
		memNum=rep.findMemNumByEmail(email);
		
		if (memNum==0) return null;
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
