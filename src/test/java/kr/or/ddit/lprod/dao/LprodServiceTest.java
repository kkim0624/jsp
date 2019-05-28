package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodServiceTest {
	
	private ILprodService lprodService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodServiceTest.class);
	
	@Before
	public void setup(){
		lprodService = new LprodServiceImpl();
	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,5);
		
		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<UserVo> lprodList = (List<UserVo>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		// pagingList assert
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
		
		// usersCnt assert
		assertEquals(2, paginationSize);
	}
	
}
