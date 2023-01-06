<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
<h1 class="text-center title">Login</h1>
<form:form method="POST" modelAttribute="login" class="userForm">
    <div class="w-25 mx-auto">
        <form:label path="username"> User Name : </form:label>
        <form:input path="username" class="form-control"/>
        <br/>
        <form:label path="password"> Password : </form:label>
        <form:password path="password" class="form-control"/>
        <br/>
        <form:button type="submit" class="btn btn-success">Sign In</form:button>
    </div>

</form:form>
</body>
