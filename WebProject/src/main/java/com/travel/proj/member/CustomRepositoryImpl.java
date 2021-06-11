package com.travel.proj.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.travel.proj.bookmark.Bookmark;
import static com.travel.proj.member.QMember.member;


public class CustomRepositoryImpl implements CustomRepository{
//	
//	public CustomRepositoryImpl() {
//		super(Member.class);
//	}
//	
	
	private final JPAQueryFactory queryFactory;
	public CustomRepositoryImpl(JPAQueryFactory queryFactory) {
		super();
		this.queryFactory = queryFactory;
	}

	@Override
	public int findMemNumByEmail(String email) {
		int memNum= 0;
		
		QueryResults<Integer> queryResult = queryFactory
				.select(member.memNum)
				.from(member)
				.where(
						member.email.eq(email)
						)
				.fetchResults();
		
		
		if (! (queryResult.getResults().isEmpty()) )
			memNum=queryResult.getResults().get(0); 
		
		// 쿼리결과는 수정불가능한 List객체이므로 
		// 결과 자체를 리턴하지 않고 
		// 처리를 여기서 해서 memNum만 넘겨주기로 함
		return memNum;
	}

	@Override
	public ArrayList<Bookmark> findBookmarksBymemNum(int memNum) {
		return null;
	}

}
