package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.paging.model.PageVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class MemberPagingController
 */
@WebServlet("/memberPagingList")
public class MemberPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(MemberPagingController.class);

	private IMemberService memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> resultMap = memberService.memberPagingList(pageVo);
		
		List<MemberVo> memberPagingList = (List<MemberVo>) resultMap.get("memberList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("memberPagingList", memberPagingList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/member/memberPagingList.jsp").forward(request, response);
		
	}

}
