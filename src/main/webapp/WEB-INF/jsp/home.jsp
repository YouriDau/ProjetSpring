<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<body>
<div class="container-fluid d-flex flex-row flex-wrap wrapper">
    <c:if test="${products.isEmpty()}">
        <p class="text-center mt-3">There is not products for the moment</p>
    </c:if>
    <c:if test="${!products.isEmpty()}">
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>

        <c:forEach items="${products}" var="product">
            <div class="card m-4" style="width: 18rem;">
                <div class="card-header card-title">
                    <h5>${product.name}<a href="<spring:url value='/product?name=${product.name}'/>"><span class="bi-eye cardItem"></span></a></h5>
                </div>
                <div class="card-footer">
                    <form:form method="POST"  action="/security/home/send" modelAttribute="newProduct" class="">
                        <form:input path="id" class="d-none" value="${product.id}" />
                        <form:input path="name" class="d-none" value="${product.name}" />
                        <form:input path="unitPrice" class="d-none" value="${product.unitPrice}" />
                        <form:input path="description" class="d-none" value="${product.description}" />
                        <form:input path="categoryId" class="d-none" value="${product.categoryId}" />
                        <form:label path="quantity">number of products to add in the cart</form:label>
                        <form:input path="quantity"  class="numberInput" value="1" />
                        <form:errors path="quantity" />
                        <form:button class="border-0"><span class="bi-plus-circle-fill cardItem"></span></form:button>
                    </form:form>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>