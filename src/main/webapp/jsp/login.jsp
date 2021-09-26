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

</head>
<body >
<section class="forms-section">
    <h1 id="p2" class="section-title">Hello</h1>
    <div class="forms">
        <div class="form-wrapper is-active">
            <button type="button" class="switcher switcher-login">
                Login
                <span class="underline"></span>
            </button>
            <form method="POST" action="${contextPath}/login" class="form form-login">

                <fieldset>
                    <legend>Please, enter your email and password for login.</legend>
                    <div class="input-block">
                        <label >E-mail</label>
                        <input name="email" type="text" class="form-control" placeholder="Email"
                               autofocus="true"/>
                    </div>
                    <div class="input-block">
                        <label >Password</label>
                        <input name="password" type="password" class="form-control" placeholder="Password"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </fieldset>
                <button class="btn-login" type="submit">LogIn</button>
            </form>
        </div>
        <div class="form-wrapper">
            <button type="button" class="switcher switcher-signup">
                Sign Up
                <span class="underline"></span>
            </button>




<form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data" class="form form-signup">
                <fieldset>
                    <legend>Please, enter your email, password and password confirmation for sign up.</legend>
    <div class="input-block">
    <label >First name</label>
    <input type="text" name="firstName" />
    </div>
    <div class="input-block">
    <label >Last Name</label>
    <input type="text" name="lastName" />
    </div>
                    <div class="input-block">
                        <label >E-mail</label>
    <input type="text" name="email" />
                    </div>
                    <div class="input-block">
                        <label >Password</label>
    <input type="text" name="password" />
                    </div>
                    <div class="input-block">
                        <label>Confirm password</label>
    <input type="text" name="passwordConfirm" />
                    </div>
                </fieldset>
                <button type="submit" class="btn-signup">Continue</button>


</form:form>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
