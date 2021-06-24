package com.travel.proj.bookmark;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.travel.proj.bookmark.QBookmark.bookmark;

public class CustomRepositoryImpl implements CustomRepository{
	
	private final JPAQueryFactory queryFactory;
	public CustomRepositoryImpl(JPAQueryFactory queryFactory) {
		super();
		this.queryFactory = queryFactory;
	}



	@Override
	public int findByContentidAndMember(String contentid, int member) {
		// TODO Auto-generated method stub
		
		int bookNum = 0;
		
		QueryResults<Integer> queryResults = queryFactory
				.select(bookmark.bookNum)
				.from(bookmark)
				// boolean expression
				.where(
						bookmark.contentid.eq(contentid),
						bookmark.member.memNum.eq(member)
						)
				.fetchResults();
		
		if( ! (queryResults.getResults().isEmpty()) )
			bookNum = queryResults.getResults().get(0);
				
		return bookNum;
	}
	
	

}
