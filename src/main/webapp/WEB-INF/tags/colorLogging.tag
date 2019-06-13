<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%-- <%@ attribute name="size" type="java.lang.Integer" required="true"%> --%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<font color="${color}">
<!-- 	============================================== -->
	<c:if test="${size==null}">
		<c:set value="5" var="size"></c:set>
	</c:if>

	<c:forEach begin="1" end="${size}">=</c:forEach> 

<%-- 	<c:forEach begin="1" end="${size == null ? 5 : size}"></c:forEach> --%>
</font>

