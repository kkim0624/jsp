package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

public class UserServiceImpl implements IUserService{
	
	private IUserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

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
	
}
