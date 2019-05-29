package kr.or.ddit.member.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVo;

public interface IMemberService {
	
	public Map<String, Object> memberPagingList(PageVo pageVo);
}
