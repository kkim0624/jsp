package kr.or.ddit.Db.service;

import java.util.List;

import kr.or.ddit.Db.dao.DbDao;
import kr.or.ddit.Db.dao.IDbDao;
import kr.or.ddit.Db.model.DbVo;

public class DbService implements IDbService {

	private IDbDao dao;
	
	public DbService() {
		dao = new DbDao();
	}
	
	@Override
	public List<DbVo> dbList() {
		return dao.dbList();
	}

}
