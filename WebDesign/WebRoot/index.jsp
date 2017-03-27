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

	<link rel="stylesheet" type="text/css" href="../../web/css/styles.css">

    <!-- 
     <script type="text/javascript" src="script.js"></script>
        -->
  </head>

  
 
  
  <body>
  <div class="fm-header">
		<div class="fm-header-logo">form</div>
		<div class="fm-header-nav"><a href="/index.jsp">首页</a></div>
			<div class="fm-header-login"><a href="/login.jsp">登录</a></div>
		<div class="fm-header-regist"><a href="/regist.jsp">注册</a></div>
		<div class="fm-header-welcome">welcome ${sessionScope.user.username }<a href="/logout">退出登陆</a></div>
	</div>
	<div class="footer">
		<p  style="text-align:center;font-size:1.2em;margin:1em;">期待我们的更多精彩</p>
		<p style="text-align:center;">版权所有&copy form</p> 
	</div>

  </body>
</html>
