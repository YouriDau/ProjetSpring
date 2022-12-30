<%--
  Created by IntelliJ IDEA.
  User: youri
  Date: 30-12-22
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="card m-4 mx-auto mt-5" style="width: 18rem;">
    <div class="card-header card-title">
        <h5>${product.name}</h5>
    </div>
    <div class="card-body">
        <p>${product.description}</p>
        <p>${product.unitPrice} <i class="bi bi-currency-euro"></i></p>
    </div>
    <div class="card-footer">
        <form:form id="productCardOptions" method="POST"  action="/security/home/send" modelAttribute="newProduct" class="mt-1">
            <form:input path="id" class="d-none" value="${product.id}" />
            <form:input path="name" class="d-none" value="${product.name}" />
            <form:input path="unitPrice" class="d-none" value="${product.unitPrice}" />
            <form:input path="description" class="d-none" value="${product.description}" />
            <form:input path="categoryId" class="d-none" value="${product.categoryId}" />
            <form:button class="border-0"><span class="bi-plus-circle-fill addItem"></span></form:button>
        </form:form>
    </div>
</div>
</body>
