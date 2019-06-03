package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	
	private IUserService userService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
	}
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Test
	public void userListTest(){
		/***Given***/
		/***When***/
		List<UserVo> userList = userService.userList();
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		
	}
	
	/**
	 * 
	* Method : test
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 :
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		
		String userId = "brown";
		/***When***/
		UserVo userVo = userService.getUser(userId);
		/***Then***/
//		assertEquals("brown", userVo.getUserId());
		assertNotNull(userVo);
	}
	
	// 사용자 전체리스트를 조회하는 메소드
	// 1. 메소드 인자가 필요한가? : 별다른 인자는 불필요 X
	// 2. 리턴 타입은 뭐가 될까? List<UserVo>
	// 3. 메소드 이름은 뭐가 적당하지?? : userList
	
//	@Test
//	public void userListTest2(){
//		/***Given***/
//		IUserService userService = new UserServiceImpl();
//		/***When***/
//		List<UserVo> userList = userService.userList();
//		/***Then***/
//		assertNotNull(userList);
//		assertEquals(105, userList.size());
//	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);
		
		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		// pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		// usersCnt assert
		assertEquals(11, paginationSize);
	}
	
	@Test 
	public void ceilTest(){
		/***Given***/
		int userCnt = 105;
		int pageSize = 10;
		/***When***/
		double paginationSize = Math.ceil((double)userCnt/pageSize);
		logger.debug("paginationSize : {}" , paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC04
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() {
		/***Given***/
		// 사용자 정보를 담고 있는 vo객체 준비
		
//		public UserVo(String name, String userId, String alias, String pass,
//		String addr1, String addr2, String zipcd, Date birth) {
//}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		
		try {
			userVo = new UserVo("김경호", "kkh", "kkang", "kkh123", "궁동", "빌라", "1234", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
//		userDao.insertUser();
		int insertCnt = userService.insertUser(userVo);
		
		/***Then***/
//		insertCnt(1);
		assertEquals(1, insertCnt);
				
		// data 삭제
		userService.deleteUser(userVo.getUserId());
		
	}
	
	@Test
	public void updateUserTest(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		
		try {
			userVo = new UserVo("김경호", "bumwhi", "kkang", "kkh123", "궁동", "빌라", "1234", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
//		userDao.insertUser();
		int insertCnt = userService.updateDataUser(userVo);
		
		/***Then***/
//		insertCnt(1);
		assertEquals(1, insertCnt);

	}
	
	
}
