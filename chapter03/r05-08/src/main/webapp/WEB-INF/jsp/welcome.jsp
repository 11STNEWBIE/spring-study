<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="welcome.title" text="Welcome"/></title>
    <!---해당 코드에 맞는 메시지를 해석할 수 없을 경우, 디폴트로 나올 값을 text에 지정한다-->
</head>

<body>
<h2><spring:message code="welcome.message"
                    text="Welcome to Court Reservation System"/></h2>

Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>.

<hr/>
Handling time : ${handlingTime} ms

<br/>
Locale : ${pageContext.response.locale}

</body>
</html>