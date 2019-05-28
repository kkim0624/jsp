package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.paging.model.PageVo;

public class LprodServiceImpl implements ILprodService {

	private ILprodDao dao;
	
	public LprodServiceImpl(){
		dao = new LprodDaoImpl();
	}
	
	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", dao.lprodPagingList(pageVo)); ////////////////////////////////////// ????????????
			
		int lprodCnt = dao.lprodCnt();
		
		int paginationSize = (int)Math.ceil( (double)Math.ceil((double)lprodCnt/pageVo.getPageSize()) );
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

}
