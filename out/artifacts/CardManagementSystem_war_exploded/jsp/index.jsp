<%@ page import="com.digital.entity.Card" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/12/18
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>名片管理系统</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/index.css">

</head>


<body>
<div class="welcome-container">
  <h2>欢迎‘${param.username}’来到名片管理系统</h2>
</div>

<div class="options-container">
  <div class="dropdown">
    <button class="button">名片管理</button>
    <div class="dropdown-content">
      <a href="#" class="button">添加名片</a>
      <a href="#" class="button">删除名片</a>
      <a href="#" class="button">修改名片</a>
      <a href="#" class="button">查询名片</a>
    </div>
  </div>
  <a href="#" class="button">个人中心</a>
  <a href="#" class="button">安全退出</a>
</div>

<table class="table-hover">
  <thead>
  <tr>
    <th>卡号</th>
    <th>姓名</th>
    <th>公司</th>
    <th>详细</th>
  </tr>
  </thead>
  <tbody>
  <% for (Card card : (List<Card>) request.getAttribute("cards")) { %>
  <tr>
    <td><%=card.getCard_id()%></td>
    <td><%=card.getName()%></td>
    <td><%=card.getWorkplace()%></td>
    <td><a href="#">详细</a></td>
  </tr>
  <% } %>

  </tbody>
</table>

<div class="pagination">
  <a href="#" class="page-link">上一页</a>
  <span>第${num}页</span>
  <a href="#" class="page-link">下一页</a>
</div>

</body>
</html>