<%--
  Created by IntelliJ IDEA.
  User: om
  Date: 08/06/2020
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="RegistrationServlet" method="post">
    <div class="register-box">
        <h1>Register</h1>
        <div class="textbox">
            <label>
                <input type="text" placeholder="name" name="name">
            </label>
        </div>
        <div class="textbox">
            <label>
                <input type="text" placeholder="email" name="email">
            </label>
        </div>
        <div class="textbox">
            <label>
                <input type="password" placeholder="password" name="password">
            </label>
        </div>
        <br>
        <input class="btn" type="submit" name="submit" value="Register">
    </div>
</form>
</body>
</html>
