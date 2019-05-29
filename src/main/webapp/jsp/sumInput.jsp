<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2> jsp calculation scope</h2>
	
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start <input type="text" name="start" value="startValue"><br>
		end <input type="text" name="end" value="endValue">
		<input type="submit" value="입력">
	</form>
	
</body>
</html>