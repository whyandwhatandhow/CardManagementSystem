<%@ page import="com.digital.entity.Card" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>名片详情</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/details.css">
</head>
<body>
<div class="details-container">
    <% if (request.getAttribute("cardPerson") != null) { %>
    <h3>名片详情：</h3>
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
        </tr>
        </thead>
        <tbody>
        <% Card result= (Card) request.getAttribute("cardPerson"); %>
        <tr>
            <td><%=result.getCard_id()%></td>
            <td><%=result.getName()%></td>
            <td><%=result.getPhone_num()%></td>
            <td><%=result.getE_mail()%></td>
            <td><%=result.getWorkplace()%></td>
            <td><%=result.getTitle()%></td>
            <td><%=result.getAddress()%></td>
            <td><%=result.getUsername()%></td>
        </tr>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/card/toEnter" class="button">更新</a>
    <a href="${pageContext.request.contextPath}/card/list?username=${user.username}" class="button">返回</a>
    <% } %>
</div>
</body>
</html>
