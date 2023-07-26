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

                    </div>
                    <div id="test--msg"></div>
                    <button id="submit--btn" class="form--btn" type="button" onclick="submitAllForm()">Finish attempt</button>
                    <button id="reattempt--btn" class="form--btn" type="button" onclick="newTest()">Attempt new quiz</button>
                </div>

                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
                            const startbutton = document.getElementById("submit--btn");
                            startbutton.style.display = "none";
                            document.getElementById("reattempt--btn").style.display = "none";
                            var questionList;
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
                                    datatype: "json",
                                    success: function (data) {
                                        questionList = data;
                                        const form = document.getElementById("form--test");
                                        data.forEach((item) => {
                                            const formQuestion = document.createElement("form");
                                            formQuestion.id = item.id;
                                            formQuestion.className = "form--test__card";
                                            const q = document.createElement("p");
                                            q.className = "test--card__question";
                                            q.innerHTML = item.question;

                                            formQuestion.appendChild(q);
                                            formQuestion.appendChild(createAnswer(item.answerA, item.id, 1));
                                            formQuestion.appendChild(createAnswer(item.answerB, item.id, 2));
                                            formQuestion.appendChild(createAnswer(item.answerC, item.id, 3));
                                            formQuestion.appendChild(createAnswer(item.answerD, item.id, 4));

                                            form.appendChild(formQuestion);
                                        });
                                    },
                                    error: function (xhr, status, error) {
                                        // Handle errors, if any
                                        console.error(error);
                                    }
                                });
                            }

                            const createAnswer = (item, id, num) => {
                                const div = document.createElement("div");
                                div.className = "test--card__answer";

                                const input = document.createElement("input");
                                input.id = "ans" + num + id;
                                input.name = id;
                                input.type = "radio";
                                input.value = num;

                                const label = "<label for=\"" + input.id + "\" class=\"test--card__label\">" + item + "</label>";
                                div.appendChild(input);
                                div.innerHTML += label;
                                return div;
                            };

                            function checkQuestion(id, ans) {
                                questionList.forEach((item) => {
                                    if (item.id == id) {
                                        return item.correct == ans;
                                    }
                                });
                            }

                            function submitAllForm() {
                                const testForm = [...document.getElementsByClassName("form--test__card")];
                                var userScore = 0;
                                testForm.forEach((item) => {
                                    const userChoice = document.querySelector("input[name=\"" + item.id + "\"]:checked");
                                    if (userChoice != null) {
                                        questionList.forEach((_item) => {
                                            if (_item.id == item.id) {
                                                if (_item.correct == userChoice.value)
                                                    userScore += 5;
                                            }
                                        });
                                    }
                                });
                                document.getElementById("reattempt--btn").style.display = "inline";
                                document.getElementById("submit--btn").style.display = "none";
                                const userId = ${sessionScope.account.id};
                                const newScore = ${sessionScope.account.score} + userScore ; 
                                $.ajax({
                                    type: "POST",
                                    url: "/VNH/updateScore",
                                    data: {
                                        accountId : userId,
                                        accountScore : newScore
                                    },
                                    success: function (data) {
                                        document.getElementById("test--msg").innerHTML = "<p>You have "+userScore/5+"/"+questionList.length+" correct answers. Your score: "+userScore+"</p><p>"+data+"</p>" ;
                                    },
                                    error: function (xhr, status, error) {
                                        // Handle errors, if any
                                        console.error(error);
                                    }
                                });
                            }
                            
                            function newTest(){
                                document.getElementById("form--test").innerHTML = "" ;
                                const startTest = document.getElementById("test--start");
                                startTest.style.display = "block";
                                document.getElementById("reattempt--btn").style.display = "none";
                                document.getElementById("test--msg").innerHTML = "" ;
                            }
                </script>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
