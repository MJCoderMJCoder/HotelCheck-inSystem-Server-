<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/fee.css">
<title>收费信息管理</title>
</head>
<body>
	<br />
	<div class="title">
		<h3 class="small"></h3>
		<h3 class="small">费用</h3>
		<h3 class="medium">物品描述</h3>
		<h3 class="small">交易时间</h3>
	</div>
	<c:forEach items="${fees}" var="fee" varStatus="id">
		<div class="content">
			<span class="small"><i>${fee.id }</i></span> <span class="small">${fee.fee }</span>
			<span class="medium">${fee.memo }</span> <span class="small">${fee.timestamp }</span>
		</div>
	</c:forEach>
	<p class="bottom">
		<span class="small">总计：</span><span class="small">${sum }</span>
	</p>
</body>
</html>