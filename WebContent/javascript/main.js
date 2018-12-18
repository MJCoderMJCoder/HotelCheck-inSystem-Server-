/**
 * 
 */
$(document).ready(function() {
	// 菜单栏响应事件
	$("ul a").click(function() {
		$this = $(this);
		$("ul a").removeClass("active");
		$this.addClass("active");
	});
});