<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<body>
<h1 class="title">Registration</h1>
<form:form method="POST"  action="/security/registration/send" modelAttribute="registration" class="userForm">
    <div class="w-25 mx-auto">
        <form:label path="username">Pseudo <span class="mandatory">*</span></form:label>
        <form:input path="username" class="form-control"/>
        <form:errors path="username" class="errorMessage"/>
        <c:if test="${usernameError != null}">
            <p class="errorMessage text-center">${usernameError}</p>
        </c:if>
        <br/>
        <form:label path="password">Password <span class="mandatory">*</span></form:label>
        <form:password path="password" class="form-control"/>
        <form:errors path="password" class="errorMessage"/>
        <br/>
        <form:label path="lastName">Last name <span class="mandatory">*</span></form:label>
        <form:input path="lastName" class="form-control"/>
        <form:errors path="lastName" class="errorMessage"/>
        <br/>
        <form:label path="firstName">First name <span class="mandatory">*</span></form:label>
        <form:input path="firstName" class="form-control"/>
        <form:errors path="firstName" class="errorMessage"/>
        <br/>
        <form:label path="birthDate">Birth date</form:label>
        <form:input path="birthDate" type="date" class="form-control"/>
        <form:errors path="birthDate" class="errorMessage"/>
        <br/>
        <form:label path="email">Email <span class="mandatory">*</span></form:label>
        <form:input path="email" class="form-control"/>
        <form:errors path="email" class="errorMessage"/>
        <c:if test="${emailError != null}">
            <p class="errorMessage text-center">${emailError}</p>
        </c:if>
        <br/>
        <form:label path="phoneNumber">Phone number <span class="mandatory">*</span></form:label>
        <form:input path="phoneNumber" class="form-control"/>
        <form:errors path="phoneNumber" class="errorMessage"/>
        <c:if test="${phoneNumberError != null}">
            <p class="errorMessage text-center">${phoneNumberError}</p>
        </c:if>
        <br/>
        <form:label path="address">Address <span class="mandatory">*</span></form:label>
        <form:input path="address" class="form-control"/>
        <form:errors path="address" class="errorMessage"/>
        <br/>
        <form:label path="tvaNumber">TVA number</form:label>
        <form:input path="tvaNumber" class="form-control"/>
        <form:errors path="tvaNumber" class="errorMessage"/>
        <br/>
        <p><span class="mandatory">*</span> This field is mandatory</p>
        <br/>
        <form:button class="btn btn-success">Register</form:button>
    </div>
</form:form>
</body>
