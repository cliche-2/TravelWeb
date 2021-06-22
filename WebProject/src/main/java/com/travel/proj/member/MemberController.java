package com.travel.proj.member;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/register")
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
	@PostMapping("/login")
	public Map memberLogin(Member member, HttpServletResponse response) {
		boolean result = false;
		Map map = new HashMap();
		Map claimMap = new HashMap(); 
		String jwt = null;
		Cookie cookie = null;
		
		if(member != null) {
			int memNum =service.loginSuccess(member);
			if(memNum>0) {
			// access와 refresh 2 토큰 사용하는 것도 생각해보기
			try {
				JWToken jwToken = new JWToken();
				jwt = jwToken.createToken(memNum);
				
//				map.put("jwt", jwt); 
				// 토큰을 바로 주는 게 아니라 헤더에 넣어서 보내주자.
				// map에는 사용자고유번호만 주기
				map.put("memnum", memNum);
				response.setHeader("Authorization", jwt);
				System.out.println("CREATE="+jwt);
				
				claimMap = jwToken.verifyJWT(jwt);
				System.out.println("VERIFY="+claimMap);
				
				
				result = true;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
				
		}
		
		map.put("result", result);
		return map;
	}
	
	
	// 회원조회
		// 인터셉터
		// 관리자용 모두조회
	@GetMapping("/userlist")
	public Map getAll() {
		Map map = new HashMap();
		ArrayList<Member> memberList = null;
		boolean result = false;
			
		// !관리자 접속인지 확인하는 부분 있어야 하나?
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
	
		// 인터셉터
		// 마이페이지-내정보
	// 일단 마이페이지 자체가 인증 되어야 들어갈 수 있어서
	// 이하 기능의 인증을 생략했는데 사실 구현해야 함	
	@GetMapping("/mypage")
	public Map getMember(@RequestAttribute("memNum") int memNum) {
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
	@PostMapping("/check")
	public Map checkEmail (String email) {
		Map map = new HashMap();
		boolean result = true;
		String message = "";
		boolean available = false;
		System.out.println(email);
		Member member = service.getMemberByEmail(email);
		
		try {
			if( member != null) {
				message = "이미 존재하는";
				available = false;
			} else {
				message = "사용 가능";
				available = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		
		map.put("result", result);
		map.put("available", available);
		map.put("message", message);
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
		System.out.println("result="+result);
		
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
