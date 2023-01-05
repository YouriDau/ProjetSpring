<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<body>
    <h1 class="text-center">Your cart</h1>
    <div class="container-fluid mt-5">
        <table class="table-bordered table-light container">
            <tr>
                <th class="text-center">Name</th>
                <th class="text-center">Unit price</th>
                <th class="text-center">Quantity</th>
                <th class="text-center">Price</th>
                <th class="text-center">Remove</th>
            </tr>
            <c:forEach items="${cart.items.values()}" var="item">
                <tr>
                    <td>${item.product.name}</td>
                    <td>${item.product.unitPrice} €</td>
                    <td>
                        <form:form method="POST" action="/security/cart/sendQuantity" modelAttribute="cartItem">
                            <form:input path="product.name" value="${item.product.name}" class="d-none" />
                            <form:input path="quantity" value="${item.quantity}" onchange="submit()" type="number" class="numberInput text-center" />
                        </form:form>
                    </td>
                    <td>${item.getTotal()} €</td>
                    <td class="text-center">
                        <a href="<spring:url value="/cart/removeItem/${item.product.name}" />" ><span class="bi-trash removeBtn" /></a>
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
    </div>
    <div class="container-fluid mt-5 d-flex justify-content-center">
        <form method="post" action="https://www.sandbox.paypal.com/cgi-bin/webscr" >
            <input type="hidden" name="business" value="sb-wkapc24661120@business.example.com" />
            <input type="hidden" name="cert_id" value="AVvVRDxMx2Bf2prOoTj-oDwjwXAuVVlqbQ5rB8SCL_FJHuC8HwktOOMjseK4MzK8ZuQVPclWQd7WpDkk" />
            <input type="hidden" name="cmd" value="_xclick" />
            <input type="hidden" name="amount" value="${cart.getTotalPrice()}" />
            <input type="hidden" name="item_name" value="Shopping cart foodgood" />
            <input type="hidden" name="currency_code" value="EUR" />
            <input type="hidden" name="lc" value="fr_FR" />
            <input type="hidden" name="return" value="http://localhost:8088/security/cart/paymentSuccess" />
            <input type="image" src="https://www.paypalobjects.com/fr_FR/BE/i/btn/btn_paynowCC_LG.gif" border="0" name="submit" alt="PayPal, le réflexe sécurité pour payer en ligne">
        </form>
    </div>

</body>
