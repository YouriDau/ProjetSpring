<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <link type="text/css" href="<spring:url value='/css/first.css' />"
          rel="Stylesheet" />
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />"
          rel="Stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr" />
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en" />
    </spring:url>
</head>
<body>
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="#">FoodHype</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<spring:url value="/home" />">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/registration"/>">Sign up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/authenticated"/>">Sign in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/cart"/>"><span class="bi-cart4"></span></a>
            </li>
        </ul>

        <ul class="navbar-nav mr-auto">
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item active">
                    <p class="navbar-text">Welcome ${pageContext.request.userPrincipal.name}</p>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<spring:url value="/logout"/>"><button class="btn btn-light">Log out</button></a>
                </li>
            </sec:authorize>
            <li class="nav-item active">
                <a class="nav-link" href="${localeFr}">
                    <img class="localeIcon" alt="fr" src='<spring:url value="/images/localeFr.png"/>' />
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${localeEn}">
                    <img class="localeIcon" alt="en" src='<spring:url value="/images/localeEn.png"/>' />
                </a>
            </li>
        </ul>
    </div>
</nav>

<div>
    <tiles:insertAttribute name="main-content" />
</div>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Foodgood (Youri, Timothé)</small>
    </div>
</footer>

</body>
</html>