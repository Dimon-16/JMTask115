<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 19.06.2020
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
<h1>Внимание!</h1><br>
Если вы видите эту страницу, значит не имеете прав на посещения админовских страничек,<br>
или зашли сюда специально. На этой странице можно ознакомиться с данными о пользователе.<br><br>
<h4>Информация о пользователе:</h4><br>
<%
    User user = (User) request.getAttribute("user");
%>
name:  <%=user.getName()%><br>
lastname:  <%=user.getLastName()%><br>
age:  <%=user.getAge()%><br>
role:  <%=user.getRole()%><br>


</body>
</html>
