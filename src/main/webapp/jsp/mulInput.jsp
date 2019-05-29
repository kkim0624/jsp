<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/mulCalculation" method="post"> <!-- 이줄 아예 누락 -->
		param1<input type="text" name="param1"><br>
		param2<input type="text" name="param2"><br>
			  <input type="submit" value="전송"><br>
	</form>
</body>
</html>