<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>湖北民族学院教务系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/weui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/jquery-weui.min.css">
</head>
<body>
	<div class="weui-tab">
		<div class="weui-tab__bd">
			<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active"></div>
			<div id="tab2" class="weui-tab__bd-item"></div>
		</div>

		<div class="weui-tabbar">
			<a href="" class="weui-tabbar__item weui-bar__item--on" id="school">
				<div class="weui-tabbar__icon">
					<img src="${pageContext.request.contextPath }/img/me.png" alt="">
				</div>
				<p class="weui-tabbar__label">微信</p>
			</a> <a href="" class="weui-tabbar__item" id="attention">
				<div class="weui-tabbar__icon">
					<img src="${pageContext.request.contextPath }/img/me.png" alt="">
				</div>
				<p class="weui-tabbar__label">消息</p>
			</a>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-weui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#tab1").load("${pageContext.request.contextPath }/page/admin/index.jsp");
	});
	$("#school").click(function(){
		$("#school").attr("href","#tab1");
		$("#tab1").load("${pageContext.request.contextPath }/page/admin/index.jsp");
	});
	$("#attention").click(function(){
		$("#attention").attr("href","#tab2");
		$("#tab2").load("${pageContext.request.contextPath }/page/admin/news.jsp");
	});
</script>
</html>
