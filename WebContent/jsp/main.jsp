<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
<title>酒店自助入住系统-PC桌面端</title>
</head>
<body>
	<div class="top">${user.memo }：${user.name }</div>
	<hr />
	<ul>
		<li><a class="active"
			href="${pageContext.request.contextPath}/room/select" target="iframe">房间管理</a></li>
		<li><a href="${pageContext.request.contextPath}/goods/select"
			target="iframe">服务管理</a></li>
		<li><a href="${pageContext.request.contextPath}/userType/select"
			target="iframe">类型管理</a></li>
		<li><a
			href="${pageContext.request.contextPath}/controller/selectStaff"
			target="iframe">员工管理</a></li>
		<li><a
			href="${pageContext.request.contextPath}/controller/selectUser"
			target="iframe">用户管理</a></li>
		<li><a href="${pageContext.request.contextPath}/fee/select"
			target="iframe">收费信息</a></li>
		<li><a href="${pageContext.request.contextPath}/jsp/checkin.jsp"
			target="iframe">登记入住 </a></li>
	</ul>
	<iframe id="iframe" name="iframe"
		src="${pageContext.request.contextPath}/room/select" seamless>
		<p>抱歉；您的浏览器不支持。</p>
	</iframe>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/main.js"></script>
</body>
</html>