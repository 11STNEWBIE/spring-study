<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a1101092
  Date: 2019-04-22
  Time: 01:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reservationQuery</title>
</head>
<body>
<form method="post">
    Court Name
    <input type="text" name="courtName" value="${courtName}" />
    <input type="submit" value="Query" />
</form>

<table border="1">
    <tr>
        <th>Court Name</th>
        <th>Date</th>
        <th>Hour</th>
        <th>Player</th>
    </tr>
    <c:forEach items="{reservations}" var="reservation">
    <tr>
        <td>${reservation.courtName}</td>
        <td><fmt:formatDate value="{reservation.date}" pattern="yyyy-MB-dd"/></td>
        <td>${reservation.hour}</td>
        <td>preservation.player, name}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
