var token = window.localStorage.getItem("token");
var userInfo = "/jwxtwx/wx/user/info?token=" + token;
$(document).ready(function() {
    initInfo();
    initpicker1();
    initpicker2();
    $("#Search_Mark").click(function() {
        Search_Mark();
    });
});
function initInfo(data) {
    $
        .ajax({
            url : userInfo,
            type : 'POST',
            dataType : 'json',
            async : false,
            cache : false,
            contentType : false,
            processData : false,
            success : function(data) {
                if (data.success) {
                    document.getElementById("name").innerText = data.data.xsjbxxXm;
                    document.getElementById("number").innerText = data.data.xsjbxxXh;
                    document.getElementById("gender").innerText = data.data.xsjbxxXb;
                    document.getElementById("zy").innerText = data.data.xsjbxxZymc;
                } else {
                   $.toptip("长时间未操作，请重新登录",30000, 'warning');
                    /**redis中缓存过期,清除页面缓存*/
                    window.localStorage.removeItem("token");
                    location.href = data.message;
                }
            }
        });
};


function initpicker1() {
    $("#picker1").picker({
        title : "请选择学期",
        cols : [ {
            textAlign : 'center',
            values : [ '2014', '2015', '2016', '2017', '2018' ]
        } ]
    });
};
function initpicker2() {
    $("#picker2").picker({
        title : "请选择季度",
        cols : [ {
            textAlign : 'center',
            values : [ '春季', '秋季' ]
        } ]
    });
};
function Search_Mark() {
    if (this.checkInput()) {
        this.doSearch();
    }
};
function checkInput() {
    if (!$("#picker1").val()) {
        $.toptip('请选择学期', 'warning');
        return false;
    }
    if (!$("#picker2").val()) {
        $.toptip('请选择季度', 'warning');
        return false;
    }
    return true;
};
function doSearch() {
    $("#grade").css('display', 'block');
    /* @ TODO 查询成绩接口开发 */
    /* $.post("", $("#formlogin").serialize(),function(data){
        if (data.success) {
            $.toptip(data.message, 'success');
            location.href = data.data;
        } else {
            $.toptip(data.message, 'warning');
        }
    }); */
}

