<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link type="text/css" href="<spring:url value='/css/first.css' />"
          rel="Stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr" />
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en" />
    </spring:url>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">FoodHype</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Sign up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/authenticated"/>">Sign in</a>
            </li>
        </ul>
        <div>
            <a href="${localeFr}">
                <img class="localeIcon" alt="fr" src='<spring:url value="/images/localeFr.png"/>' />
            </a>
            <a href="${localeEn}">
                <img class="localeIcon" alt="en" src='<spring:url value="/images/localeEn.png"/>' />
            </a>
        </div>
    </div>
</nav>

<sec:authorize access="isAuthenticated()">

    <a href="<spring:url value="/logout"/>">Log out</a>

    <form:form method="POST" action="logout">
        <input type="submit" value="Log out"/>
    </form:form>

</sec:authorize>


<div>
    <tiles:insertAttribute name="main-content" />
</div>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Your Website</small>
    </div>
</footer>
</body>
</html>