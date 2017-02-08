<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/login.js"></script>
    <title>login</title>
</head>
<body>
welcome!
<table>

</table>

<form id="loginForm">
    <tr>
        <td>username</td>
        <td><input type="text" name="username" onblur="validate_input_(this)"></td>

    </tr>
    <tr>
        <td>password</td>
        <td><input type="password" name="password" onblur="validate_input_(this)"></td>

    </tr>
    <tr>
        <input type="button" value="登录" onclick="login()"/>
    </tr>
</form>
</body>

</html>
<script>
    function login() {
        $.ajax({
            url: "/login",
            type: "get",
            dataType: "json",
            data: $("#loginForm").serialize(),
            success: function (data) {
                if (data) {
                    alert(data.message);
                    if (data.code==0)
                    window.location.href = "/home"
                }
            },
            error: function (error) {
                alert(error)
            }
        })
    }
</script>