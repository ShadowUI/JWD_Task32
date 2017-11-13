<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link href="../../css/table.css" rel="stylesheet">
<link href="../../css/button.css" rel="stylesheet">
<head>
    <title>User data</title>
</head>
<body>
<div class="table-container">
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Phone number</th>
            <th>E-mail</th>
        </tr>
        <c:forEach items="${requestScope.foundUsers}" var="user">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.surname}"/></td>
                <td><c:out value="${user.phoneNumber}"/></td>
                <td><c:out value="${user.email}"/></td>
            </tr>
        </c:forEach>

    </table>
    <form action="../../index.jsp">
        <p id="button"> <input type="submit" value="Return" /></p>
    </form>
</div>
</body>
</html>
