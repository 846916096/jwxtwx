var token = window.localStorage.getItem("token");
var sendText = "/jwxtwx/news/text";
var uploadPic = "/jwxtwx/news/uploadPic";
$(document).ready(function () {
    initpicker1();

    $("#Search_Mark").click(function () {
        Search_Mark();
    });
    $("#uploadPic").click(function () {
        UploadPic();
    });
});

function initpicker1() {
    $("#picker1").picker({
        title: "消息类型列表",
        cols: [{
            textAlign: 'center',
            values: ['文本消息', '图文消息'],

        }],
        onChange: function () {
            if ($("#picker1").val() == "文本消息") {
                $("#urlinput").css('display', 'block');
                $("#fileUpload").css('display', 'block');
                $("#fileinput").css('display', 'block');
                $("#title").css('display', 'block');
            } else {
                $("#urlinput").css('display', 'none');
                $("#fileUpload").css('display', 'none');
                $("#fileinput").css('display', 'none');
                $("#title").css('display', 'none');
            }
        }
    });
};

function Search_Mark() {
    if (this.checkInput()) {
        this.doSend();
    }
};

function checkInput() {
    if (!$("#picker1").val()) {
        $.toptip('请选择消息类型', 'warning');
        return false;
    }
   /* if ($('#title').css('display') == "block") {
        if (!$("#title").val()) {
            $.toptip('请输入标题', 'warning');
            return false;
        }
    }*/
    if (!$("#TextNews").val()) {
        $.toptip('请输入文本', 'warning');
        return false;

    }
    if ($('#urlinput').css('display') == "block") {
        if (!$("#sendUrl").val()) {
            $.toptip('请输入url', 'warning');
            return false;
        }
    }
    if ($('#fileUpload').css('display') == "block") {
        if (!$("#fileUpload").val()) {
            $.toptip('请选择图片', 'warning');
            return false;
        }
    }
    return true;
};

function doSend() {
    /* $.post(sendText, $("#formsearch").serialize(), function (data) {
         /!* @ TODO 输入文本字数限制  *!/
         if (data.success) {
             $.toptip(data.message, 'success');
         } else {
             $.toptip(data.message, 'warning');
         }
     });*/
    var formData = new FormData(document.getElementById("formsearch"));
    $.ajax({
        url: sendText,
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {
            $.toptip(data.message, 'warning');
        }
    });
};