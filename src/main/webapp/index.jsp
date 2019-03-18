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

<br /><br />
<h2>Register Panel</h2>

<form action="UserServlet" method="post">
    <input placeholder="Nazwa użytkownika" type="text" name="username">
    <br />
    <input placeholder="E-mail" type="email" name="email">
    <br />
    <input placeholder="Hasło" type="password" name="password">
    <br />
    <button type="submit" name="register" value="register">Zarejestruj się!</button><button type="submit" name="update" value="update">Zmień email i hasło</button>
</form>
<br />
<form action="UserServlet" method="post">
    <input placeholder="Szukaj..." type="text" name="findUser">
    <br />
    <button type="submit" name="search" value="search">Szukaj!</button>
</form>

<br />

<form action="UserServlet" method="post">
    <h3>Usuń usera</h3>
    <input placeholder="Nazwa użytkownika" type="text" name="userForDelete">
    <br />
    <button type="submit" name="delete" value="delete">Usuń!</button>

</form>



</body>
</html>