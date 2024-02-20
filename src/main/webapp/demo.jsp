<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.02.2024
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>



<%--<%@page extends="com.n1nt3nd0.demonew.servlet.model.Basket" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello world</h1>
<div>
    <% int i = 5555;%>
    <%= String.valueOf(i)%>
    <%!
    private String test(){
        return "return";
    }
    %>
    <%=test()%>
    <% if (Math.random()>0.5){%>
    <div>Hello world</div>
    <% }%>
    <%=
    "work"
    %>
</div>
<br/>
<br/>
<br/>
<br/>


<!-- add other jsp page in this jsp page -->
<%--<div>--%>
<%--    <jsp:include page="myjsp.jsp"/>--%>
<%--</div>--%>
<%--<!-- add other servlet in this jsp page -->--%>
<%--<div>--%>
<%--    <jsp:include page="/servlet4"/>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <jsp:include page="/WEB-INF/test.txt"/>--%>
<%--</div>--%>
<br/>
<br/>

<jsp:useBean id="employe1" class="com.n1nt3nd0.demonew.servlet.model.Employee" scope="page"/>
<jsp:setProperty name="employe1" property="name" value="Russo" />
<jsp:setProperty name="employe1" property="id" value="1000" />
<div>
<jsp:getProperty name="employe1" property="id"/>
<jsp:getProperty name="employe1" property="name"/>
</div>


<hr/>





<%!
    public static String returnName(){
        return "Elena";
    }
%>
<%! String name = returnName();%>


<%!
public Integer returnElenaId(){
    return 2000;
}
%>
<%! Integer elenaId = returnElenaId();%>

<jsp:useBean id="employe2" class="com.n1nt3nd0.demonew.servlet.model.Employee" scope="page"/>
<jsp:setProperty name="employe2" property="name" value="<%=name%>" />
<jsp:setProperty name="employe2" property="id" value="<%=elenaId%>" />
<div>
    <jsp:getProperty name="employe2" property="id"/>
    <jsp:getProperty name="employe2" property="name"/>
</div>






<% String nameFromParams = request.getParameter("name");%>
<% Integer idFromParams = Integer.parseInt(request.getParameter("id"));%>
<jsp:useBean id="employe3" class="com.n1nt3nd0.demonew.servlet.model.Employee" scope="page"/>
<jsp:setProperty name="employe3" property="name" value="<%=nameFromParams%>" />
<jsp:setProperty name="employe3" property="id" value="<%=idFromParams%>" />
<div>
    <jsp:getProperty name="employe3" property="name"/>
    <jsp:getProperty name="employe3" property="id"/>
</div>

</body>
</html>
