package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

public class UserServiceImpl implements IUserService{
	
	private IUserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
			
	@Override
	public List<UserVo> userList() {
		return dao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		return dao.getUser(userId);
	}

	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		// 1. List<UserVo>, userCnt를 필드로 하는 vo
		// 2. List<Object> resultList = new ArrayLIst<Object>();
		//    resultList.add(userList);
		//    resultList.add(userCnt);
		// 3. Map<String, Object> resultMap = new HashMap<String, Object>();
		//    resutMap.put("userList",userList);
		//    resutMap.put("userCnt",userCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
		
		// usersCnt --> paginationSize 변경
//		resultMap.put("userCnt", dao.usersCnt());
		int usersCnt = dao.usersCnt();
		
		// pageSize --> pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVo userVo) {
		
		return dao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateDataUser(UserVo userVo) {
		return dao.updateDataUser(userVo);
	}
	
	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	* 			 : 재적용 하지 말것 !!!!!
	 */
	@Override
	public int encryptPassAllUser() {
		// 사용하지 마세요 !!! 이미 암호화 적용 되었습니다
		if(1 ==1)
			return 0;
		
		// 0. sql 실행에 필요한 sqlSessdion 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		// 1. 든 사용자 정보를 조회 (단, 기본 암호화 적용 사용자 제외, brown, userTest)
		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
		
		// 2. 조회된 사용자의 비밀번호를 암호화 적용후 사용자 업데이트
		int updateCntSum = 0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncryptPass(sqlSession,userVo);
			updateCntSum += updateCnt;
			
			// 비정상
			if(updateCnt != 1){
				sqlSession.rollback();
				break;
			}
		}
		// 3. sqlSesssion 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum;
	}
	
	public static void main(String[] args) {
		IUserService userService = new UserServiceImpl();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {} ", updateCnt);
	}
	
}
