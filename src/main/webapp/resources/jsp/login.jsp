
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<body>

<%--<a href="<c:url value="/movie"></c:url>">Movie</a>--%>

<form name="loginForm" method="post" action="/login">

    <br><br>
     Please LOGIN  or <a href="<c:url value="/registration"></c:url>">REGISTER</a>
     <br><br>


    Username: <input type="text" name="login"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>


<%--<br><br>--%>
<%--<a href="<c:url value="/login"></c:url>">Login</a>--%>
<%--<a href="<c:url value="/register"></c:url>">Register</a>--%>
<%--<br><br>--%>


</body>
</html>
