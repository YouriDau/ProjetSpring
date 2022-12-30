<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
  <c:if test="${basket == null}">
    <h1 class="text-center mt-3">Your shopping basket is empty</h1>
  </c:if>
  <c:if test="${basket != null}">
    <h1 class="text-center">Your Basket</h1>
    <table class="container table-bordered table-light">
      <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Options</th>
      </tr>
      <c:forEach items="${basket.getItems().values()}" var="item">
        <tr>
          <td>${item.name}</td>
          <td>${item.unitPrice}</td>
          <td>quantity here</td>
          <td>
            <span class="bi-plus-circle addBtn"></span>
            <span class="bi-dash-circle lessBtn"></span>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

</body>
