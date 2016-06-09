<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>

    <%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
</head>
<html>
<body>
<h1>Hello, friend </h1> <c:out value="${requestScope.firstName}"></c:out> <c:out value="${requestScope.lastName}"></c:out>
<br><br>
<a href="<c:url value="/movie"></c:url>">Movie</a>
<br><br>
<a href="<c:url value="/logout"></c:url>">Logout</a>
</body>
</html>