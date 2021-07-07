<%@ taglib prefix="porlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%--Ajax提交url地址 --%>
<portlet:resourceURL var="ajaxUrl" id="addOper" />
<p>
	<b>测试我的Ajax操作</b><br/><br/>
	<button type="button" id="testBtn">Ajax测试</button><br/>
	<div id="div1"></div>
</p>

<%--表单提交url地址--%>
<portlet:actionURL var = "loginURL" name = "loginAction" />
<p>
	<b>登录表单提交</b><br/>
	<form action ="${loginURL}" method ="post">
		用户名：<input type ="text" name ="<portlet:namespace/>username" /><br/>
		密码：<input type = "password" name ="<portlet:namespace/>password" /><br/>
		<input type ="submit" value ="提交" />
	</form>
</p>


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