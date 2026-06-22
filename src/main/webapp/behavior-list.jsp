<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tracker.pojo.Type" %>

<html>
<head>
    <title>Behavior Records</title>

    <style>
        body{
            font-family: Arial,sans-serif;
            margin:30px;
        }

        table{
            border-collapse: collapse;
            width: 80%;
        }

        th,td{
            border:1px solid #ccc;
            padding:10px;
            text-align:center;
        }

        th{
            background:#f5f5f5;
        }

        h1{
            margin-bottom:20px;
        }
    </style>
</head>

<body>

<h1>Behavior Record List</h1>

<h3>Add New Record</h3>

<form action="${pageContext.request.contextPath}/behavior/list" method="post">

    Type:
    <input type="text" name="type" required>

    <br><br>

    Value:
    <input type="number" name="value" required>

    <br><br>

    <button type="submit">Add</button>

</form>

<hr>

<table>

    <tr>
        <th>ID</th>
        <th>User_ID</th>
        <th>Type</th>
        <th>Value</th>
        <th>Create_Time</th>
    </tr>

    <%
        List<Type> list =
                (List<Type>)request.getAttribute("list");

        if(list != null){
            for(Type item : list){
    %>

    <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getUser_id() %></td>
        <td><%= item.getType() %></td>
        <td><%= item.getValue() %></td>
        <td><%= item.getCreate_time() %></td>
    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>