<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// sendRedirect 메소드 인자 값을 웹브라우저가 수신한후에
		// 주소줄에 그대로 붙여넣음
		System.out.println("userId parameter : " + request.getParameter("userId"));
		response.sendRedirect(request.getContextPath()+"/jsp/redirectTarget.jsp?userId=brown");
		// /jsp/jsp/redirectTarget.jsp
	%>
	
	<%-- 
		1. http://localhost/jsp/jsp/redirectStart.jsp 접속
		1-1.  redirect 버튼 클릭 (jsp/jsp/redirectProcess.jsp) : 최초 요청
		
		2. redirectProcess.jsp가 최초요청을 수신
		2-1. response.sendRedirect("/jsp/jsp/redirectTarget.jsp") : 클라이언트에게 리다이렉트 지시
		
		3. 웹브라우저가 리다이렉트 응답을 받고, 수신한 리다이렉트 주소
		("jsp/jsp/redirectTarget/jsp")를 웹브루우저 주소줄에 입력하여 두번째 요청을 보낸다.
	--%>
	
</body>
</html>