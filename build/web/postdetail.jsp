<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>
            ${post.title}
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
                    <div class="post--detail">
                        <br>
                        <br>
                        <div class="post--title">
                        ${post.title}
                    </div>
                    <br>
                    <br>
                    <div class="post--image">
                        <img src="img/${post.id}.jpg" alt=""/>
                    </div>
                    <br>
                    <br>
                    <div class="post--content">
                        ${post.content}
                    </div>
                    <div class="post--comment">

                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
