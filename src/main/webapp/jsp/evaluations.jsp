<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Evaluations</title>
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
        <h3 class="w3-bar-item"><spring:message code="menu.menu"/> </h3>
        <a href="/home" class="w3-bar-item w3-button"><spring:message code="menu.home"/></a>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/create-student" class="w3-bar-item w3-button"><spring:message code="menu.create"/></a>
        </security:authorize>


        <a href="/evaluations" class="w3-bar-item w3-button"><spring:message code="menu.evaluatins"/></a>
        <a href="#" class="w3-bar-item w3-button"  onclick="document.forms['logoutForm'].submit()"><spring:message code="menu.logout"/></a>
    </div>


    <!-- Page Content -->
    <div style="margin-left: 10%">

        <div class="w3-container w3-teal" style="display:flex; justify-content: space-between">
            <h1 style="display: block; width: 30%"><spring:message code="menu.evaluatins"/></h1>
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

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Faculty</th>
                        <th scope="col">English</th>
                        <th scope="col">Anatomy</th>
                        <th scope="col">Biology</th>
                        <th scope="col">Phisic</th>
                        <th scope="col">Chemestry</th>
                        <th scope="col">SumBall</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${students}" var="students">
                        <tr>
                            <th scope="row">${students.id}</th>
                            <td>${students.name}</td>
                            <td>${students.faculty}</td>
                            <td>${students.evaluation.english}</td>
                            <td>${students.evaluation.anatomy}</td>
                            <td>${students.evaluation.biology}</td>
                            <td>${students.evaluation.phisic}</td>
                            <td>${students.evaluation.chemestry}</td>
                            <td>${students.evaluation.sumBall}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


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