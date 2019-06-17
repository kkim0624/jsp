package kr.or.ddit.DbDao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.Db.dao.DbDao;
import kr.or.ddit.Db.dao.IDbDao;
import kr.or.ddit.Db.model.DbVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoTest.class);
	
	private IDbDao dbDao;
	
	@Before
	public void setup(){
		dbDao = new DbDao();
		logger.debug("setup");
	}
	
	@Test
	public void DbDoaTest() {
		
		/***Given***/
		
		/***When***/
		List<DbVo> dbList = dbDao.dbList();
		/***Then***/
		assertEquals(2, dbList.size());
		

	}

}
