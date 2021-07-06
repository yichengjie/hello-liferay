<%@ taglib prefix="porlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<p>
	<b><liferay-ui:message key="hellomvcporlet.caption"/></b>
	<button type="button" id="testBtn">测试Ajax</button><br>
	<div id="div1"></div>
</p>

<portlet:resourceURL var="ajaxUrl" id="rentalsUserListURL" />

<script type="text/javascript">
	$(function (){
		$("#testBtn").click(function(){
			doAjax() ;
		});
	}) ;

	function doAjax (){
		$.ajax({
			url: '${ajaxUrl}',
			method: "POST",
			data:{
				<portlet:namespace/>username: "yicj",
				<portlet:namespace/>password: "123"
			},
			success:function(result){
				$("#div1").html(result);
			}
		});
	}
</script>