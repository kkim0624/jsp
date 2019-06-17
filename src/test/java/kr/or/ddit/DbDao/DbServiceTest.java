package kr.or.ddit.DbDao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.Db.dao.DbDao;
import kr.or.ddit.Db.dao.IDbDao;
import kr.or.ddit.Db.model.DbVo;
import kr.or.ddit.Db.service.DbService;
import kr.or.ddit.Db.service.IDbService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoTest.class);
	
	private  IDbService dbService;
	
	@Before
	public void setup(){
		dbService = new DbService();
		logger.debug("setup");
	}
	
	@Test
	public void DbServieceTest() {
		
		/***Given***/
		
		/***When***/
		List<DbVo> dbList = dbService.dbList();
		/***Then***/
		assertNotNull(dbList);
		assertEquals(2, dbList.size());
		

	}

}
