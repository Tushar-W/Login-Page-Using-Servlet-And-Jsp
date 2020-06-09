<%--
  Created by IntelliJ IDEA.
  User: om
  Date: 08/06/2020
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<form action="RegistrationServlet" method="post">
    <table>
        <tr>
            <td> Name : </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> EmailId : </td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td> Password : </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Register"></td>
            <td><a href="LoginPage.jsp">login</a></td>
        </tr>
    </table>
</form>
</body>
</html>
