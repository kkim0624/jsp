package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* mulCalculation.java
*
* @author PC04
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC04 최초 생성
*
* </pre>
*/
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(mulCalculation.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/**/int param1 = Integer.parseInt(request.getParameter("param1")); // getParameter 생각안남
	/**/int param2 = Integer.parseInt(request.getParameter("param2")); 
		
		int result = param1 * param2;
		
		logger.debug("result : {}  ", result);
		
	/**/request.getSession().setAttribute("mulResult", result);
	/**/request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response); // getRequestDispatcher 인데 getDispatcherType으로 찾음
														//.forward(request, response); 안해줌
	}

}
