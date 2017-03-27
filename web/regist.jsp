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
  <script>
  function fun(){
  document.getElementById("img").src="/checkcodeServlet?date="+new Date();
  }
  
  </script>
  
  <body>
  <div class="fm-header">
		<div class="fm-header-nav"><a href="/index.jsp">首页</a></div>
		<div class="fm-header-login"><a href="/login.jsp">登录</a></div>
		<div class="fm-header-regist"><a href="/regist.jsp">注册</a></div>
		<div class="fm-header-welcome">welcome ${sessionScope.user.username }<a href="/logout">退出登陆</a></div>
	</div>

<form action="/registServlet"   method ="post"  >
		<div id="fm-reg-content" class="fm-reg-content">
			<div class="fm-reg-register">
				<center><p>注册</p></center>
				<span class="reg-username">用户名:<input type="text"   name="username"  id="fm-reg-user" placeholder="请输入用户名"></span>
				<br/>
				<span><font color="red">${requestScope.errors.username }</font></span>
				<span class="reg-password1">密&nbsp&nbsp码:<input type="password"  name="password"  id="fm-reg-pasw1" placeholder="请输入密码"></span>
				<br/>
				<span><font color="red">${requestScope.errors.password}</font></span>
                <span>验证码:<input type="text" name="checkcode"   placeholder="请输入验证码"/><img id= "img" alt="checkcode" src="/checkcodeServlet"><a href="javascript:void(0)" onclick="fun()">看不清，换一张</a><br/><font color="red">${requestScope.check }</font></span>
              <span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"   value="注册" /></span>
			</div>
			<div class="user-exists"><font color="red">${requestScope.exception }</font></div> 
		</div>
		
 </form>

 




  </body>
</html>
