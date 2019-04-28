<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ Copyright (c) 2019.
  ~ Made by jjwonyop
  --%>

<html>
<head>

    <title>
        <spring:message code="welcome.title" text="Welcome" />
    </title>
</head>

<body>
<h2>Welcome to Court Reservation System</h2>
Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>.
<hr />
Handling Time : ${handlingTime}ms
<br />
Locale : ${pageContext.response.locale}
<h2>
    <spring:message code="welcome.message" text="Welcome to Court Reservation System" />
</h2>
</body>
</html>
