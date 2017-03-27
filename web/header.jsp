<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>form</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript">
		function pagechange(){
			self.location='register.jsp';
		}
	</script>
</head>
<body>
	<div class="fm-header">
		<%
			if(session.getAttribute("username")==null){
		%>
		<div class="fm-header-nav"><a href="/index.jsp">首页</a></div>
		<div class="fm-header-login"><a href="/login.jsp">登录</a></div>
		<div class="fm-header-regist"><a href="/regist.jsp">注册</a></div>
		<% }else{ %>
		<div class="fm-header-welcome">welcome ${sessionScope.user.username }<a href="/logout">退出登陆</a></div>
		<% } %>
	</div>

	<div class="fm-login" id="fm-login">
		<center><div class="fm-login-tilte">welcom login</div></center>
		<span onclick="loginclose()">关闭</span>
		<div class="fm-login-content">
			<div class="fm-login-input">
				<label for="userName">username: <input type="userName" name="userName" id="fm-login-user"></label>
			</div>
			<div class="fm-login-input">
				<label for="userPasw">password: <input type="userPasw" name="userPasw" id="fm-login-pasw"></label>
			</div>
		</div>
		<div class="fm-login-button">
			<button onclick="login_ajax()">登录</button><button onclick="pagechange()">注册</button>
		</div>
	</div>
	<div id="fm-hidden"></div>
