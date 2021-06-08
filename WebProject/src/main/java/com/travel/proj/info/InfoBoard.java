package com.travel.proj.info;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InfoBoard {
	// 공지사항 일반게시판
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_sequence")
	@SequenceGenerator(name = "info_sequence", sequenceName = "seq_info", allocationSize=1)
	private int infoNum;
	private int viewCount;
	private String infoTitle;
	private String infoContent;
	private Date infoDate;
	
}
