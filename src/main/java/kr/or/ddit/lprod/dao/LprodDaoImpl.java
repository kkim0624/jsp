package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class LprodDaoImpl implements ILprodDao {
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 상품대분류 페이징 리스트 조회
	 */
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodPagingList",pageVo);
		sqlSession.close();
		return lprodList;
	}
	
	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 상품대분류 전체 조회
	 */
	@Override
	public int lprodCnt() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodCnt = (Integer) sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		return lprodCnt;
	}

}
