package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class MemberDaoImpl implements IMemberDao {
	
	/**
	 * 
	* Method : memberPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 회원 페이징 리스트 조회
	 */
	@Override
	public List<MemberVo> memberPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<MemberVo> memberList = sqlSession.selectList("member.memberPagingList",pageVo);
		sqlSession.close();
		return memberList;
	}

	@Override
	public int memberCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int memberCnt = (Integer) sqlSession.selectOne("member.memberCnt");
		sqlSession.close();
		return memberCnt;
	}

}
