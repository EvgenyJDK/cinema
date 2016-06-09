<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="US-ASCII"%>
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
<%--<form action="${sessionScope.action}" method="${sessionScope.method}">--%>
    <form method="post" action="/removeFilm">
<table>


    <%--<table>--%>
        <tbody>
        <tr><th>ID</th><th>title</th><th>description</th><th>duration</th>
            <c:if test="${sessionScope.action ne 'allFilms'}">
                <th>Select</th>
            </c:if>
        </tr>
        <c:forEach items="${requestScope.filmList}" var="film">
            <tr><td>${film.id}</td><td>${film.title}</td><td>${film.description}</td><td>${film.duration}</td>
                <c:if test="${sessionScope.action ne 'allFilms'}">
                    <%--<td><input type="radio" name="hallID" value="${hall.id}"></td>--%>
                    <td><input type="radio" name="filmID" value="${film.id}"></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    <%--</table>--%>



    <%--<tbody>--%>
    <%--<tr><th>ID</th><th>title</th><th>description</th><th>duration</th>--%>
        <%--&lt;%&ndash;<th>rating</th>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:if test="${sessionScope.action ne 'allFilms'}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;deleteFilm&ndash;%&gt;--%>
        <%--<c:if test="${sessionScope.action ne 'allFilms'}">--%>
        <%--<th>Select</th>--%>
        <%--</c:if>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${requestScope.filmList}" var="film">--%>
        <%--<tr><td><c:out value="${film.id}"></c:out></td>--%>
            <%--<td><c:out value="${film.title}"></c:out></td>--%>
            <%--<td><c:out value="${film.description}"></c:out></td>--%>
            <%--<td><c:out value="${film.duration}"></c:out></td>--%>

            <%--&lt;%&ndash;<td><input type="radio" name="selected_movie" value="${film.id}"></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="radio" name="filmID" value="${film.id}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${film.rating}"></c:out></td>&ndash;%&gt;--%>

            <%--<c:if test="${sessionScope.action ne 'allFilms'}">--%>
            <%--&lt;%&ndash;<c:if test="${sessionScope.action ne 'allFilms'}">&ndash;%&gt;--%>
            <%--<td><input type="radio" name="selected_movie" value="${film.id}"></td>--%>
            <%--&lt;%&ndash;<input type="radio" name="filmID" value="${film.id}">&ndash;%&gt;--%>
            <%--</c:if>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>



</table>
    <c:if test="${sessionScope.action ne 'allFilms'}">
<input type="submit" value="Remove film">
    </c:if>
</form>
<br><br>
<c:if test = "${exception ne null}">
    <p>Exception is : ${exception} <br />
        Exception Message: ${exception.message}</p>
</c:if>
<br><br>
<c:if test="${sessionScope.action eq 'allFilms'}">
    <a href="<c:url value="/administration"></c:url>">Back</a>
</c:if>
<a href="<c:url value="/logout"></c:url>">Logout</a>
<%--<a href="<c:url value="/registration"></c:url>">Register</a>--%>

</body>
</html>