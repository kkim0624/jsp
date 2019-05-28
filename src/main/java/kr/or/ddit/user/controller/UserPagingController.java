package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserPagingController
 */
@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// page, pageSize 파라미터 받기
		// page, pageSize 파라미터가 없을경우 page=1, pageSize=10 기본값 설정
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
//		int page = 0; 
//		int pageSize = 0; 
//
//		if( request.getParameter("page") == null && request.getParameter("pageSize") == null){
//			
//			page = 1;
//			pageSize = 10;
//			
//		}else{
//			page = Integer.parseInt(request.getParameter("page")); 
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
//			
//		}
		
//		PageVo pageVo = new PageVo();
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);
		
		// page, pageSize 파라미터를 이용 하여 pageVo 작성
		PageVo pageVo = new PageVo(page,pageSize); 
		
		// pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		// request scope에서 사용자 리스트를 공유할 수 있도록 속성 설정ㄴ
		request.setAttribute("userPagingList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
//		request.setAttribute("userPagingList", userService.userPagingList(pageVo));
		
		// 화면 출력을 담당하는 jsp에게 역할 위임
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	
	}

}
