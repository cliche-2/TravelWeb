package com.travel.proj.member;

import java.util.Date;

public class MemberVo {

	private int memNum;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	
	
	public MemberVo(int memNum, String email, String password, String name, Date regDate) {
		
		this.memNum = memNum;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
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



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
	
	
}
