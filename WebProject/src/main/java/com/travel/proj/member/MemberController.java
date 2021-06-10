package com.travel.proj.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.proj.bookmark.Bookmark;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 회원가입
	public Map addMem(Member member) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			service.addMember(member);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		return map;
	}
	
	// 로그인
	
	
	// 회원조회
		// 관리자용 모두조회
	@GetMapping("")
	public Map getAll() {
		Map map = new HashMap();
		ArrayList<Member> memberList = null;
		boolean result = false;
			
		// !관리자 접속인지 확인하는 부분 있어야 함!
		if (true) {
			try {
				memberList = service.getAll();
				result = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 관리자 확인 안된경우
		}
		
		map.put("memberList", memberList);
		map.put("result", result);
		
		return map;
	}
		// 마이페이지-내정보
	@GetMapping("/{memNum}")
	public Map getMember(@PathVariable("memNum") int memNum) {
		Map map = new HashMap();
		boolean result = false;
		Member m = null;
		try {
			m = service.getMemberByMemnum(memNum);
			result = true;
		}catch(Exception e) {
			System.out.println(e);
		}
		map.put("result", result);
		map.put("m", m);
		return map;
	}
		// 마이페이지-북마크목록
	@GetMapping("/bookmarks/{memNum}")
	public Map getBookmarks(@PathVariable("memNum") int memNum) {
		Map map = new HashMap();
		boolean result = false;
		ArrayList<Bookmark> bookmarks = null;
		
		try {
			bookmarks = service.getBookmarks(memNum);
			result = true;
		}catch(Exception e) {
			System.out.println(e);
		}
		map.put("result", result);
		map.put("bookmarks",bookmarks);
		return map;
	}
		// 이메일 중복체크
	@GetMapping("/check/{email}")
	public Map checkEmail (@PathVariable("email") String email) {
		Map map = new HashMap();
		boolean result = false;
		String message = "";
		
		try {
			if(service.getMemberByEmail(email) != null) {
				message = "이미 존재하는";
			} else {
				message = "사용 가능";
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	// 회원정보수정
	@PutMapping("/{memNum}")
	public Map editMember (Member member) {
		Map map = new HashMap();
		boolean result = false;
		
		try {
			service.editMember(member);
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("result", result);
		
		return map;
		
	}
	
	// 회원탈퇴
	@DeleteMapping("/{memNum}")//삭제. json반환(처리결과(result:true/false))
	public Map delMember(@PathVariable("memNum") int memNum) {
		Map map = new HashMap();
		boolean result = false;
		try {
			service.delMember(memNum);
			result = true;
		}catch(Exception e) {
			System.out.println(e);
		}
		map.put("result", result);
		return map;
	}
	
	

}
