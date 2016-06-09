
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cinema</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<form action="tickets" method="post">
    <table>
        <tbody>
        <c:forEach var="i" begin="1" end="${requestScope.rows}" varStatus="row">
        <tr>
            <c:forEach var="j" begin="1" end="${requestScope.columns}" varStatus="column">
            <c:forEach items="${requestScope.ticketList}" var="ticket">

            <c:if test="${(ticket.row == i)}">
            <c:if test="${(ticket.column == j)}">
                <c:set var="flag" value="1"/>
            </c:if>
            </c:if>
            </c:forEach>
            <c:choose>
            <c:when test="${flag == 1}">
            <td>
                <input id="${i}${j}" type="checkbox" name="${i} ${j}" disabled checked/>
                <label for="${i}${j}"> row ${i} place ${j}</label>
                    <c:set var="flag" value="0"/>
                </c:when>
                <c:otherwise>
            <td>
                <input id="${i}${j}" type="checkbox" name="${i} ${j}"/>
                <label for="${i}${j}"> row ${i} place ${j}</label>
            </td>
            </c:otherwise>
            </c:choose>
            </c:forEach>
        <tr>
            </c:forEach>
        </tbody>
        <input type="hidden" name="session_id" value="${requestScope.session}"/>
    </table>
    <input type="submit" value="Purchase ticket">
</form>
<br><br>
<c:if test = "${exception ne null}">
    <div style="color: #FF0000;"><strong>${exception}</strong></div>
</c:if>
<br><br>
<a href="<c:url value="/films"></c:url>">Films</a>
</body>
</html>
