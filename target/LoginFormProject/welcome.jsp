
<%--
  Created by IntelliJ IDEA.
  User: om
  Date: 08/06/2020
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Object user = session.getAttribute("username"); %>
<% Object user1 = session.getAttribute("email"); %>
<% Object user2 = session.getAttribute("date"); %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h2>Welcome to  the World...!!!</h2>
<div style="padding-inline: 5px">
    <h3>User Details</h3>
    Name:  <%=user%><br>
    Email:  <%=user1%><br>
    Registration Date:  <%=user2%>
</div>
</body>
</html>
