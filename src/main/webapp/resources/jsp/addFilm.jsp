
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="loginForm" method="post" action="/addFilm">
    <br><br>
    <%--Please LOGIN  or <a href="<c:url value="/index"></c:url>REGISTER</a>--%>
    Film Info
    <%--<a href="<c:url value="/registration"></c:url>REGISTER</a>--%>
     <br><br>
    <%--Username: <input type="text" name="username"/> <br/>--%>
    Title: <input type="text" name="title"/> <br/>
    Description: <input type="text" name="description"/> <br/>
    Duration: <input type="number" name="duration"/> <br/>
    <br><br>
    <input type="submit" value="Add New Film" />
</form>


<%--<br><br>--%>
<%--<a href="<c:url value="/login"></c:url>">Login</a>--%>
<%--<a href="<c:url value="/register"></c:url>">Register</a>--%>
<%--<br><br>--%>


</body>
</html>
