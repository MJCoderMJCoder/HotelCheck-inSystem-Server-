<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/usertype.css">
<title>类型管理</title>
</head>
<body>
	<div class="left">
		<br />
		<form action="${pageContext.request.contextPath}/userType/insertUser"
			method="post">
			<div>
				<span>类型名称：</span><input class="value" type="text" name="memo"
					value="${memoUser }" placeholder="白金会员" required /> <input
					id="add" type="submit" value="添加"><span style="color: red;">${errorMsgUser }</span>
			</div>
		</form>
		<div>
			<h3>用户类型</h3>
		</div>
		<c:forEach items="${users}" var="user" varStatus="id">
			<div>${user.memo }</div>
		</c:forEach>
	</div>
	<div class="right">
		<br />
		<form action="${pageContext.request.contextPath}/userType/insertAdmin"
			method="post">
			<div>
				<span>岗位名称：</span><input class="value" type="text" name="memo"
					value="${memoAdmin }" placeholder="前台" required /> <input id="add"
					type="submit" value="添加"> <span style="color: red;">${errorMsgAdmin }</span>
			</div>
		</form>
		<div>
			<h3>员工岗位</h3>
		</div>
		<c:forEach items="${admins}" var="admin" varStatus="id">
			<div>${admin.memo }</div>
		</c:forEach>
	</div>
</body>
</html>