<%@ include file="/init.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p class="caption">
	<liferay-ui:message key="war-mvc-portlet.caption" /> <br/>
	<c:out value="${helloWorldMessage}"></c:out>
</p>