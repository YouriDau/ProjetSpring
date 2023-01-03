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
        <div class="container-fluid">
            <h1 class="text-center">The categories will be placed here</h1>
        </div>

        <div class="container-fluid mb-5">
            <h3>Choose the product's category</h3>
            <form:form method="POST" action="/security/home/category" modelAttribute="categoryChoosen" class="w-25">
                <form:select path="label" class="form-select">
                    <form:option value="all" />
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.label}" />
                    </c:forEach>
                </form:select>
                <form:button type="submit" class="btn btn-secondary">Apply</form:button>
            </form:form>
        </div>

        <c:forEach items="${products}" var="product">
            <div class="card m-4" style="width: 18rem;">
                <div class="card-header card-title">
                    <h5>${product.name}<a href="<spring:url value='/product?name=${product.name}'/>"><span class="bi-eye cardItem"></span></a></h5>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>