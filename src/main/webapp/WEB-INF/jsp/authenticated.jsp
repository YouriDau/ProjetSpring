<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<body>
<div>You are able to see this page because you are authenticated</div>

<sec:authorize access="hasRole('ADMIN')">
    <div>
        <a href="<spring:url value="/home"/>">Admin board</a>
    </div>
</sec:authorize>

<br>
</body>
</html>
