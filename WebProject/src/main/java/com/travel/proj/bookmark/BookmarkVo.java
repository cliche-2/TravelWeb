package com.travel.proj.bookmark;

public class BookmarkVo {

	private int bookNum;
	private String contentid;
	private String title;
	private String firstimage;
	private String contentTypeId;
	private String sigungucode;
	

	public BookmarkVo() {};
	
	public BookmarkVo(int bookNum, String contentid, String title, String firstimage, String contentTypeId, String sigungucode) {
		this.bookNum = bookNum;
		this.contentid = contentid;
		this.title = title;
		this.firstimage = firstimage;
		this.contentTypeId = contentTypeId;
		this.sigungucode = sigungucode;
	}
	
	

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
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
	
	
	
	
	
}
