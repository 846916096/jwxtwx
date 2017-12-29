<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,user-scalable=0">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>湖北民族学院教务系统</title>
</head>
<body>
<form id="formsearch" method="post" enctype="multipart/form-data">
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">消息类型</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="leixing" id="picker1"
                   placeholder="请选择消息类型"/>
        </div>
    </div>
    <div class="weui-cell" id="title" style="display: none">
        <div class="weui-cell__hd">
            <label class="weui-label">标题</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="title" id="title"
                   placeholder="请输入标题"/>
        </div>
    </div>
    <div class="weui-cells__title">文本消息内容</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea class="weui-textarea" name="description" id="TextNews"
                          placeholder="请输入文本" rows="3"></textarea>
                <div class="weui-textarea-counter">
                    <!-- <span id="wordCheck">0</span>/300 -->
                </div>
            </div>
        </div>
    </div>
    <div class="weui-cell" id="urlinput" style="display: none">
        <div class="weui-cell__hd">
            <label class="weui-label">跳转URL</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="url" id="sendUrl"
                   placeholder="请输入跳转URL"/>
        </div>
    </div>
    <div class="weui-cell" id="fileinput" style="display: none">
        <div class="weui-cell__hd">
            <label class="weui-label">选择图片</label>
        </div>
        <div class="weui-cell__bd">
            <input type="file" name="file" id="fileUpload" accept="image/*"/>
        </div>
       <%-- <div class="weui-uploader__bd">
            <div class="weui-uploader__input-box">
                <input id="fileUpload" name="file" class="weui-uploader__input" type="file" accept="image/*" />
            </div>
        </div>--%>
    </div>

    <br/><br/>
    <a href="javascript:void(0)" id="Search_Mark" class="weui-btn weui-btn_primary">发送消息</a>
</form>
</body>
<script src="${pageContext.request.contextPath }/js/base/news.js"></script>
</html>
