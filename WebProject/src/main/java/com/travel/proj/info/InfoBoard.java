package com.travel.proj.info;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InfoBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_sequence")
	@SequenceGenerator(name = "info_sequence", sequenceName = "info_board", allocationSize=1)
	private int boardNum;
	private int viewCount;
	
}
