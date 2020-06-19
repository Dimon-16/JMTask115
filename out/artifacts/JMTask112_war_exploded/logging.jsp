<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 19.06.2020
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Эта страница для входа в приложение. </h3><br>

Предполагается, что пользователи уже зарегестрированы и хранятся в БД<br>
в качестве пароля используйте lastName пользователя. Если имя пользователя есть в системе БД,
вход будет считаться успешным.<br><br>
<form action="" method="POST">
    <input type="text" name="login" value="name"><br>
    <input type="text" name="password" value="password"><br>
    <input type="submit" value="Send to server">
</form>

</body>
</html>
