package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectLocaleController2
 */
@WebServlet("/selectLocale2")
public class selectLocaleController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jstl/selectLocale2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String locale = request.getParameter("locale");

		if(locale == null){
			locale = "kr";
		}
		
		// 삼향 연산자로
		
		request.setAttribute("locale", locale);
		request.getRequestDispatcher("/jstl/selectLocale2.jsp").forward(request, response);
		
	}

}
