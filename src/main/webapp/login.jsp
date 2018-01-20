<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>登陆页面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script>
        function Login(){
            var userName = $("#userName").val();
            var password = $("#password").val();
            param = {
                "map": {}
            };
            param.map = {
                "userName": userName,
                "password": password
            };
            $.ajax({
                url : 'http://localhost:8080/security/user/queryUserInfoByNameAndPwd',
                type : "POST",
                data: JSON.stringify(param),
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                success : function(result) {
                    var code = result.result.code;
                    var subCode = result.result.subCode;
                    if(subCode == "10002"){
                        window.location.href = "index.jsp";
                    }else {
                        alert("请输入正确的用户名和密码...");
                    }
                }
            });
        }
    </script>
</head>
<body style="background-color: #C0C0C0">
    <div class="login" >
        <h2 style="color: #E15748">安全生产事故及控制平台--登陆页面</h2>
        <div class="login-top">
            <h1>请登录...</h1>
            <form id="login_form">
                <input id="userName" type="text" value="请输入用户名：" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入用户名：';}">
                <input id="password" type="text" value="请输入密码：" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入密码：';}">
            </form>
            <div class="forgot">
                <input type="submit" value="登陆" onclick="Login();">
            </div>
        </div>
        <div class="login-bottom">
            <h3>新用户、请点击这里：&nbsp;&nbsp;&nbsp;&nbsp;<a href="regist.jsp">注册</a></h3>
        </div>
    </div>
</body>
</html>

