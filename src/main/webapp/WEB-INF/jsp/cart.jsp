<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
    <h1 class="text-center">Your cart</h1>
    <table class="container table-bordered table-light">
      <tr>
        <th class="text-center">Name</th>
        <th class="text-center">Unit price</th>
        <th class="text-center">Quantity</th>
        <th class="text-center">Price</th>
        <th class="text-center">Remove</th>
      </tr>
      <c:forEach items="${cart.getItems().values()}" var="item">
        <tr>
          <td>${item.getName()}</td>
          <td>${item.getUnitPrice()} €</td>
          <td>
              <form:form method="POST" action="/security/cart/sendQuantity" modelAttribute="cartItem">
                  <form:input path="name" value="${item.getName()}" class="d-none" />
                  <form:input path="quantity" value="${item.getQuantity()}" onchange="submit()" type="number" class="numberInput text-center" />
              </form:form>
          </td>
          <td>${item.getTotal()} €</td>
          <td class="text-center">
              <a href="<spring:url value="/cart/removeItem/${item.getName()}" />" ><span class="bi-trash removeBtn" /></a>
          </td>
        </tr>
      </c:forEach>
        <tr class="tableBottom">
            <td>Total</td>
            <td></td>
            <td></td>
            <td>${cart.getTotalPrice()} €</td>
            <td></td>
        </tr>
    </table>
</body>
