<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>
            <c:choose>
                <c:when test="${post==null}">
                    Home
                </c:when>
                <c:otherwise>
                    ${post.title}
                </c:otherwise>
            </c:choose>
        </title>
        <link href="css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="home" class="container">
            <jsp:include page="left.jsp"></jsp:include>
                <div class="line"></div>
                <div id="home--right">
                    <p class="home--right__title">VIET NAM HISTORY</p>
                <div id="post--card__list"></div>
                <div id="paging"></div>
            </div>


        </div>
        <jsp:include page="footer.jsp"></jsp:include>

            <script>
                var postList = ${postListJson};

                const paging = document.getElementById("paging");
                for (var i = 1; i <= (postList.length) / 10 + 1; i++) {
                    paging.innerHTML += "<button onclick=\"loadPage(" + i + ")\" class=\"paging--button\">" + i + "</button>";
                }

                function loadPage(page) {
                    const postCardList = document.getElementById("post--card__list");
                    postCardList.innerHTML = "" ;
                    for (var i = page * 10 - 10; i < page * 10; i++) {
                        const postCard = "<div class=\"home--right__card\">\n" +
                                "                                            <div class=\"home--card__left\">\n" +
                                "                                                <img src=\"img/" + postList[i].id + ".jpg\" alt=\"\"/>\n" +
                                "                                            </div>\n" +
                                "                                            <div class=\"home--card__right\">\n" +
                                "                                                <p class=\"card--right__title\"><a href=\"post?pi=" + postList[i].id + "\">" + postList[i].title + "</a></p>\n" +
                                "                                                <p class=\"card--right__description\">" + postList[i].description + "</p>\n" +
                                "                                            </div>\n" +
                                "                                        </div>";
                        postCardList.innerHTML += postCard;
                    }
                }

                loadPage(1);
        </script>
    </body>
</html>
