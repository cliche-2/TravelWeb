package com.travel.proj.info;

public class TestApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApiExplorer apiex = new ApiExplorer();
		
		String result = (String)apiex.areaBasedList("jongno");
		
		System.out.println(result);
		

	}

}
