<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cinema</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        table,th,td
        {
            border:1px solid black;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.entity eq 'film'}">
    <table>
        <tbody>
        <tr><th>Title</th><th>${requestScope.movie.title}</th></tr>
        <tr><th>Description</th><th>${requestScope.movie.description}</th></tr>
        <tr><th>Duration</th><th>${requestScope.movie.duration}</th></tr>
        </tbody>
    </table>
    <br><br>
    <a href="<c:url value="/administration"></c:url>">Back to Edit page</a>
    </c:when>
    <c:when test="${requestScope.entity eq 'hall'}">
        <table>
            <tbody>
            <tr><th>HallName</th><th>${requestScope.hall.name}</th></tr>
            <tr><th>Rows</th><th>${requestScope.hall.quantityOfRows}</th></tr>
            <tr><th>Places</th><th>${requestScope.hall.placesInRow}</th></tr>
            </tbody>
        </table>
            <br><br>
        <br>
        <a href="<c:url value="/administration"></c:url>">Back to Edit page</a>
    </c:when>
    <c:when test="${requestScope.entity eq 'ticket'}">
        <c:forEach items="${requestScope.ticketList}" var="ticket">
            <table>
                <tbody>
                <tr><th>Row</th><th>${ticket.row}</th></tr>
                <tr><th>Place</th><th>${ticket.place}</th></tr>
                <tr><th>Movie</th><th>${requestScope.session.movie.title}</th></tr>
                <%--<tr><th>Time</th><th>${requestScope.session.time}</th></tr>--%>
                </tbody>
            </table>
            <br><br>
        </c:forEach>
        <br>
        <a href="<c:url value="/films"></c:url>">Previous page</a>
    </c:when>
</c:choose>
</body>
</html>