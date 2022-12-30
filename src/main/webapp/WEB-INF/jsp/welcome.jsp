<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<body>
<div class="container-fluid d-flex flex-row flex-wrap wrapper">
    <c:if test="${products.isEmpty()}">
        <p class="text-center mt-3">La liste est vide</p>
    </c:if>
    <c:if test="${!products.isEmpty()}">
        <c:forEach items="${products}" var="product">
            <div class="card m-4" style="width: 18rem;">
                <div class="card-header card-title"><h5>${product.name}</h5></div>
                <div class="card-body">
                    <p class="card-text">${product.description}</p>
                </div>
                <div class="card-body">
                        ${product.unitPrice}
                    <i class="bi bi-currency-euro"></i>
                </div>
                <div class="card-footer">
                    <form:form method="POST"  action="/security/home/send" modelAttribute="newProduct">
                        <form:input path="id" class="d-none" value="${product.id}" />
                        <form:input path="name" class="d-none" value="${product.name}" />
                        <form:input path="unitPrice" class="d-none" value="${product.unitPrice}" />
                        <form:input path="description" class="d-none" value="${product.description}" />
                        <form:input path="categoryId" class="d-none" value="${product.categoryId}" />
                        <form:button class="border-0"><span class="bi-plus-circle-fill addItem"></span></form:button>
                    </form:form>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>