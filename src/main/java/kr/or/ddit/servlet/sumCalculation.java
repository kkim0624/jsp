package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(sumCalculation.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int start = Integer.parseInt(request.getParameter("start")); 
		int end = Integer.parseInt(request.getParameter("end"));
		
		int result = 0;
		for (int i = start; i <= end; i++) {
			result += i;
		}
		
		logger.debug("result : {}" , result);
		
		request.getSession().setAttribute("sumResult", result);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);

	}
}