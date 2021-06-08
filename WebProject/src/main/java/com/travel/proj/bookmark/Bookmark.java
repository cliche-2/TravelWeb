package com.travel.proj.bookmark;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	@SequenceGenerator(name = "book_sequence", sequenceName = "seq_book", allocationSize=1)
	private int bookNum;
	// (Member num , contentid)
	private int memNum;
	private String contentid;
	
	// 추천시스템을 위한 필드
	private String contentTypeId;	// 관광타입
	private String sigungucode;		// 시군구코드: 지역

	
	public Bookmark(){};
	public Bookmark(int bookNum, int memNum, String contentid, String contentTypeId, String sigungucode) {

		this.bookNum = bookNum;
		this.memNum = memNum;
		this.contentid = contentid;
		this.contentTypeId = contentTypeId;
		this.sigungucode = sigungucode;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(String contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public String getSigungucode() {
		return sigungucode;
	}
	public void setSigungucode(String sigungucode) {
		this.sigungucode = sigungucode;
	}
	@Override
	public String toString() {
		return "Bookmark [bookNum=" + bookNum + ", memNum=" + memNum + ", contentid=" + contentid + ", contentTypeId="
				+ contentTypeId + ", sigungucode=" + sigungucode + "]";
	}
	
	
	
}
