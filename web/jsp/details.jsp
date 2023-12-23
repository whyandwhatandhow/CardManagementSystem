<%@ page import="com.digital.entity.Card" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>名片详情</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .details-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a.button {
            display: inline-block;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #4caf50;
            color: white;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        a.button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="details-container">
    <% if (request.getAttribute("cardDetail") != null) { %>
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
        <% Card result= (Card) request.getAttribute("cardDetail"); %>
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
    <a href="${pageContext.request.contextPath}/card/list" class="button">返回</a>
    <% } %>
</div>
</body>
</html>
