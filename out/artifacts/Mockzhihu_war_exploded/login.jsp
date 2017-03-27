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

	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
  <body>
    <div class="fm-header">
		<div class="fm-header-nav"><a href="/index.jsp">首页</a></div>
			<div class="fm-header-login"><a href="/login.jsp">登录</a></div>
		<div class="fm-header-regist"><a href="/regist.jsp">注册</a></div>
		<div class="fm-header-welcome">welcome ${sessionScope.user.username }<a href="/logout">退出登陆</a></div>
	</div>




 <form action="/loginServlet"   method ="post"  >
 <div id="fm-reg-content" class="fm-reg-content">
<div class="fm-login-content">
			<div class="fm-login-input">
				<center><p>登陆</p></center>
				<label for="userName">用户名: <input type="userName" name="username" id="fm-login-user"   placeholder="请输入用户名" value="${cookie.remember.value }" ></label>
				<br/>
				<span><font color="red">${requestScope.errors.username }</font></span>
			</div>
			<div class="fm-login-input">
				<label for="userPasw">密&nbsp&nbsp码: <input type="password" name="password" id="fm-login-pasw" placeholder="请输入密码"></label>
				<br/>
				<span><font color="red">${requestScope.errors.password }</font></span>
			</div>
			<div>
			<span>记住用户名:<input type="checkbox"  name="box"  value="yes"  ${cookie.remember==null?"":"checked=checked "}/></span>
             <span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"   value="登陆" /></span>	
			</div>
			  <div>
				  <font color="red" >${requestScope.exception }</font>
			   </div>
		</div>
</div>
  </form>













  </body>
</html>
