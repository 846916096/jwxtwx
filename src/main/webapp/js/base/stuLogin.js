var LOGIN = {
    checkInput:function() {
        if(!$("#formlogin #loginname").val()) {
            $.toptip('请输入学号', 'warning');
            return false;
        }
        if(!$("#formlogin #passwordlogo").val()) {
            $.toptip('请输入密码', 'warning');
            return false;
        }
        if(!$("#formlogin #checkNumber").val()) {
            $.toptip('请输入验证码', 'warning');
            return false;
        }
        return true;
    },
    doLogin:function() {
        $.post("/wx/user/login", $("#formlogin").serialize(),function(data){
            if (data.success) {
                $.toptip("登录成功", 'success');
                window.localStorage.setItem("userName",$("#formlogin #loginname").val());
                /*保存用户信息至token*/
                window.localStorage.setItem("token", data.message);
                location.href = data.data;
            } else {
                reloadValidCode();
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

/*点击切换验证码 js*/
function reloadValidCode() {
    $("#imageNumber").attr("src","/wx/user/validCodeServlet?timed="+ new Date().getMilliseconds());
}

$(document).ready(function() {
    var userNameNoLogin = window.localStorage.getItem("userName");
    $("#formlogin #loginname").val(userNameNoLogin);
    $("#login_sub").click(function(){
        LOGIN.login();
    });
});
