package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVo;

/**
 * Servlet implementation class LprodPagingController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingController.class);
	
	private static final long serialVersionUID = 1L;
       
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page, pageSize 파라미터 받기 
		// page, pageSize 파라미터가 없을경우 page=1, pageSize = 10 기본값설정
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);
		
		// page, pageSize 파라미터를 이용 하여 pageVo 작성
		PageVo pageVo = new PageVo(page, pageSize);
		
		logger.debug("pageVo : {}", pageVo);
		
		// pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		
		logger.debug("resultMap : {}", resultMap);
		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		// request scope에서 사용자 리스트를 공유할 수 있도록 속성 설정
		request.setAttribute("lprodPagingList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);

	}

}
