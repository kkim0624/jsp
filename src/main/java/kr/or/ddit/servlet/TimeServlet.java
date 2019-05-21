package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeServlet extends HttpServlet {
	
	// kr.or.ddit.servlet.timeServlet
	private Logger logger = LoggerFactory.getLogger(TimeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	resp.setContentType("text/html; charset=utf-8");
	PrintWriter pw = resp.getWriter();
	
	// localhost/jsp/timesTables?param=6
	String param = req.getParameter("i");
//	System.out.println("param : "+ param);
	
	// trace / debug / info / warn / error
	logger.debug("param {}: " + param, "test");
	
	String param1 = req.getParameter("j");
//	System.out.println("param1 : " + param1);
	
	// trace / debug / info / warn / error
	logger.debug("param {} : " + param1);
	
	pw.write("<html>");
	pw.write("<head>");
	pw.write("<title>TimeServlet</title>");
	pw.write("</head>");
	pw.write("<table border='1'>");
			
		
	for (int j = 1; j < Integer.parseInt(param1)+1; j++) {
		pw.write("<tr>");
				
		for (int i = 2; i < Integer.parseInt(param)+1; i++) {
			
			pw.write("<td>"+i + "*" +j + "=" + (i*j)+"</td>");
		}
		
		pw.write("</tr>");
	}
	
	pw.write("</table>");
	
	pw.write("</head>");
	
	}

}
