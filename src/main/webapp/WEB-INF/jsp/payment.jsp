<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<body>
<c:if test="${!cart.getItems().isEmpty()}">
    <div class="container-fluid mt-5 d-flex justify-content-center">
        <form method="post" action="https://www.sandbox.paypal.com/cgi-bin/webscr" >
            <input type="hidden" name="business" value="sb-wkapc24661120@business.example.com" />
            <input type="hidden" name="cert_id" value="AVvVRDxMx2Bf2prOoTj-oDwjwXAuVVlqbQ5rB8SCL_FJHuC8HwktOOMjseK4MzK8ZuQVPclWQd7WpDkk" />
            <input type="hidden" name="cmd" value="_xclick" />
            <input type="hidden" name="amount" value="${cart.getTotalPrice()}" />
            <input type="hidden" name="item_name" value="Shopping cart foodgood" />
            <input type="hidden" name="currency_code" value="EUR" />
            <input type="hidden" name="lc" value="fr_FR" />
            <input type="hidden" name="cancel_return" value="http://localhost:8088/security/payment/paymentCancelled" />
            <input type="hidden" name="return" value="http://localhost:8088/security/payment/paymentSuccess" />
            <input type="image" src="https://www.paypalobjects.com/fr_FR/BE/i/btn/btn_paynowCC_LG.gif" border="0" name="submit" alt="PayPal, le réflexe sécurité pour payer en ligne">
        </form>
    </div>
</c:if>
</body>
