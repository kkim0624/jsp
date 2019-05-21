<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public long factorial(int num){ 
	
	long result = 0;
	if(num==1){
		result =1;
	}else{
		result = num * factorial(num-1);
	}
	return result;
	}
%>
	1! : <%= factorial(1) %> <br>
	2! : <%= factorial(2) %> <br>
	3! : <%= factorial(3) %> <br>
	4! : <%= factorial(4) %> <br>
	5! : <%= factorial(5) %> <br>
	6! : <%= factorial(6) %> <br>
	7! : <%= factorial(7) %> <br>
	8! : <%= factorial(8) %> <br>
</body>
</html>