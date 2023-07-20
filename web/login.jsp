<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="form--background__image">
            <img src="./img/main-background.jpg" alt="alt"/>
        </div>
        <section id="login--form">
            <div class="hero-container">
                <div class="container" id="login">
                    <p class="form--title">Login</p>
                    <c:if test="${msg != null}">
                        <div class="error-message">
                            <p>${msg}</p>
                        </div>
                    </c:if>
                    <c:if test="${message != null}">
                        <div class="success-message">
                            <p>${message}</p>
                        </div>
                    </c:if>
                    <form action="login" method="post" class="form">
                        <div class="form--field">
                            <label for="email" class="form--label">Email</label>
                            <input type="text" name="email" id="email" class="form--text__input" placeholder="Username">
                        </div>
                        <div class="form--field">
                            <label for="password" class="form--label">Password</label>
                            <input type="password" name="password" id="password" class="form--text__input" placeholder="Password">
                        </div>
                        <input type="submit" value="Login" class="form--btn">
                    </form>
                    <button class="form--link__btn" onclick="toSignup()">Sign up</button>
                </div>
                <div class="container" id="signup">
                    <p class="form--title">Sign Up</p>
                    <c:if test="${msg != null}">
                        <div class="error-message">
                            <p>${msg}</p>
                        </div>
                    </c:if>
                    <form action="signup" method="post" class="form" id="signup-form">
                        <div class="form--field">
                            <label for="email" class="form--label">Email</label>
                            <input type="text" name="email" id="email" class="form--text__input" placeholder="Email">
                        </div>
                        <div class="form--field">
                            <label for="password" class="form--label">Password</label>
                            <input type="password" name="password" id="password" class="form--text__input" placeholder="Password">
                        </div>
                        <div class="form--field">
                            <label for="repassword" class="form--label">Repeat password</label>
                            <input type="password" name="repassword" id="repassword" class="form--text__input" placeholder="Repeat password">
                        </div>
                        <input type="submit" value="Sign Up" class="form--btn">
                    </form>
                    <button class="form--link__btn" onclick="toLogin()">Login</button>
                </div>
            </div>
        </section>
        <script>
            const signup = document.getElementById("signup");
            const login = document.getElementById("login");
            const toSignup = () => {
                signup.className += " switch";
                login.className += " switch";
            };
            const toLogin = () => {
                signup.className = signup.className.replace(" switch", "");
                login.className = login.className.replace(" switch", "");
            };
        </script>
    </body>
</html>
