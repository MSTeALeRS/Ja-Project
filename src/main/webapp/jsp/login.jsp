<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Create an account</title>
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
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
<body >

<section class="forms-section">
    <div>
        <fieldset>
            <label><spring:message code="login.choose_language" /></label> <select
                id="locales">
            <option value="en"><spring:message code='login.english'/></option>
            <option value="ua"><spring:message code='login.ukrainian'/></option>

        </select>
        </fieldset>
    </div>
    <h2 class="form-heading"><spring:message code="login.title"/></h2>
    <div class="forms">
        <div class="form-wrapper is-active">
            <button  type="button" class="switcher switcher-login">
                <spring:message code='login.signin'/>
                <span class="underline"></span>
            </button>
            <form method="POST" action="${contextPath}/login" class="form form-login">

                <fieldset>
                    <legend>Please, enter your email and password for login.</legend>
                    <div class="input-block">
                        <label ><spring:message code='login.email'/></label>
                        <input name="email" type="text" class="form-control"
                               autofocus="true"/>
                    </div>
                    <div class="input-block">
                        <label ><spring:message code='login.password'/></label>
                        <input name="password" type="password" class="form-control"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </fieldset>
                <button class="btn-login" type="submit"><spring:message code='login.signin'/></button>
            </form>
        </div>
        <div class="form-wrapper is-pasive">
            <button type="button" class="switcher switcher-signup">
                <spring:message code='login.create_account'/>
                <span class="underline"></span>
            </button>




<form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data" class="form form-signup">
                <fieldset>
                    <legend>Please, enter your email, password and password confirmation for sign up.</legend>
    <div class="input-block">
    <label > <spring:message code='create.firstName'/></label>
    <input type="text" name="firstName" />
    </div>
    <div class="input-block">
    <label ><spring:message code='create.lastName'/></label>
    <input type="text" name="lastName" />
    </div>
                    <div class="input-block">
                        <label ><spring:message code='login.email'/></label>
    <input type="text" name="email" />
                    </div>
                    <div class="input-block">
                        <label ><spring:message code='login.password'/></label>
    <input type="text" name="password" />
                    </div>
                    <div class="input-block">
                        <label><spring:message code='create.confirmPasword'/></label>
    <input type="text" name="passwordConfirm" />
                    </div>
                </fieldset>
                <button type="submit" class="btn-signup"><spring:message code='create.continue'/> </button>


</form:form>
        </div>
    </div>

</section>

<script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>


</body>
</html>
