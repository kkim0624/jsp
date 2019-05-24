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
 * Servlet implementation class sumCalculation2
 */
@WebServlet("/sumCalculation2")
public class sumCalculation2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(sumCalculation2.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getContextPath()); /**/
		int end = Integer.parseInt(request.getContextPath()); /**/
		
		int result = 0;
		for (int i = start; i < end; i++) {
			result += i;
		}
		
		logger.debug("result : {}", result);
		
		request.getSession().setAttribute("sumResult2", result);
		request.getRequestDispatcher("/jsp/sumResult2.jsp").forward(request, response);
		
		
		
	}

}
