<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/12/22
  Time: 18:59
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
  <h2>添加名片</h2>
  <form class="register-btn-form" action="${pageContext.request.contextPath}/card/addCard" method="post">
    <div class="form-group">
      <label for="name">姓名:</label>
      <input type="text" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="phone_num">电话:</label>
      <input type="text" id="phone_num" name="phone_num" required>
    </div>
    <div class="form-group">
      <label for="e_mail">邮箱:</label>
      <input type="text" id="e_mail" name="e_mail" required>
    </div>
    <div class="form-group">
      <label for="workplace">单位:</label>
      <input type="text" id="workplace" name="workplace" required>
    </div>
    <div class="form-group">
      <label for="title">职务:</label>
      <input type="text" id="title" name="title" required>
    </div>
    <div class="form-group">
      <label for="address">地址:</label>
      <input type="text" id="address" name="address" required>
    </div>
    <div class="form-group">
      <label for="username">用户名:</label>
      <input type="text" id="username" name="username" required>
    </div>
    <div id="error-message" style="color: red; display: none;"></div>
    <button type="submit" class="login-btn">确认</button>
  </form>
  <button onclick="location.href='/jsp/index.jsp'" class="register-btn">返回</button>
</div>
<script>
  var error1 = '${message1}';
  if (error1) {
    showMassage(error1);
  }
</script>
</body>
</html>
