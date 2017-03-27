<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <h1>用户登陆界面</h1>
  <form action="/loginServlet"   method ="post"  >
  用户名:<input type="text"   name="username"  value="${cookie.remember.value }"/><font color="red">${requestScope.errors.username }</font><br/>
  &nbsp;密码:<input type="password"   name="password" /><font color="red">${requestScope.errors.password }</font><br/>
  记住用户名:<input type="checkbox"  name="box"  value="yes"  ${cookie.remember==null?"":"checked=checked "}/><br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"   value="登陆" />
  </form>
<font color="red">${requestScope.exception }</font>
  </body>
</html>
