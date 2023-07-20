<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
        <link href="css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <link href="css/quiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="quiz" class="container">

            <jsp:include page="left.jsp"></jsp:include>
                <div class ="right">
                    <p class="quiz--right__title">QUIZ</p>
                    <form id="test--start" method="post">
                        <div class="form--field">
                            <p class="form--text">This quiz will give you randomly quiz of Viet Nam History</p>
                            <label for="numOfQuestion" class="form--label">Enter number of questions: </label>
                            <input type="number" name="numOfQuestion" id="numOfQuestion" class="form--input" >
                        </div>

                        <br>
                        <button type="button" class="form--btn" onclick="loadQuiz()">Start attempt</button>
                    </form>
                    <div id="form--test">
                        <button id="submit--btn" class="form--btn" type="button" onclick="submitAllForm()">Finish attempt</button>
                    </div>
                </div>
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
                            const button = document.getElementById("submit--btn");
                            button.style.display = "none";
                            function loadQuiz() {
                                const num = document.getElementById("numOfQuestion").value;
                                if (!num) {
                                    const testForm = document.getElementById("form--test");
                                    alert("Please enter number of questions you want to do.");
                                    return;
                                }
                                const startTest = document.getElementById("test--start");
                                startTest.style.display = "none";
                                document.getElementById("submit--btn").style.display = "inline";
                                $.ajax({
                                    type: "GET",
                                    url: "/VNH/loadQuiz",
                                    data: {
                                        numOfQuestion: num
                                    },
                                    success: function (data) {
                                        const testForm = document.getElementById("form--test");
                                        testForm.innerHTML = data + testForm.innerHTML;
                                    },
                                    error: function (xhr, status, error) {
                                        // Handle errors, if any
                                        console.error(error);
                                    }
                                });
                            }

                            function submitAllForm() {
                                const num = document.getElementsByClassName("form--test__card").length;
                                button.style.display = "none";
                                let score = 0;
                                let count = 0;
                                for (var i = 1; i <= num; i++) {
                                    var correct = document.getElementById(i).qa;
                                    var ans = document.querySelectorAll(`input:checked`);
                                    console.log(ans);
                                    if (ans === null) {
                                        alert("Please select answer for all question");
                                        return;
                                    }
                                    if (correct === ans.value) {
                                        score += 5;
                                        count++;
                                    }
                                }
                                const testForm = document.getElementById("form--test");
                                testForm.innerHTML += "You answer correct " + count + "/" + num + " questions. Your score is: " + score;

//                                $.ajax({
//                                    type: "GET",
//                                    url: "/VNH/updateScore",
//                                    data: {
//                                        numOfQuestion: num
//                                    },
//                                    success: function (data) {
//                                        const testForm = document.getElementById("form--test");
//                                        testForm.innerHTML = data + testForm.innerHTML;
//                                    },
//                                    error: function (xhr, status, error) {
//                                        // Handle errors, if any
//                                        console.error(error);
//                                    }
//                                });
                            }
            </script>
        </div>
    </body>
</html>
