/**
 * window.location.reload();//刷新当前页面.
 * parent.location.reload()刷新父亲对象（用于框架）--需在iframe框架内使用
 * opener.location.reload()刷新父窗口对象（用于单开窗口
 * 
 * top.location.reload()刷新最顶端对象（用于多开窗口）
 * 
 */
$(document).ready(
		function() {
			$(".modify").click(function() {
				var parent = $(this).parent().parent()
				$.post("../room/update", {
					id : parent.find("i").text(),
					price : parent.find("#price").val(),
					fewHuman : parent.find("#fewHuman").val(),
					status : parent.find("#status").val(),
					type : parent.find("#type").val(),
				}, function(data, status) {
					alert("数据: " + data + "\n状态: " + status);
				});
			});
			$(".delete").click(
					function() {
						var parent = $(this).parent().parent()
						$.get("../room/delete?id=" + parent.find("i").text(),
								function(data, status) {
									parent.remove();
									alert("数据: " + data + "\n状态: " + status)
								});
					});
		});