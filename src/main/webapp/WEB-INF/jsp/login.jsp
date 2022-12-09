<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<head>
    <title>Spring Security Example </title>
</head>
<body>
<form:form method="POST"  modelAttribute="user" >
        <form:label path="username"> User Name : </form:label>
        <form:input path="username"/>
        <form:label path="password"> Password : </form:label>
        <form:input path="password"/>
        <form:button>Sign In</form:button>

    </form:form>

</body>
</html>
