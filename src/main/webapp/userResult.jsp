<%@ page import="pl.ave.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ave
  Date: 17.03.2019
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Wykonano operacje: <%= request.getAttribute("operation") %> </h2>


</body>
</html>
