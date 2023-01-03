<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09/12/2022
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <title>User registration</title>
</head>
<body>
<form:form method="POST"  action="/security/registration/send" modelAttribute="registration">
    <div class="w-25 mx-auto">
        <form:label path="username">Pseudo</form:label>
        <form:input path="username" class="form-control"/>
        <form:errors path="username" class="errorMessage"/>
        <br/>
        <form:label path="password">Password</form:label>
        <form:password path="password" class="form-control"/>
        <form:errors path="password" class="errorMessage"/>
        <br/>
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" class="form-control"/>
        <form:errors path="lastName" class="errorMessage"/>
        <br/>
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" class="form-control"/>
        <form:errors path="firstName" class="errorMessage"/>
        <br/>
        <form:label path="birthDate">Birth date</form:label>
        <form:input path="birthDate" type="date" class="form-control"/>
        <form:errors path="birthDate" class="errorMessage"/>
        <br/>
        <form:label path="email">Email</form:label>
        <form:input path="email" class="form-control"/>
        <form:errors path="email" class="errorMessage"/>
        <br/>
        <form:label path="phoneNumber">Phone number</form:label>
        <form:input path="phoneNumber" class="form-control"/>
        <form:errors path="phoneNumber" class="errorMessage"/>
        <br/>
        <form:label path="address">Address</form:label>
        <form:input path="address" class="form-control"/>
        <form:errors path="address" class="errorMessage"/>
        <br/>
        <form:label path="tvaNumber">TVA number</form:label>
        <form:input path="tvaNumber" class="form-control"/>
        <form:errors path="tvaNumber" class="errorMessage"/>

        <form:button class="btn btn-success">Register</form:button>
    </div>
</form:form>
</body>
</html>
