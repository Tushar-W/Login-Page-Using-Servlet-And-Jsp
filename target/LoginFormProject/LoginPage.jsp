<%--
  Created by IntelliJ IDEA.
  User: om
  Date: 08/06/2020
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="LoginServlet" method="post">
    <div class="login-box">
        <h1>Login</h1>
        <div class="textbox">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="Username" name="uname">
        </div>

        <div class="textbox">
            <i class="fas fa-key"></i>
            <input type="password" placeholder="password" name="password">
        </div>
        <br>
        <input class="btn" type="submit" name="submit" value="Login">
        <br>
        <a href="RegisterPage.jsp">new user</a>
    </div>
</form>
</body>
</html>