package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.paging.model.PageVo;

public interface IMemberDao {
	
	/**
	 * 
	* Method : memberPagingList
	* 작성자 : PC04
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 회원 페이징 리스트 조회
	 */
	List<MemberVo> memberPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : memberCnt
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : 회원 전체수 조회
	 */
	int memberCnt();
	
}
