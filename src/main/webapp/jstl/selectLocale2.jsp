<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	$("#locale").val("${locale}")
	$("#locale").on("change", function(){ // on 빼먹음
		$("#frm").submit();
	});
	
});
</script>

</head>
<body>
	
	<form id="frm" action="${pageContext.request.contextPath}/selectLocale2" method="post">
		<select id="locale" name="locale">
				<option value="ko">한국어</option>
				<option value="en">english</option>
				<option value="ja">日本言</option>
		</select>
	</form>
	
	<fmt:setLocale value="${locale}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/><br>
		<fmt:message key="VISITOR">
			<fmt:param value="brown"/><br>
		</fmt:message>
	</fmt:bundle>

</body>
</html>