package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

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
	
}
