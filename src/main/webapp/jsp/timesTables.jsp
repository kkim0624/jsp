<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- localhost/jsp/jsp/timesTables.jsp -->
<!-- 9*9단 출력 (2~9단) -->
	<table border=1>
		<%for(int j=1; j<=9; j++){%>
			<tr>		
			<% for(int i = 2; i <=9; i++ ){%>
			<td><%= i + "*" + j + "=" + (i*j) %></td>
			<%}%>
		<%}%>
		</tr>
	</table>

</body>
</html>