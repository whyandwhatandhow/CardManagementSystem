<%@ page import="com.digital.entity.Card" %><%--
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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/register.css">
  <script>
    document.addEventListener('DOMContentLoaded', function () {
      var succeed = '${succeed}';
      var error1 = '${error1}';
      var error2 = '${error2}';

      if (succeed) {
        showMessage(succeed, 'green');
      } else if (error1) {
        showMessage(error1, 'red');
      } else if (error2) {
        showMessage(error2, 'red');
      }
    });

    function showMessage(message, color) {
      console.log('showMessage function called with message:', message);
      var DivMessage = document.getElementById('message');
      DivMessage.innerHTML = message;
      DivMessage.style.color = color;
      DivMessage.style.display = 'block';
    }

    // 禁止浏览器自动填充表单
    var forms = document.getElementsByTagName('form');
    for (var i = 0; i < forms.length; i++) {
      forms[i].setAttribute('autocomplete', 'off');
    }
  </script>
</head>

<body>

<div class="login-container">
  <h2>更新卡片</h2>
  <form class="register-btn-form" action="${pageContext.request.contextPath}/card/updateNewCard" method="post">
    <input type="hidden" name="card_id" id="card_id" value="${card1.card_id}">
    <div class="form-group">
      <label for="name">姓名:</label>
      <input type="text" id="name" name="name" value="${card1.name}"  required>
    </div>
    <div class="form-group">
      <label for="phone_num">电话:</label>
      <input type="text" id="phone_num" name="phone_num" value="${card1.phone_num}"  required>
    </div>
    <div class="form-group">
      <label for="e_mail">邮箱:</label>
      <input type="text" id="e_mail" name="e_mail" value="${card1.e_mail}"   required>
    </div>
    <div class="form-group">
      <label for="workplace">单位:</label>
      <input type="text" id="workplace" name="workplace" value="${card1.workplace}"  required>
    </div>
    <div class="form-group">
      <label for="title">职务:</label>
      <input type="text" id="title" name="title" value="${card1.title}"  required>
    </div>
    <div class="form-group">
      <label for="address">地址:</label>
      <input type="text" id="address" name="address" value="${card1.address}"  required>
    </div>
    <div class="form-group">
      <label for="username">用户名:</label>
      <input type="text" id="username" name="username" value="${user.username}" required>
    </div>
    <div class="form-group">
      <label for="password">密码:</label>
      <input type="password" id="password" name="password">
    </div>

    <div class="form-group">
      <label for="password">确认密码:</label>
      <input type="password" id="enterPassword" name="enterPassword">
    </div>
    <div id="message" style="display: none;"></div>
    <button type="submit" class="login-btn">确认</button>
  </form>
  <button onclick="location.href='${pageContext.request.contextPath}/card/personShow?username=${user.username}'" class="register-btn">取消</button>
</div>
</body>
</html>
