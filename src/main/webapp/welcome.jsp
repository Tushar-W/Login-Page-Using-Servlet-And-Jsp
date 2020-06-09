<%--
  Created by IntelliJ IDEA.
  User: om
  Date: 08/06/2020
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<h1>Hi <%= request.getAttribute("user")%>, Login Successful.</h1>
<a href="login.html">Login Page</a>
</body>
</html>
