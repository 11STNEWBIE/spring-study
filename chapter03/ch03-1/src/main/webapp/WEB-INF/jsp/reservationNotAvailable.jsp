<%--
  ~ Copyright (c) 2019.
  ~ Made by jjwonyop
  --%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Reservation Not Available</title>
</head>
<body>
Your reservation for ${exception.courtName} is not available on <fmt:formatDate value="${exception.date}"
                                                                                pattern="yyyy-MM-dd"/>
at ${exception.hour}:00.
</body>
</html>
