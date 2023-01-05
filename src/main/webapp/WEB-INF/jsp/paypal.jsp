<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02/01/2023
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
    <form:form method="POST" action="https://www.sandbox.paypal.com/cgi-bin/webscr" >
<<<<<<< Updated upstream
        <form:input type="hidden" name="business" value="sb-brzgj24727046@business.example.com" />
        <form:input type="hidden" name="cert_id" value="sb-kd9kw24710246@personal.example.com" />
        <form:input type="hidden" name="cmd" value="_xclick" />
        <form:input type="hidden" name="amount" />
        <form:input type="hidden" name="item_name" value="item_name" />
        <form:input type="hidden" name="return" value="urlOnValidPayment" />
        <form:input type="hidden" name="cancel_return" value="UrlOnCancelPayment" />
        <form:input type="hidden" name="currency_code" value="USD" />
        <form:input type="hidden" name="lc" value="EN" />
=======
        <input type="hidden" name="business" value="sb-brzgj24727046@business.example.com">
        <input type="hidden" name="cert_id" value="sb-kd9kw24710246@personal.example.com">
        <input type="hidden" name="cmd" value="_xclick">
        <input type="hidden" name="amount_1" value="??">
        <input type="hidden" name="item_name_1" value="??">
        <input type="hidden" name="return" value="urlOnValidPayment">
        <input type="hidden" name="cancel_return" value="UrlOnCancelPayment">
        <input type="hidden" name="currency_code" value="USD">
        <input type="hidden" name="lc" value="EN">
>>>>>>> Stashed changes
    </form:form>
</body>
</html>
