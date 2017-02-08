<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../template/tag.jsp" %>
<html>
<head>
    <script src="/static/lib/jquery/jquery.js"></script>
    <script src="/static/js/login.js"></script>
    <style type="text/css">
    </style>
    <title>login</title>
</head>
<body >
welcome web xml init!<spring:message code="system.hello" />
<div style="float: right;padding-right: 3%;line-height: 50px;">
    <a href="?locale=zh_CN" >中文</a>
    <a href="?locale=en_US" >英文</a>
</div>


<div style=" margin:0 40%; width:400px; height:300px;">
    <p  style="font-size: 40px;color: blue;padding-left: 50px">用户登录</p>
    <form id="loginForm">
        <tr >
            <td >用户：</td>
            <td ><input type="text" name="username" onblur="validate_input_(this)"></td>

        </tr>
        </br> </br>
        <tr>
            <td >密码：</td>
            <td ><input type="password" name="password" onblur="validate_input_(this)"></td>

        </tr></br> </br>
        <tr>
            <div style="text-align:center;padding-right: 150px">
                <input type="button" value="登录" onclick="login()"/></div>
        </tr>
    </form>
</div>

</body>

</html>
