<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
<div class="card m-4 mx-auto mt-5" style="width: 18rem;">
    <div class="card-header card-title">
        <h5>${product.name}</h5>
    </div>
    <div class="card-body">
        <p>${product.description}</p>
        <c:choose>
            <c:when test="${product.promotion == null}">
                <p>${product.unitPrice} €</p>
            </c:when>
            <c:otherwise>
                <del>${product.unitPrice} €</del>
                <p>${product.getPriceWithPromo()} €</p>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="card-footer">
        <form:form method="POST"  action="/security/product/addItem" modelAttribute="newItem">
            <form:input path="product.id" type="hidden" value="${product.id}" />
            <form:input path="product.name" type="hidden" value="${product.name}" />
            <form:input path="product.unitPrice" type="hidden" value="${product.getPriceWithPromo()}" />
            <form:input path="product.description" type="hidden" value="${product.description}" />
            <form:input path="product.categoryId" type="hidden" value="${product.categoryId}" />
            <form:label path="quantity">number of products to add in the cart</form:label>
            <br/>
            <form:input path="quantity"  class="numberInput" value="1" type="number" />
            <form:errors path="quantity" class="errorMessage" />
            <form:button type="submit" class="border-0"><span class="bi-plus-circle-fill cardItem"></span></form:button>
        </form:form>
    </div>
</div>
</body>
