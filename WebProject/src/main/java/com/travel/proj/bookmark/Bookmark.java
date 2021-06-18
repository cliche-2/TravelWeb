package com.travel.proj.bookmark;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.travel.proj.member.Member;

@Entity
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	@SequenceGenerator(name = "book_sequence", sequenceName = "seq_book", allocationSize=1)
	private int bookNum;
	// (Member num , contentid)
	@ManyToOne
	@JoinColumn(name = "memNum")
	private Member member;
	private String contentid;
	private String title;			// 관광지명
	private String firstimage; 		// 이미지 주소
	// 추천시스템을 위한 필드
	private String contentTypeId;	// 관광타입
	private String sigungucode;		// 시군구코드: 지역

	
	public Bookmark(){};
	
	
	public Bookmark(int bookNum, Member member, String contentid, String title, String firstimage, String contentTypeId,
			String sigungucode) {

		this.bookNum = bookNum;
		this.member = member;
		this.contentid = contentid;
		this.title = title;
		this.firstimage = firstimage;
		this.contentTypeId = contentTypeId;
		this.sigungucode = sigungucode;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
		return "Bookmark [bookNum=" + bookNum + ", member=" + member + ", contentid=" + contentid + ", contentTypeId="
				+ contentTypeId + ", sigungucode=" + sigungucode + "]";
	}
	
	
	
}
