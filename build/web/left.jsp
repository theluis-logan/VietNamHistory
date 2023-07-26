<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="home--left">

    <div id="category">
        <p class="home--left__title">CATEGORY</p>
        <c:forEach items="${cateList}" var="cate">
            <div class="category--button ${cid == cate.id ? "actived" : ""}">
                <a href="category?ci=${cate.id}">${cate.name}</a>
            </div>
        </c:forEach>
    </div>
    <c:if test="${sessionScope.account != null}">
        <div id="ranking">
            <p class="home--left__title">CURRENT RANKING</p>
            <c:forEach items="${accList}" var="o">
                <div class="ranking--user">
                    <p class="ranking--user__current">${o.rank}.</p>
                    <p class="ranking--user__name">${o.username}</p>
                    <p class="ranking--user__score">${o.score}</p>
                </div>
                <div class="ranking--line"></div>
            </c:forEach>
        </div>
    </c:if>
</div>