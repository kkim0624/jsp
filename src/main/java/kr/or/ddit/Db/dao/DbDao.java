package kr.or.ddit.Db.dao;

import java.util.List;

import kr.or.ddit.Db.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class DbDao implements IDbDao {

	@Override
	public List<DbVo> dbList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVo> dbList = sqlSession.selectList("db.dbList");
		sqlSession.close();
		return dbList;
	}

}
