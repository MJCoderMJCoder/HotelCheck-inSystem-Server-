<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 声明必须位于 HTML5 文档中的第一行 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/checkin.css">
<title>身份证识别-登记入住</title>
</head>
<body>
	<br />
	<div class="title">
		<h3>身份证识别-登记入住</h3>
	</div>

	<form action="${pageContext.request.contextPath}/checkin/aipOcrIdCard"
		method="post" enctype="multipart/form-data">
		<span> <!-- 调用照相机，拍照 。
			capture表示，可以捕获到系统默认的设备，比如：camera–照相机；camcorder–摄像机；microphone–录音。multiple多种方式：能够支持选择图库或者拍照。
			accept表示，直接打开系统文件目录。图片：accept="image/*"；视频：accept="video/*"；录音：accept="audio/*"-->
			<input type="file" accept="image/*" capture="camera" name="file">
		</span> <span> <input type="submit" value="身份证识别-登记入住">
		</span>
		<p style="color: red;">${errorMsg }</p>
	</form>
	<c:if test="${rooms != null}">
		<div class="title">
			<h3 class="small"></h3>
			<h3 class="small">房间</h3>
			<h3 class="small">价格</h3>
			<h3 class="small">几人间</h3>
			<h3 class="small">状态</h3>
			<h3 class="small">用户</h3>
			<h3 class="medium">入住时间</h3>
			<h3 class="medium">类型</h3>
		</div>
	</c:if>
	<c:forEach items="${rooms}" var="room" varStatus="id">
		<div class="title">
			<span class="small">${room.id }</span> <span class="small">${room.name }</span>
			<span class="small">${room.price }</span> <span class="small">${room.fewHuman }</span>
			<c:if test="${room.status == 0}">
				<span class="small">空</span>
			</c:if>
			<c:if test="${room.status ==1  }">
				<span class="small">预订入住</span>
			</c:if>
			<c:if test="${room.status == 2}">
				<span class="small">暂停使用</span>
			</c:if>
			<span class="small">${user }</span> <span class="medium">${room.checkinTime }</span>
			<span class="medium">${room.type }</span>
		</div>
	</c:forEach>
</body>
</html>