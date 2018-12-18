<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
<title>酒店自助入住系统-PC桌面端</title>
</head>
<body>
	<br />
	<div class="title">
		<h1>酒店自助入住系统</h1>
		<h2>PC桌面端</h2>
	</div>
	<br />
	<div class="form">
		<form action="${pageContext.request.contextPath}/controller/login"
			method="post">
			<div>
				<span>身份证号：</span><input class="value" type="text" name="identity"
					value="${identity }" />
			</div>
			<br />
			<div>
				<span>密码：</span><input class="value" type="password" name="password"
					value="${password }" /><br />
			</div>
			<br /> <input id="login" type="submit" value="登录"> <br />
			<p style="color: red;">${errorMsg }</p>
		</form>
	</div>
</body>
</html>