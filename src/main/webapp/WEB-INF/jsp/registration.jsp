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
  <form:form
             methode="POST"
             action="/security/registration/send"
             modelAttribute="registration">
    <form:label path="username">Pseudo</form:label>
    <form:input path="username"/>
    <form:errors path="username" />

    <form:label path="password">Password</form:label>
    <form:input path="password"/>
    <form:errors path="password" />

    <form:label path="lastName">Last name</form:label>
    <form:input path="lastName"/>
    <form:errors path="lastName" />

    <form:label path="firstName">First name</form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName" />

    <form:label path="birthDate">Birth date</form:label>
    <form:input path="birthDate"/>
    <form:errors path="birthDate" />

    <form:label path="email">Email</form:label>
    <form:input path="email"/>
    <form:errors path="email" />

    <form:label path="phoneNumber">Phone number</form:label>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber" />

    <form:label path="address">Address</form:label>
    <form:input path="address"/>
    <form:errors path="address" />

    <form:label path="tvaNumber">TVA number</form:label>
    <form:input path="tvaNumber"/>
    <form:errors path="tvaNumber" />

    <form:button>Register</form:button>
  </form:form>
</body>
</html>
