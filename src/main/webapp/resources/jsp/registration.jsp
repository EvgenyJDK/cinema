<%--<jsp:useBean id="userBean" class="com.kov.lectures.lecture_9_Servlet.beans.User" scope="session"/>--%>

<jsp:useBean id="userBean" class="com.cinema.model.User" scope="session"/>
<h2>Registration form </h2>

<form name="myform" method="POST" action="/registration">

    First name * <input type="text" name="firstName"> <br>
    Last name *  <input type="text" name="lastName"><br>
    Email *      <input type="text" name="email"><br>
    Login *      <input type="text" name="login"><br>
    Password *   <input type="password" name="password"><br>



    <input type="submit" value="Save"></form>