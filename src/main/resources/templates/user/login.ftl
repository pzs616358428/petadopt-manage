<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${request.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/common.css">
</head>
<body>
<div class="container">
    <form>
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" placeholder="用户名" name="username">
            <div class="alert alert-danger" role="alert" id="username-alert">请输入用户名</div>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="密码" name="password">
            <div class="alert alert-danger" role="alert" id="password-alert">请输入密码</div>
        </div>
        <button type="button" class="btn btn-primary" id="login">登录</button>
    </form>
</div>

<script type="text/javascript" src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script>
    $(function () {
        // 页面加载后隐藏两个警告框
        $("#username-alert").hide();
        $("#password-alert").hide();

        $("#login").click(function () {
            // 获取用户名
            let username = $("#username").val();
            // 获取密码
            let password = $("#password").val();
            if (username && password) {
                // 登录前隐藏两个提示框
                $("#username-alert").hide();
                $("#password-alert").hide();
            } else {
                if (!username) {
                    $("#username-alert").show();
                }
                if (!password) {
                    $("#password-alert").show();
                }
            }
        });
    });
</script>
</body>
</html>