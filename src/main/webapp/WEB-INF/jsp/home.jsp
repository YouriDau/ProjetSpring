<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<body>
    <h1 class="title">Home</h1>
    <c:if test="${products.isEmpty()}">
        <p class="text-center mt-3">There is not products for the moment</p>
    </c:if>
    <c:if test="${!products.isEmpty()}">

        <div class="container mb-5 border d-flex flex-column align-items-center">
            <h4>Choose the product's category</h4>
            <form:form method="POST" action="/foodgood/home/category" modelAttribute="categoryChoosen" class="w-25">
                <form:select path="label" class="form-select">
                    <form:option value="all" />
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.label}" />
                    </c:forEach>
                </form:select>
                <form:button type="submit" class="btn btn-secondary">Apply</form:button>
            </form:form>
        </div>
        <div class="container d-flex flex-row flex-wrap wrapper">
            <c:forEach items="${products}" var="product">
                <div class="card m-4" style="width: 18rem;">
                    <div class="card-header card-title">
                        <h5>${product.name}<a href="<spring:url value='/product?name=${product.name}'/>"><span class="bi-eye cardItem"></span></a></h5>
                    </div>
                    <div class="card-footer">
                        <c:if test="${product.promotion == null}">
                            <p>${product.unitPrice} €</p>
                        </c:if>
                        <c:if test="${product.promotion != null}">
                            <del>${product.unitPrice} €</del>
                            <p>${product.getPriceWithPromo()} €</p>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</body>
</html>