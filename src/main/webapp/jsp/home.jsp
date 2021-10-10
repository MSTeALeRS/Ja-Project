<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link href="${contextPath}/resources/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var selItem = localStorage.getItem('locales');
            $('#locales').val(selItem ? selItem : 'ua');
            $('#locales').change(function() {
                var selectedOption = $('#locales').val();
                if (selectedOption) {
                    window.location.replace('?lang=' + selectedOption);
                    localStorage.setItem('locales', selectedOption);
                }
            });
        });
    </script>
</head>
<body>
<div class="container">


    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item"><spring:message code="menu.menu"/>
            <br> <h5 class="w3-bar-item">${pageContext.request.userPrincipal.name}</h5></h3>
        <a href="/home" class="w3-bar-item w3-button"><spring:message code="menu.home"/></a>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/create-student" class="w3-bar-item w3-button"><spring:message code="menu.create"/></a>
        </security:authorize>


        <a href="/evaluations" class="w3-bar-item w3-button"><spring:message code="menu.evaluatins"/></a>
        <a href="#" class="w3-bar-item w3-button"  onclick="document.forms['logoutForm'].submit()"><spring:message code="menu.logout"/></a>
        <a href="/facultys" class="w3-bar-item w3-button">Facultys</a>
    </div>


    <!-- Page Content -->
    <div style="margin-left: 10%; ">

        <div class="w3-container" style="display:flex; justify-content: space-between; background-color: #a7e245;">
            <h1 style="display: block; width: 30%"><spring:message code="menu.students"/></h1>
            <div style="width: 30%">
                <fieldset>
                    <label><spring:message code="login.choose_language" /></label> <select
                        id="locales">
                    <option value="en"><spring:message code='login.english'/></option>
                    <option value="ua"><spring:message code='login.ukrainian'/></option>

                </select>
                </fieldset>
            </div>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
                <h2>
                    <spring:message code="menu.hello"/> ${pageContext.request.userPrincipal.name}

                </h2>
            </c:if>


            <c:if test="${not empty students}">
                <div style="display: flex; flex-direction: row; flex-wrap: wrap">
                    <c:forEach items="${students}" var="currentStudent">

                        <div class="w3-card-4" style="width: 20%; margin:2%">
                            <img
                                    src="data:image/jpg;base64, ${currentStudent.encodedImage}"
                                    alt="Norway" style="width: 100%">
                            <div class="w3-container w3-center">
                                <h3>${currentStudent.name}</h3>
                                <p>${currentStudent.surname}</p>
                                <p>${currentStudent.facultys.facultyName}</p>

                            </div>
                            <a href="/studentEvaluation/${currentStudent.id}" class="w3-button w3-block w3-dark-grey"
                            ><spring:message code="menu.evaluatin"/></a>
                        </div>

                    </c:forEach>
                </div>
            </c:if>
        </div>

    </div>


</div>
<!-- /container -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>