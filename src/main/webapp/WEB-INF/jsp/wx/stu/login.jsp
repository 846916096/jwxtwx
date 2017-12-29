<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>教务系统学生登录</title>
    <!-- 引入 WeUI -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/weui.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery-weui.min.css">
</head>
<body>
    <div>
        <div class="weui-cells__title" align="center">用户登录</div>
    </div>
	<form id="formlogin" method="post">
	<input type="hidden" id="userInfo">
      <div class="weui-cell">
          <div class="weui-cell__hd"><label class="weui-label">学号</label></div>
          <div class="weui-cell__bd">
              <input class="weui-input" type="number" name="Xh" pattern="[0-9]*" id="loginname" placeholder="请输入学号"/>
          </div>
      </div>
      <div class="weui-cell">
          <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
          <div class="weui-cell__bd">
              <input class="weui-input" type="password" name="password" pattern="[0-9]*" id="passwordlogo" placeholder="请输入密码"/>
          </div>
      </div>
        <div class="weui-cell weui-cell_vcode">
            <div class="weui-cell__hd"><label class="weui-label">验证码</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" placeholder="请输入验证码"  name="checkNumber" id="checkNumber" >
            </div>
            <div class="weui-cell__ft">
                <img class="weui-vcode-img" id="imageNumber" src="${pageContext.request.contextPath }/wx/user/validCodeServlet" onclick="reloadValidCode()"/>
            </div>
        </div>
      <a href="javascript:void(0)" id="login_sub" class="weui-btn weui-btn_primary">登录</a>
	</form>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-weui.min.js"></script>
<script src="${pageContext.request.contextPath }/js/base/stuLogin.js"></script>
</html>
