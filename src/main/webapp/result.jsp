<%@ page import="pl.ave.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Ave
  Date: 03.03.2019
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Product product = (Product)request.getAttribute("product"); %>
<!DOCTYPE html>
<html>
<head>
    
    <title>Wynik operacji</title>
</head>
<body>
    <h1>Wynik zapytania <%=request.getAttribute("option") %></h1>
    <p>W wyniku Twojego zapytania otrzymano następujacy wynik:</p>
    <p>Nazwa: <%= product.getName() %><br>
        Kategoria: <%= product.getCategory() %><br>
        Cena: <%= product.getPrice() %><br>
        Ilość: <%= product.getCount() %></p>
</body>
</html>
