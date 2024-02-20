<%@ page import="com.n1nt3nd0.demonew.servlet.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.02.2024
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 1 way-->
<jsp:useBean id="employeeFromRequest" scope="request" class="com.n1nt3nd0.demonew.servlet.model.Employee"/>
<div>
    <jsp:getProperty name="employeeFromRequest" property="name"/>
    <jsp:getProperty name="employeeFromRequest" property="id"/>
</div>

<%
    Employee employee =(Employee) request.getAttribute("employeeFromRequest");
    %>
<div>
    <%=employee.getName()%>
    ||
    <%=employee.getId()%>
</div>




<br/>


<!-- 2 way-->
<jsp:useBean id="employeeFromSession" scope="session" class="com.n1nt3nd0.demonew.servlet.model.Employee"/>
<div>
    <jsp:getProperty name="employeeFromSession" property="name"/>
    <jsp:getProperty name="employeeFromSession" property="id"/>
</div>

<br/>

<!-- 3 way-->
<jsp:useBean id="employeeFromContext" scope="application" class="com.n1nt3nd0.demonew.servlet.model.Employee"/>
<div>
    <jsp:getProperty name="employeeFromContext" property="name"/>
    <jsp:getProperty name="employeeFromContext" property="id"/>
</div>

<div>======================================</div>
<div>======================================</div>


<!-- EXPRESSION LANGUAGE -->
<div>
    <!--requestScope - it's default variable which have every jsp -->
    Name: ${requestScope.employeeFromRequest.name}
    ID: ${requestScope.employeeFromRequest.id}
</div>
<div>
    <!--sessionScope - it's default variable which have every jsp -->
    Name: ${sessionScope.employeeFromSession.name}
    ID: ${sessionScope.employeeFromSession.id}
</div>
<div>
    <!--applicationScope - it's default variable which have every jsp -->
    Name: ${applicationScope.employeeFromContext.name}
    ID: ${applicationScope.employeeFromContext.id}
</div>
<div>======================================</div>
<div>
    <!-- arrayList from attributes RequestScope -->
    list: ${ArrayListFromRequestAttributes[0]}, ${ArrayListFromRequestAttributes[1]}
    <!-- hashmap from attributes RequestScope -->
    map: ${ourHashMapFromRequestAttributes.Petya}, ${ourHashMapFromRequestAttributes.Garik}

    ${cookie.JSESSIONID}
    ${header.get("Authorization")}
    ${param.get("myParametrFromRequest")}
</div>
</body>
</html>
