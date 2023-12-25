<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/12/19
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>名片管理系统</title>
  <!-- 在<head>标签中添加以下内容 -->
  <script>
    function showErrorMessage(message,color) {
      var DivMessage = document.getElementById('message');
      DivMessage.innerHTML=message;
      DivMessage.style.color=color;
      DivMessage.style.display='block'
    }
  </script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/Login.css">
</head>
<body>

<div class="login-container">
  <h2>请输入密码</h2>
  <form class="login-form" action="${pageContext.request.contextPath}/card/toUpdate" method="post">
    <div class="form-group">
      <input type="hidden" id="username" value="${user.username}">
      <label for="password">密码:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <!-- 在<form>标签之后添加以下内容 -->
    <div id="message" style="display: none;"></div>
    <button type="submit" class="login-btn">确认</button>
  </form>
  <button onclick="location.href='${pageContext.request.contextPath}/card/personShow?username=${user.username}'" class="register-btn">返回</button>
</div>
<!-- 在<body>标签的末尾添加以下内容 -->
<script>
  var error = '${error}';
  if (error) {
    showErrorMessage(error,'red');
  }
</script>

<script>
  // 禁止浏览器自动填充表单
  document.addEventListener('DOMContentLoaded', function () {
    var forms = document.getElementsByTagName('form');
    for (var i = 0; i < forms.length; i++) {
      forms[i].setAttribute('autocomplete', 'off');
    }
  });
</script>
</body>
</html>
