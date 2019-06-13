<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" required="true"%>
code : ${code}<br>

<%
	String code = (String)jspContext.getAttribute("code");
		
	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final String user = "pc04";
	final String pass = "java";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		pstmt = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu = 'P201'");
		pstmt.setString(1, code);
		
		rs = pstmt.executeQuery();
		
		out.write("<select>");
		while(rs.next())
			out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		out.write("<select>");
		
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<select>
	<option>${lprod}</option>
</select>