<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- application( servletContext() : requestMap ) -->
	
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
			<th>
				<c:forEach items="${map}" var="m">
					${requestMap}				
				</c:forEach>
			</th>
		</tr>
		
	</table>

</body>
</html>