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
<form action="administration" method="post">
        <tr><th>ADMINISTRATOR HOMEPAGE</th></tr>
        <br><br>
        <tr>
            <td><button type="submit" name="action" value="allFilms" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">View All Films</button></td>
            <br><br>
            <td><button type="submit" name="action" value="addFilm" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Add New Film</button></td>
            <%--<br><br>--%>
            <%--<td><button type="submit" name="action" value="editFilm" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Edit Current Film</button></td>--%>
            <%--<br><br>--%>
            <%--<td><button type="submit" name="action" value="addHallToFilm" style="width: 200px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Add New Film to Hall</button></td>--%>
            <br><br>
            <td><button type="submit" name="action" value="removeFilm" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Remove Film</button></td>

        <%--</tr>--%>
        <%--<br><br>--%>
        <%--<tr><th>SEANS ADMINISTRATION</th></tr>--%>
        <%--<br><br>--%>
        <%--<tr><td><button type="submit" name="action" value="addSeans" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Add Seans</button></td>--%>
            <%--<br><br>--%>
            <%--<td><button type="submit" name="action" value="editSeans" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Edit Seans</button></td>--%>
        <%--</tr>--%>
        <br><br>
        <tr><th>HALL ADMINISTRATION</th></tr>
        <br><br>
        <tr>
            <td><button type="submit" name="action" value="allHalls" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">View All Halls</button></td>
            <br><br>
            <td><button type="submit" name="action" value="addHall" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Add Hall</button></td>
            <br><br>
            <%--<td><button type="submit" name="action" value="editHall" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Edit Hall</button></td>--%>
            <%--<br><br>--%>
            <td><button type="submit" name="action" value="removeHall" style="width: 150px; height: 20px; background-color: #fff; color: black; border: 1px solid #CCCCCC; font-size: 14px;">Remove Hall</button></td>
        </tr>
</form>

<br><br>
<c:if test = "${exception ne null}">
    <p>Exception is : ${exception} <br />
        Exception Message: ${exception.message}</p>
</c:if>
<br><br>

<a href="<c:url value="/logout"></c:url>">Logout</a>

</body>
</html>