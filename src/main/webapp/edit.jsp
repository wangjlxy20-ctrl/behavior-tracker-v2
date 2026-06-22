<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.tracker.pojo.Type" %>

<%
    Type record =
            (Type)request.getAttribute("record");
%>

<html>
<head>
    <title>Edit Record</title>
</head>

<body>

<h2>Edit Record</h2>

<form action="${pageContext.request.contextPath}/behavior/update"
      method="post">

    <input type="hidden"
           name="id"
           value="<%= record.getId() %>">

    Type:

    <input type="text"
           name="type"
           value="<%= record.getType() %>">

    <br><br>

    Value:

    <input type="number"
           name="value"
           value="<%= record.getValue() %>">

    <br><br>

    <button type="submit">
        Update
    </button>

</form>

</body>
</html>