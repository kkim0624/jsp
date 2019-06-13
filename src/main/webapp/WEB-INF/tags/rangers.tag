<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="rangers" type="java.lang.String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select>
	<option>
		<c:forTokens items="${rangers}" delims="," var="i">
			${i}
		</c:forTokens>
	</option>
</select>
