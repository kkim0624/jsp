package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.paging.model.PageVo;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao dao;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public Map<String, Object> memberPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("memberList", dao.memberPagingList(pageVo));
		
		int memberCnt = dao.memberCnt();
		
		int paginationSize = (int)Math.ceil( (double)memberCnt / pageVo.getPageSize() );
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	
	
}
