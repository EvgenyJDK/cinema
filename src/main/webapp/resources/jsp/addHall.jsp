
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="loginForm" method="post" action="/addHall">
    <br><br>
    <%--Please LOGIN  or <a href="<c:url value="/index"></c:url>REGISTER</a>--%>
    Hall Info
    <%--<a href="<c:url value="/registration"></c:url>REGISTER</a>--%>
     <br><br>
    <%--Username: <input type="text" name="username"/> <br/>--%>
    HallName: <input type="text" name="title"/> <br/>
    <%--Description: <input type="text" name="description"/> <br/>--%>
    Quantity of Rows: <input type="number" name="rows"/> <br/>
    Places in Row: <input type="number" name="columns"/> <br/>
    <br><br>
    <input type="submit" value="Add New Hall" />
</form>


<%--<br><br>--%>
<%--<a href="<c:url value="/login"></c:url>">Login</a>--%>
<%--<a href="<c:url value="/register"></c:url>">Register</a>--%>
<%--<br><br>--%>


</body>
</html>
