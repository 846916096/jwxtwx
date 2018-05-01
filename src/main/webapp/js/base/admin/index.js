var userInfo = '/wx/admin/getAllUser';
$(document).ready(function () {
    initDate();
});

function initDate() {
    $.ajax({
        url : userInfo,
        type : 'POST',
        dataType : 'json',
        success : function(data) {
            if (data.success) {
                var temp = data.data;
                var html = "";
                for(var i = 0;i<temp.length;i++){
                    html += "<div class=\"weui-form-preview__item\">";
                    html += "<label class=\"weui-form-preview__label\"><img src=\""+temp[i].headimgurl+"\" alt=\"头像\" id=\"imgheader\" height=\"50\" width=\"50\"></label>";
                    html += "<span class=\"weui-form-preview__value\" id=\"name\">"+temp[i].nickname+"</span>";
                    html += "\</div>";
                    html += "<br/>";
                }
                html += "<div class=\"weui-form-preview__ft\" style=\"visibility: hidden\">\n" +
                "               <a class=\"weui-form-preview__btn weui-form-preview__btn_default\" href=\"javascript:\">占位操作</a>\n" +
                "            <button type=\"submit\" class=\"weui-form-preview__btn weui-form-preview__btn_primary\" href=\"javascript:\">\n" +
                "                占位操作\n" +
                "            </button>\n" +
                "        </div>";
                $("#userInfo").append(html);
            } else {
                $.toptip("获取用户失败！请联系管理员",'warning');
            }
        }
    });
}