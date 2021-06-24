package com.travel.proj.bookmark;

import com.querydsl.core.annotations.QueryProjection;

public class ListVo {
	
//	private Long id;
	private String contentid;
	private Long quantity;

	
	
	@QueryProjection
	public ListVo(String contentid, Long quantity) {
		
		//this.id = id;
		this.contentid = contentid;
		this.quantity = quantity;
	}



	public String getContentid() {
		return contentid;
	}



	public void setContentid(String contentid) {
		this.contentid = contentid;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
