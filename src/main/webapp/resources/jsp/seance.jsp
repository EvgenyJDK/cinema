
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/tickets" method="get">
  <table>
    <tbody>
    <tr><th>Title</th><th>Hall</th>><th>Select</th></tr>
    <%--<th>Time</th--%>
    <c:forEach items="${requestScope.sessionList}" var="session">
      <tr>
        <td>${session.movie.title}</td><td>${session.hall.name}</td>
        <%--<td>${session.time}</td>--%>
        <td><input type="submit" name="sessionID" value="${session.id}"></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <br>
  <input type="submit" value="Make your choice">
</form>
<br><br>
<c:if test = "${exception ne null}">
  <div style="color: #FF0000;"><strong>${exception}</strong></div>
</c:if>
<br><br>

<a href="<c:url value="/logout"></c:url>">Logout</a>

</body>
</html>
