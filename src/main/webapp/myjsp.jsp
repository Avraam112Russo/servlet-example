<%@ page import="java.util.Date" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="com.n1nt3nd0.demonew.DataBaseRepository" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.02.2024
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My first jsp</title>
</head>
<body>
<h1>hello, bro</h1>
<h2>
  <%=
  new DataBaseRepository().getPersonList()
  %>
</h2>
</body>
</html>
