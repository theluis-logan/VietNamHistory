<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header id="header">
    <div class="container">
        <div class="header--left">
            <ul class="nav--menu">
                <li class="nav--menu__item"><a href="home" class="nav--menu__link">Home</a></li>
                    <c:if test="${sessionScope.account != null}">
                    <li class="nav--menu__item"><a href="quiz" class="nav--menu__link">Quiz</a></li>
                    </c:if>
                    <c:if test="${sessionScope.account.role > 1}">
                    <li class="nav--menu__item"><a href="addPost.jsp" class="nav--menu__link">Add Post</a></li>
                    </c:if>
                    <c:if test="${sessionScope.account.role > 2}">
                    <li class="nav--menu__item"><a href="quiz" class="nav--menu__link">Dashboard</a></li>
                    </c:if>
            </ul>
        </div>
        <div class="header--right">
            <ul class="user--menu">
                <li class="user--menu__item">
                    <a href="#" class="user--menu__link">
                        <div class="user--img__block">
                            <img src="img/clone-avt.jpg" alt="alt" class="user--img">
                        </div>
                        <div class="username--block">
                            <c:choose>
                                <c:when test="${sessionScope.account!=null}">
                                    <p class="username">${sessionScope.account.username}</p>
                                </c:when>
                                <c:otherwise>
                                    <p class="username">Guest</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.account == null}">
                        <li class="user--menu__item">
                            <a href="login.jsp" class="user--menu__link">
                                Login
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="user--menu__item">
                            <a href="logout?accId=${sessionScope.account.id}" class="user--menu__link">
                                Sign out
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</header>