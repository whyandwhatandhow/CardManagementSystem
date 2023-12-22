<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/12/19
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>名片管理系统</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
    <script>
        function showMassage(message){
            var errorDiv = document.getElementById('error-message');
            errorDiv.innerHTML = message;
            errorDiv.style.display = 'block';
        }

        // 禁止浏览器自动填充表单
        document.addEventListener('DOMContentLoaded', function () {
            var forms = document.getElementsByTagName('form');
            for (var i = 0; i < forms.length; i++) {
                forms[i].setAttribute('autocomplete', 'off');
            }
        });
    </script>
</head>

<body>

<div class="login-container">
    <h2>注册</h2>
    <form class="register-btn-form" action="${pageContext.request.contextPath}/user/register" method="post">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="password">确认密码:</label>
            <input type="password" id="enterPassword" name="enterPassword" required>
        </div>
        <div id="error-message" style="color: red; display: none;"></div>
        <button type="submit" class="login-btn">注册</button>
    </form>
    <button onclick="location.href='/jsp/Login.jsp'" class="register-btn">返回</button>
</div>
<script>
    var error1 = '${message1}';
    var error2 = '${message2}';
    var error3 = '${message3}';
    if (error1) {
        alert(error1)
    }else if(error2){
        showMassage(error2)
    }else {
        showMassage(error3)
    }
</script>
</body>
</html>