<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="US-ASCII"%>
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
<%--<form action="${sessionScope.action}" method="${sessionScope.method}">--%>
<%--<form name="loginForm" method="post" action="/deleteHall">--%>
    <form method="post" action="/removeHall">
    <table>
        <tbody>
        <tr><th>ID</th><th>Name</th><th>Rows</th><th>Columns</th>
            <c:if test="${sessionScope.action ne 'allHalls'}">
            <th>Select</th>
            </c:if>
        </tr>
        <c:forEach items="${requestScope.hallDTOList}" var="hall">
            <tr><td>${hall.id}</td><td>${hall.name}</td><td>${hall.rowCount}</td><td>${hall.columnCount}</td>
                <c:if test="${sessionScope.action ne 'allHalls'}">
                <%--<td><input type="radio" name="hallID" value="${hall.id}"></td>--%>
                    <td><input type="radio" name="hallID" value="${hall.id}"></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <c:if test="${sessionScope.action ne 'allHalls'}">
        <input type="submit" value="Remove hall">
    </c:if>
</form>
<br>
<c:if test = "${exception ne null}">
    <div style="color: #FF0000;"><strong>${exception}</strong></div>
</c:if>
<br>
<a href="<c:url value="/administration"></c:url>">Back</a>
<br>
<a href="<c:url value="/logout"></c:url>">Logout</a>

</body>
</html>