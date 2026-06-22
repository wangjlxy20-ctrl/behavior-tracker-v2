<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Behavior Tracker</title>

    <style>

        body{
            text-align:center;
            margin-top:100px;
            font-family:Arial,sans-serif;
        }

        a{
            display:inline-block;
            padding:10px 20px;
            background:#4CAF50;
            color:white;
            text-decoration:none;
            border-radius:5px;
        }

        a:hover{
            background:#45a049;
        }

    </style>
</head>

<body>

<h1>Welcome To Behavior Tracker</h1>

<p>
    Record and manage your daily behaviors.
</p>

<a href="${pageContext.request.contextPath}/login.jsp">
    Login
</a>

<br><br>

<a href="${pageContext.request.contextPath}/register.jsp">
    Register
</a>

</body>
</html>