<%@ page import="java.util.List" %>
<%@ page import="com.digital.entity.Card" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>查询页面</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/query.css">
</head>
<body>

<div class="welcome-container">
  <h2>请输入你需要查询的内容</h2>
</div>

<div class="search-container">
  <h2>查询页面</h2>
  <form action="${pageContext.request.contextPath}/card/queryCard" method="post">
    <div class="form-group">
      <label for="query">请输入需要查询的内容:</label>
      <input type="text" id="query" name="query" required>
    </div>
    <button type="submit">查询</button>
  </form>
</div>
<div style="color: red">${error}</div>
<div class="search-results">
  <% if (request.getAttribute("searchResults") != null) { %>
  <h3>查询结果：</h3>
  <table>
    <thead>
    <tr>
      <th>卡号</th>
      <th>姓名</th>
      <th>电话</th>
      <th>邮箱</th>
      <th>公司</th>
      <th>职务</th>
      <th>地址</th>
      <th>用户名</th>
      <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <% for (Card result : (List<Card>) request.getAttribute("searchResults")) { %>
    <tr>
      <td><%=result.getCard_id()%></td>
      <td><%=result.getName()%></td>
      <td><%=result.getPhone_num()%></td>
      <td><%=result.getE_mail()%></td>
      <td><%=result.getWorkplace()%></td>
      <td><%=result.getTitle()%></td>
      <td><%=result.getAddress()%></td>
      <td><%=result.getUsername()%></td>
      <td>
        <a href="${pageContext.request.contextPath}/card/deleteCard?id=<%=result.getCard_id()%>">删除</a>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
  <% } %>
</div>

<div class="return-btn">
  <a href="${pageContext.request.contextPath}/card/list?username=${user.username}">返回</a>
</div>

</body>
</html>
