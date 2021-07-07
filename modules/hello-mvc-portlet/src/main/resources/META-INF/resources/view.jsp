<%@ taglib prefix="porlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<p>
	<b>测试我的Ajax操作</b><br><br>
	<button type="button" id="testBtn">Ajax测试</button><br>
	<div id="div1"></div>
</p>

<p>
	<b>测试我的表单提交</b><br/>
	<form action ="">
		
	</form>
</p>

<portlet:resourceURL var="ajaxUrl" id="addOper" />
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