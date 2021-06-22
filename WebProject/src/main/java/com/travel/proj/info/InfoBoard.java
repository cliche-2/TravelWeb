package com.travel.proj.info;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(updatable = false)
	private Date infoDate;
	
	public InfoBoard() {
		
	};
	public InfoBoard(int infoNum, int viewCount, String infoTitle, String infoContent, Date infoDate) {
		
		this.infoNum = infoNum;
		this.viewCount = viewCount;
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
		this.infoDate = infoDate;
	}
	public int getInfoNum() {
		return infoNum;
	}
	public void setInfoNum(int infoNum) {
		this.infoNum = infoNum;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public Date getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(Date infoDate) {
		this.infoDate = infoDate;
	}
	@Override
	public String toString() {
		return "InfoBoard [infoNum=" + infoNum + ", viewCount=" + viewCount + ", infoTitle=" + infoTitle
				+ ", infoContent=" + infoContent + ", infoDate=" + infoDate + "]";
	};
	

	
	
}
