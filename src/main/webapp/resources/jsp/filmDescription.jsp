<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        table,th,td
        {
            border:1px solid black;
        }
    </style>
</head>
<body>
<form action="administration" method="post">
    <table>
        <tbody>
        <tr><th>Title</th><th>${requestScope.title}</th></tr>
        <tr><th>Description</th><th>${requestScope.description}</th></tr>
        <tr><th>Duration</th><th>${requestScope.duration}</th></tr>
        <%--<tr><th>Rating</th><th>${requestScope.rating}</th></tr>--%>
        </tbody>
    </table>
    <br><br>
    <a href="<c:url value="/administration"></c:url>">Back to Edit page</a>
</form>
<br><br>
</body>
</html>