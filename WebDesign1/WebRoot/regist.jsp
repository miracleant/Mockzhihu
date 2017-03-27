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
  <script>
  function fun(){
  document.getElementById("img").src="/checkcodeServlet?date="+new Date();
  }
  
  </script>
  
  <body>
  <h1>用户注册界面</h1>
  <form action="/registServlet"   method ="post"  >
  用户名:<input type="text"   name="username" /><font color="red">${requestScope.errors.username }</font><br/>
  &nbsp;密码:<input type="password"   name="password" /><font color="red">${requestScope.errors.password }</font><br/>
  验证码:<input type="text" name="checkcode"/><img id= "img" alt="checkcode" src="/checkcodeServlet"><a href="javascript:void(0)" onclick="fun()">看不清，换一张</a><br/><font color="red">${requestScope.check }</font><br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"   value="注册" />
  </form>
<font color="red">${requestScope.exception }</font>
  </body>
</html>
