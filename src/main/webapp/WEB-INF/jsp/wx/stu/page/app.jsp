<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,user-scalable=0">
    <title>湖北民族学院教务系统</title>
</head>
<body>
<%@include file="content" %>

<div class="weui-grids">
    <a href="javascript:void(0);" class="weui-grid js_grid" id="exam">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/exam.png" alt="" />
        </div>
        <p class="weui-grid__label">
            考试安排
        </p>
    </a>
    <a href="javascript:void(0);" class="weui-grid js_grid">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/kebiao.png" alt="">
        </div>
        <p class="weui-grid__label">
            课表查询
        </p>
    </a>
    <a href="javascript:void(0);" class="weui-grid js_grid">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/xuefen.png" alt="">
        </div>
        <p class="weui-grid__label">
            创新学分
        </p>
    </a>
    <a href="javascript:void(0);" class="weui-grid js_grid">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/pingjia.png" alt="">
        </div>
        <p class="weui-grid__label">
            教学评价
        </p>
    </a>
    <a href="javascript:void(0);" class="weui-grid js_grid">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/money.png" alt="">
        </div>
        <p class="weui-grid__label">
            圈存服务
        </p>
    </a>
    <a href="javascript:void(0);" class="weui-grid js_grid">
        <div class="weui-grid__icon">
            <img src="${pageContext.request.contextPath }/img/about.png" alt="">
        </div>
        <p class="weui-grid__label">
            关于我们
        </p>
    </a>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/base/stuApp.js"></script>
</html>
