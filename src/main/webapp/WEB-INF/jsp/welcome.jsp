<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<body>
<div class="container-fluid d-flex flex-row flex-wrap wrapper">
    <c:if test="${products.isEmpty()}">
        <p>La liste est vide</p>
    </c:if>
    <c:if test="${!products.isEmpty()}">
        <form:form method="POST"  action="/security/category/send" modelAttribute="category">

        </form:form>

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
                    <a href="#" class="card-link">
                        <span class="bi-plus-circle-fill addItem"></span>
                    </a>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>