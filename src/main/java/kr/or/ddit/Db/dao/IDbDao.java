package kr.or.ddit.Db.dao;

import java.util.List;

import kr.or.ddit.Db.model.DbVo;

public interface IDbDao {
	
	/**
	 * 
	* Method : dbList
	* 작성자 : PC04
	* 변경이력 :
	* @return
	* Method 설명 : db 리스트 전체 조회
	 */
	List<DbVo> dbList();
	
}
