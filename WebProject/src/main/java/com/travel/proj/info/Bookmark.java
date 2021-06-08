package com.travel.proj.info;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	@SequenceGenerator(name = "book_sequence", sequenceName = "seq_book", allocationSize=1)
	private int bookNum;
	// Member와 InfoBoard를 참조함
	private int memNum;
	private int boardNum;
	
	
	
}
