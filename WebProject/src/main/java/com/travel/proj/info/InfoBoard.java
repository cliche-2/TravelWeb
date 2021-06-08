package com.travel.proj.info;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class InfoBoard {
	// normal board
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_sequence")
	@SequenceGenerator(name = "info_sequence", sequenceName = "seq_info", allocationSize=1)
	private int boardNum;
	private int viewCount;
	
}
