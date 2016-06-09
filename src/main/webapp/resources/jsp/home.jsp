<%--
  Created by IntelliJ IDEA.
  User: Kovantonlenko
  Date: 12/21/2015
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title></title>
</head>
<body>
Hello <c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"></c:out> from home.jsp
</body>
</html>
