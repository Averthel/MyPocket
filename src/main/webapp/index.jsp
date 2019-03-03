<%--
  Created by IntelliJ IDEA.
  User: Ave
  Date: 03.03.2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MyPocket</title>
</head>
<body>
    <h1>Twój Portfel</h1>

<form action="ProductServlet" method="post">
    <input placeholder="Nazwa produktu" type="text" name="name">
    <br>
    <input placeholder="Kategoria" type="text" name="category">
    <br>
    <textarea placeholder="Opis" rows="5" cols="33" name="description"></textarea>
    <br>
    <input placeholder="cena" type="text" name="price"> <input placeholder="ilość" type="text" name="count">
    <br /><br />
    Szukaj: <input type="radio" name="option" value="search"><br>
    Dodaj: <input type="radio" name="option" value="add"><br>
    Modyfikuj: <input type="radio" name="option" value="update"><br>
    Usuń: <input type="radio" name="option" value="delete"><br>
    <br>
    <input type="submit" value="Wyślij">

</form>
</body>
</html>



</body>
</html>