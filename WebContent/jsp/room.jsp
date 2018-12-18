<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/room.css">
<title>房间管理</title>
</head>
<body>
	<div class="top">
		<h3 class="small"></h3>
		<h3 class="small">房间</h3>
		<h3 class="small">价格</h3>
		<h3 class="small">几人间</h3>
		<h3 class="small">状态</h3>
		<h3 class="medium">用户</h3>
		<h3 class="medium">入住时间</h3>
		<h3 class="medium">退房时间</h3>
		<h3 class="medium">类型</h3>
		<h3 class="medium">操作</h3>
	</div>
	<c:forEach items="${rooms}" var="room" varStatus="id">
		<div class="content">
			<!-- ${id.index} -->
			<i class="small">${room.id }</i> <span class="small">${room.name }</span>
			<span class="small"><input id="price" class="value"
				type="number" name="price" value="${room.price }" step="0.01"
				min="0" required></span> <span class="small"><input
				id="fewHuman" class="value" type="number" name="fewHuman"
				value="${room.fewHuman }" step="1" min="1" required></span>
			<c:if test="${room.status == 0}">
				<span class="small"><select id="status" name="status">
						<option value="0" selected>空</option>
						<option value="1">预订入住</option>
						<option value="2">暂停使用</option>
				</select></span>
				<span class="medium">无</span>
				<span class="medium"></span>
				<span class="medium"></span>
			</c:if>
			<c:if test="${room.status ==1  }">
				<span class="small"><select id="status" name="status">
						<option value="0">空</option>
						<option value="1" selected>预订入住</option>
						<option value="2">暂停使用</option>
				</select></span>
				<span class="medium">${room.user.name }：${room.user.identity }</span>
				<span class="medium">${room.checkinTime }</span>
				<span class="medium">${room.checkoutTime }</span>
			</c:if>
			<c:if test="${room.status == 2}">
				<span class="small"><select id="status" name="status">
						<option value="0">空</option>
						<option value="1">预订入住</option>
						<option value="2" selected>暂停使用</option>
				</select></span>
				<span class="medium"></span>
				<span class="medium"></span>
				<span class="medium"></span>
			</c:if>
			<span class="medium"><input id="type" class="value"
				type="text" name="type" value="${room.type }" required></span> <span
				class="medium"><input class="modify" type="button" value="修改"><input
				class="delete" type="button" value="删除"></span>
		</div>
	</c:forEach>
	<br />
	<br />
	<hr />
	<div class="bottom">
		<div id="addForm">
			<form action="${pageContext.request.contextPath}/room/insert"
				method="post">
				<div>
					<span>房间：</span><input class="value" type="text" name="room"
						value="${room }" placeholder="101" required />
				</div>
				<div>
					<span>价格：</span><input class="value" type="number" name="price"
						value="${price }" placeholder="99.99" step="0.01" min="0" required>
				</div>
				<div>
					<span>几人间：</span><input class="value" type="number" name="fewHuman"
						value="${fewHuman }" placeholder="2" step="1" min="1" required>
				</div>
				<div>
					<span>类型：</span><input class="value" type="text" name="type"
						value="${type }" placeholder="单床房" required>
				</div>
				<div>
					<input id="add" type="submit" value="添加">
				</div>
				<p style="color: red;">${errorMsg }</p>
			</form>
		</div>
	</div>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/javascript/room.js"></script>
</body>
</html>