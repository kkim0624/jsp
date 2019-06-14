<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%> //틀린 경로 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="/common/basicLib.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#locale").val("${locale}");
		$("#locale").on("change", function(){
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
	
	<h2>selectLocale</h2>
	
	<form id="frm" action="${cp}/selectLocale" method="post">
		<select id="locale" name="locale">
<%-- 		<option value="ko" <c:if test="${locale=='ko'}">selected</c:if>>한국어</option> --%>
<%-- 		<option value="en" <c:if test="${locale=='en'}">selected</c:if>>english</option> --%>
<%-- 		<option value="ja" <c:if test="${locale=='ja'}">selected</c:if>>日本言</option> --%>
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