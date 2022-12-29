<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
<form:form method="POST"  action="/security/login/send" modelAttribute="login">
    <div class="w-25 mx-auto">
        <form:label path="username"> User Name : </form:label>
        <form:input path="username" class="form-control"/>

        <form:label path="password"> Password : </form:label>
        <form:input path="password" class="form-control"/>

        <form:button class="btn btn-success">Sign In</form:button>
    </div>

</form:form>
</body>
