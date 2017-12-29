<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<!-- 导入ztree类库 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var findUser = '${pageContext.request.contextPath }/menu/getAllMenu';
	$(document).ready(function(){
		 test();
	 });
	function test(data){
		$.ajax({
			url:findUser,
			data:data,
			success:function(data){
				var temp = data.data.menu.button;
				var html = "";
				for(var i = 0;i<temp.length;i++){
					html += "<tr>";
					html += "<td>"+temp[i].name+"</td>";
					html += "<td>"+temp[i].type+"</td>";
					html += "<td>"+temp[i].url+"</td>";
					html += "<td>"+"<a href='javascript:;' onclick='deleteMenu(this);>删除</a><a href='javascript:;' onclick='editMenu(this);>修改</a>"+"</td>";
					html += "</tr>";
				}
				$("#menu").append(html);
			}
		});
	}; 
	function deleteMenu(item){
		$ajax({
			type : "delete",
			async : false,
			cache : false,
			processData : false,
			url : taskPath+"/"+id,
		});
	}
</script>
</head>
<body>
	<table id="menu" border="1">
		<tr>
			<td>菜单名称</td>
			<td>菜单类型</td>
			<td>菜单url</td>
			<td>操作</td>
		</tr>
	</table>
</body>
</html>
