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
    <title>注册</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
            width: 300px;
            text-align: center;
        }

        .login-container h2 {
            color: #333;
        }

        .login-form {
            margin-top: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login-btn,
        .register-btn {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .login-btn:hover,
        .register-btn:hover {
            background-color: #45a049;
        }

        .register-btn {
            background-color: #008CBA;
            margin-top: 10px;
        }

        .register-btn:hover {
            background-color: #007BAA;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>注册</h2>
    <form class="register-btn-form" action="#" method="post">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="name">名字:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="phone_num">电话号码:</label>
            <input type="text" id="phone_num" name="phone_num" required>
        </div>
        <div class="form-group">
            <label for="e_mail">邮箱:</label>
            <input type="text" id="e_mail" name="e_mail" required>
        </div>

        <div class="form-group">
            <label for="workplace">工作地点:</label>
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
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="password">确认密码:</label>
            <input type="password" id="enterPassword" name="enterPassword" required>
        </div>
        <button type="submit" class="login-btn">注册</button>
    </form>
    <button class="register-btn">返回</button>
</div>

</body>
</html>