<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- localhost/jsp/jsp/timesTables.jsp -->
<!-- 9*9단 출력 (2~9단) -->
	
	
	<c:set var="param1" value="${param.param1}" />
	<c:set var="param2" value="${param.param2}" />
	
	<c:if test="${param.parma1==null && param.param2==null}">
		<c:set var="param1" value="9" />
		<c:set var="param2" value="9" />
	</c:if>
			
	<table border=1>
		
				
		<c:forEach begin="1" end="${param2}" step="1" var="i">
			<tr>		
				<c:forEach begin="2" end="${param1}" step="1" var="j">
					<td>
						${j} * ${i} = ${i*j}
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

