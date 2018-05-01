<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>教务系统管理员登录</title>
    <!-- 引入 WeUI -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/weui.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery-weui.min.css">
</head>
<body>
	<form id="formlogin" method="post">
	<input type="hidden" id="userInfo">
	<div class="weui-cells__title" align="center">用户登录</div>
      <div class="weui-cell">
          <div class="weui-cell__hd"><label class="weui-label">账号</label></div>
          <div class="weui-cell__bd">
              <input class="weui-input" type="number" name="Xh" pattern="[0-9]*" id="loginname" placeholder="请输入账号"/>
          </div>
      </div>
      <div class="weui-cell">
          <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
          <div class="weui-cell__bd">
              <input class="weui-input" type="password" name="password" pattern="[0-9]*" id="passwordlogo" placeholder="请输入密码"/>
          </div>
      </div>
      <a href="javascript:void(0)" id="login_sub" class="weui-btn weui-btn_primary">登录</a>
	</form>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-weui.min.js"></script>
<script type="text/javascript">
var LOGIN = {
		checkInput:function() {
			if(!$("#formlogin #loginname").val()) {
				$.toptip('请输入账号', 'warning');
				return false;
			}
			if(!$("#formlogin #passwordlogo").val()) {
				$.toptip('请输入密码', 'warning');
				return false;
			}
			return true;
		},
		doLogin:function() {
			$.post("/wx/admin/user/login", $("#formlogin").serialize(),function(data){
				if (data.success) {
					$.toptip("登录成功", 'success');
					window.localStorage.setItem("token", data.message);
					location.href = data.data;
				} else {
					$.toptip(data.message, 'warning');
				}
			});
		},
		login:function() {
			if (this.checkInput()) {
				this.doLogin();
			}
		}
};
$(document).ready(function() {
	$("#login_sub").click(function(){
		LOGIN.login();
	});
});
</script>
</html>
