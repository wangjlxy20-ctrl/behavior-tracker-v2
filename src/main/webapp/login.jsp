<%--
  Created by IntelliJ IDEA.
  User: 30734
  Date: 2026/6/22
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Login</title>
</head>

<body>

<h2>Behavior Tracker Login</h2>

<form action="${pageContext.request.contextPath}/login"
      method="post">

    Username:
    <input type="text"
           name="username"
           required>

    <br><br>

    Password:
    <input type="password"
           name="password"
           required>

    <br><br>

    <button type="submit">
        Login
    </button>

</form>

</body>
</html>