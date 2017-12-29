<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人信息</title>
</head>
<body>
<div class="weui-form-preview">
    <div class="weui-form-preview__hd">
        <label class="weui-form-preview__label">姓名</label> <em
            class="weui-form-preview__value" id="name"></em>
    </div>
    <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">学号</label> <span
                class="weui-form-preview__value" id="number"></span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">性别</label> <span
                class="weui-form-preview__value" id="gender"></span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">专业</label> <span
                class="weui-form-preview__value" id="zy"></span>
        </div>
    </div>
    <form id="formsearch" method="post">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">学期</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" name="Xh" id="picker1"
                       placeholder="请选择学期"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">季度</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" name="Xh" id="picker2"
                       placeholder="请选择季度"/>
            </div>
        </div>
    </form>
    <div class="weui-form-preview__ft">
        <button type="submit"
                class="weui-form-preview__btn weui-form-preview__btn_primary"
                href="javascript:void(0)" id="Search_Mark">查看成绩
        </button>
    </div>
    <%--<div id="popop" class="weui-popup__container">
        <div class="weui-popup__overlay"></div>
        <div class="weui-popup__modal">
            你的内容放在这里...
        </div>
    </div>--%>
    <div class="weui-panel weui-panel_access">
        <div class="weui-panel__hd">图文组合列表</div>
        <div class="weui-panel__bd">
            <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
                <div class="weui-media-box__hd">
                    <img class="weui-media-box__thumb" src="">
                </div>
                <div class="weui-media-box__bd">
                    <h4 class="weui-media-box__title">标题一</h4>
                    <p class="weui-media-box__desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
                </div>
            </a>
            <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
                <div class="weui-media-box__hd">
                    <img class="weui-media-box__thumb" src="">
                </div>
                <div class="weui-media-box__bd">
                    <h4 class="weui-media-box__title">标题二</h4>
                    <p class="weui-media-box__desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
                </div>
            </a>
        </div>
        <div class="weui-panel__ft">
            <a href="javascript:void(0);" class="weui-cell weui-cell_access weui-cell_link">
                <div class="weui-cell__bd">查看更多</div>
                <span class="weui-cell__ft"></span>
            </a>
        </div>
    </div>
    <div class="weui-form-preview" id="grade" style="display: none">
        <div class="weui-form-preview__bd">
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">软件测试技术</label>
                <span class="weui-form-preview__value">91.0分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">动画设计基础</label>
                <span class="weui-form-preview__value">80.8分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">软件测试技术</label>
                <span class="weui-form-preview__value">91.0分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">动画设计基础</label>
                <span class="weui-form-preview__value">80.8分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">软件测试技术</label>
                <span class="weui-form-preview__value">91.0分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">动画设计基础</label>
                <span class="weui-form-preview__value">80.8分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">软件测试技术</label>
                <span class="weui-form-preview__value">91.0分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">动画设计基础</label>
                <span class="weui-form-preview__value">80.8分</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">软件测试技术</label>
                <span class="weui-form-preview__value">91.0分</span>
            </div>
            <div class="weui-form-preview__ft" style="visibility: hidden">
                <a class="weui-form-preview__btn weui-form-preview__btn_default" href="javascript:">辅助操作</a>
                <button type="submit" class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:">
                    操作
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath }/js/base/stuUser.js"></script>
</html>