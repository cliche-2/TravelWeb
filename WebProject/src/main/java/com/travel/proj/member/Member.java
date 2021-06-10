package com.travel.proj.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.travel.proj.bookmark.Bookmark;

@Entity
public class Member {

	@Id // 시퀀스 임의생성했지만 랜덤값만드는게 안전하려나? 세션..?에 저장할 값
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_sequence")
	@SequenceGenerator(name = "mem_sequence", sequenceName = "seq_mem", allocationSize=1)
	private int memNum;
	private String email; 	// 로그인 시 사용할 아이디, 유일값
//	private String email2;  // 아이디찾기 시 연락가능한 email2, default = email 
	private String password; 
	private String name;	// 닉네임, 유일값
	private Date regDate; // 데이터타입 유의
	@OneToMany(mappedBy = "member")
	private List<Bookmark> bookmarks = new ArrayList<>();
	
	public Member() {};
	
	public Member(int memNum, String email, String password, String name, Date regDate, List<Bookmark> bookmarks) {
	
		this.memNum = memNum;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
		this.bookmarks = bookmarks;
	}

	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [memNum=" + memNum + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", bookmarks=" + bookmarks + "]";
	}
	
	
	
	
}
