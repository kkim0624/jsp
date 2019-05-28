package kr.or.ddit.lprod.service;

import java.util.Map;

import kr.or.ddit.paging.model.PageVo;

public interface ILprodService {
	
	public Map<String, Object> lprodPagingList(PageVo pageVo);
}
