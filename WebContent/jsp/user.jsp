<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user.css">
<title>用户管理</title>
</head>
<body>
	<br />
	<div class="title">
		<h3 class="small"></h3>
		<h3 class="small">姓名</h3>
		<h3 class="small">身份证号</h3>
		<h3 class="small">类型</h3>
		<h3 class="small">密码</h3>
		<h3 class="small">操作</h3>
	</div>
	<c:forEach items="${users}" var="user" varStatus="id">
		<div class="content">
			<span class="small"><i>${user.id }</i></span> <span class="small">${user.name }</span>
			<span class="small">${user.identity }</span> <span class="small">
				<select id="type" name="type">
					<c:forEach items="${userTypes}" var="userType" varStatus="id">
						<c:if test="${userType.id == user.type }">
							<option value="${userType.id }" selected>${userType.memo }</option>
						</c:if>
						<c:if test="${userType.id !=  user.type }">
							<option value="${userType.id }">${userType.memo }</option>
						</c:if>
					</c:forEach>
			</select>
			</span> <span class="small"><input id="password" type="password"
				value="${user.password }" name="password" required disabled></span>
			<span class="small"><input class="modify" type="button"
				value="修改"></span>
		</div>
	</c:forEach>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/user.js"></script>
</body>
</html>