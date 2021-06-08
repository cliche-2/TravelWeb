package com.travel.proj.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_sequence")
	@SequenceGenerator(name = "mem_sequence", sequenceName = "seq_mem", allocationSize=1)
	private int memNum;
	private String email; 	// 로그인 시 사용할 아이디
	private String password; 
	private String name;	// 닉네임
	
	
	
}
