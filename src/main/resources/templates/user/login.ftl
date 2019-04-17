<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>登录</title>
    <link rel="stylesheet" href="${request.contextPath}/bootstrap4/css/bootstrap.min.css">
    <style>
        html, body {
            height: 100%;
        }

        .wrapper {
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 40px 0;
            background-color: #f5f5f5;
        }

        .form-signin {
            width: 330px;
            padding: 15px;
        }

        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .form-signin .checkbox {
            font-weight: 400;
        }
    </style>
</head>
<body>
<div class="text-center wrapper">
    <form id="login-from" class="form-signin">
        <img src="${request.contextPath}/image/bootstrap-solid.svg" class="mb-4" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
        <label for="username" class="sr-only">用户名</label>
        <input type="text" id="username" class="form-control" placeholder="用户名" name="username" autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" class="form-control" placeholder="密码" name="password">
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" name="remember" value="remember">
                记住我
            </label>
        </div>
        <button type="button" class="btn btn-lg btn-primary btn-block" id="login">登录</button>
        <p class="mt-5 mb-3 text-muted">© 2018-2019</p>
    </form>
</div>

<script type="text/javascript" src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('#login').click(function () {
            let username = $('#username').val();
            let password = $('#password').val();
            if (username && password) {
                $.ajax({
                    type: 'post',
                    url: 'login',
                    data: $('#login-from').serialize(),
                    success: function (data) {
                        if (data.status === 0) {
                            location.href = '${request.contextPath}/admin/index';
                        } else {
                            alert(data.message);
                        }
                    },
                    error: function () {
                        alert('服务器很忙');
                    }
                });
            } else {
                alert('请填写用户名和密码');
            }
        });
    });
</script>
</body>
</html>