package com.travel.proj.bookmark;

import static com.travel.proj.bookmark.QBookmark.bookmark;

import java.util.List;

import org.hibernate.criterion.Projection;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;

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



	@Override
	public List<ListVo> countGroupByContentid() {
		// TODO Auto-generated method stub
		
		NumberPath<Long> aliasQuantity = Expressions.numberPath(Long.class, "quantity"); // +
		
		List<ListVo> queryResults = queryFactory
//				.select(bookmark.contentid, bookmark.contentid.count())
				.select(Projections.constructor(ListVo.class, bookmark.contentid, bookmark.count().as(aliasQuantity)))
				.from(bookmark)
				.groupBy(bookmark.contentid)
				.orderBy(aliasQuantity.desc()) // +
				.fetch();
		
	//	System.out.println("queryResults:"+queryResults);
	//	System.out.println("get 0::::::::"+queryResults.get(0).get(0,String.class));
	//	System.out.println("get 1::::::::"+queryResults.get(1));
	//	System.out.println("getResults:::"+queryResults.getResults()); // 됨
	//	System.out.println("get 0 ::::::: "+queryResults.getResults().get(0));
		
		
		return queryResults;
//		return null;
	}



	@Override
	public Bookmark findByContentid(String contentid) {
		// TODO Auto-generated method stub
		Bookmark queryResults = queryFactory
				.select(bookmark)
				.from(bookmark)
				.where(bookmark.contentid.eq(contentid))
				.fetchFirst();
		return queryResults;
	}
	
	

}
