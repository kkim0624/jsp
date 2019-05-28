package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(LprodServiceTest.class);
	
	private ILprodDao lprodDao;
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup(){
		lprodDao = new LprodDaoImpl();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 상품대분류 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodPagingList(pageVo);
		
		/***Then***/
		assertNotNull(lprodList);
		assertEquals(9, lprodList.size());
	}
}
