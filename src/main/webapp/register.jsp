<%--
  Created by IntelliJ IDEA.
  User: 30734
  Date: 2026/6/22
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Register</title>
</head>

<body>

<h2>User Register</h2>

<form action="${pageContext.request.contextPath}/register"
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

    Confirm Password:
    <input type="password"
           name="confirmPassword"
           required>

    <br><br>

    <button type="submit">
        Register
    </button>

</form>

</body>
</html>
