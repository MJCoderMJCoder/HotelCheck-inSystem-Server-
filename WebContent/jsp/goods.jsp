<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/goods.css">
<title>服务管理</title>
</head>
<body>
	<div class="left">
		<div class="content">
			<h3 class="small"></h3>
			<h3 class="small">名称</h3>
			<h3 class="small">价格</h3>
			<h3 class="small">操作</h3>
		</div>
		<c:forEach items="${goods}" var="good" varStatus="id">
			<div class="content">
				<span class="small"><i>${good.id }</i></span> <span class="small">${good.name }</span>
				<span class="small"><input id="price" class="value"
					type="number" name="price" value="${good.price }" step="0.01"
					min="0" required></span> <span class="small"><input
					class="modify" type="button" value="修改"><input
					class="delete" type="button" value="删除"></span>
			</div>
		</c:forEach>
	</div>
	<div class="right">
		<br />
		<div>酒店提供的额外服务</div>
		<form action="${pageContext.request.contextPath}/goods/insert"
			method="post">
			<div>
				<span>名称：</span><input class="value" type="text" name="name"
					value="${name }" placeholder="SPA" required />
			</div>
			<div>
				<span>价格：</span><input class="value" type="number" name="price"
					value="${price }" placeholder="99.99" step="0.01" min="0" required>
			</div>
			<div>
				<input id="add" type="submit" value="添加">
			</div>
			<p style="color: red;">${errorMsg }</p>
		</form>
	</div>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/goods.js"></script>
</body>
</html>