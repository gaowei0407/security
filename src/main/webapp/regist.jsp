<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>登陆页面</title>
    <link href="css/regist.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <style>
        #main_accident_add_table tr td{
            border: 1px solid red;
            height: 40px;
            line-height: 40px;
        }
    </style>
    <script>
        function save_registForm(){
            var userName = $("#userName").val();
            var password = $("#password").val();
            var repassword = $("#repassword").val();
            if(userName == null || userName == "" || password == null || password == "" || repassword == null || repassword == "" ) {
                $.messager.alert("消息提醒", "你输入的数据不完整...", "warning");
                return;
            }
            param = {
                "map": {}
            };
            param.map = {
                "username": userName,
                "password" : password
            };
            $.ajax({
                type: "POST",
                data: JSON.stringify(param),
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                url : 'http://localhost:8080/security/user/registerUserInfo',
                success : function (data){
                    if(data.result.subCode == "10002"){
                        alert("注册成功...");
                        window.location.href = "login.jsp";
                    }
                }
            });
        }
    </script>
</head>
<body style="background-color: #C0C0C0">
    <div class="login" >
        <h2 style="color: #E15748">安全生产事故及控制平台--注册页面</h2>
        <div class="login-top">
                <%--添加页面（window）--%>
                <div style="width:100%;height:100%;padding:10px;;overflow: hidden">
                    <form id="login_form"  method="post">
                        <div id="dialogarea">
                            <table id="main_accident_add_table" border="1" cellpadding="1" cellspacing="1" style="border:1px solid red;width: 100%;height: 100%;font-size: 14px;color: #222222;font-family: 微软雅黑">
                                <tr>
                                    <td>
                                        <div class="inputname" style="text-align: right">用户名：</div>
                                    </td>
                                    <td>
                                        <div class="inputvalue" style="text-align: center">
                                            <input type="text" id="userName" name="userName" class="easyui-validatebox"
                                                   style="width:200px;border:0px solid red;"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="inputname" style="text-align: right">密码 ：</div>
                                    </td>
                                    <td>
                                        <div class="inputvalue" style="text-align: center">
                                            <input id="password" name="password" style="width:200px;border:0px solid red;" class="easyui-validatebox" type="text"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="inputname" style="text-align: right">重复填写密码 ：</div>
                                    </td>
                                    <td>
                                        <div class="inputvalue" style="text-align: center">
                                            <input id="repassword" name="repassword" style="width:200px;border:0px solid red;" class="easyui-validatebox" type="text"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </form>
                </div>
        </div>
        <div class="login-bottom">
            <h3><a onclick="save_registForm()">保存</a></h3>
            <br>
            <span id="infos" style="color: #fff"></span>
        </div>
    </div>
</body>
</html>

