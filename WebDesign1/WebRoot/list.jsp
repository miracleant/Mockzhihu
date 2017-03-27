<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<h1>welcome ${sessionScope.user.username }<a href="/logout">退出登陆</a></h1>
<hr/>
<table border="1">
<tr>
<th>id</th>
<th>用户名</th>
<th>密码</th>
</tr>
<c:forEach items="${requestScope.list}" var="demo">
<tr>
<td>${demo.id }</td>
<td>${demo.username }</td>
<td>${demo.password }</td>
</tr>
</c:forEach>
</table>
  </body>
</html>
