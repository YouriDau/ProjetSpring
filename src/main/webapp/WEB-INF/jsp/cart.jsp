<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
    <h1 class="text-center">Your cart</h1>
    <table class="container table-bordered table-light">
      <tr>
        <th class="text-center">Name</th>
        <th class="text-center">Price</th>
        <th class="text-center">Quantity</th>
        <th class="text-center">Remove</th>
      </tr>
      <c:forEach items="${cart.getItems().values()}" var="item">
        <tr>
          <td>${item.name}</td>
          <td>${item.unitPrice}</td>
          <td>
              ${item.quantity}</td>
          <td class="text-center">
            <span class="bi-trash removeBtn"></span>
          </td>
        </tr>
      </c:forEach>
    </table>
</body>
