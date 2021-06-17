package com.travel.proj.info;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoBoardService {
	
	@Autowired
	private InfoRepository rep;
	
	// 공지 작성
	public InfoBoard add(InfoBoard infoBoard) {
		Date date = new Date();
		infoBoard.setInfoDate(date);
		return rep.save(infoBoard);
	}
	
	// 공지 수정
	public void edit(InfoBoard infoBoard) {
		rep.save(infoBoard);
	}
	
	// 공지 삭제
	public void delete(int infoNum) {
		rep.deleteById(infoNum);
	}
	
	// 공지 목록 조회
	public ArrayList<InfoBoard> getAll(){
		return (ArrayList<InfoBoard>)rep.findAll();
	}
	
	// 공지 글 하나 조회 (조회수 ^)
	public InfoBoard getInfoBoardByNum(int num) {
		InfoBoard infoBoard =rep.findById(num).orElse(null);
		
		if(infoBoard != null) {
			infoBoard.setViewCount(infoBoard.getViewCount()+1);
			rep.save(infoBoard);
		}
		return infoBoard;
	}
	

}
