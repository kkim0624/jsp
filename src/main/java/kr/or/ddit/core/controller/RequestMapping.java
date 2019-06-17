package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Db.model.DbVo;
import kr.or.ddit.Db.service.DbService;
import kr.or.ddit.Db.service.IDbService;
import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;

public class RequestMapping {

	// /main.do -> MainController
	// /userList.do -> UserListController
	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
//	private static Map<String, String> requestMappingClass;
	private static Map<String, Controller> requestMapping;
	
	private static IDbService dbservice = new DbService();
	
	static{
		
		List<DbVo> uriClassMappingList = dbservice.dbList();
		
		requestMapping = new HashMap<String, Controller>();
		
		for(DbVo dbVo : uriClassMappingList){
			// classInfo = "kr.or.ddit.controller.MainController"
			String classInfo = dbVo.getClassName();
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		logger.debug("requestMapping",requestMapping);
//		requestMapping.put("/main.do", new MainController
//		requestMapping.put("/userList.do", new UserListController());
	
	} // static 
	
	public static Controller getController(String uri) {
		logger.debug("getController : {} ", uri);
		return requestMapping.get(uri);
	}

}
