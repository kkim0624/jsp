<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation2" method="post">
	param1 <input type="text" name="start"><br>
	param2 <input type="text" name="end"><br>
		   <input type="submit" value="전송">
	</form>
</body>
</html>