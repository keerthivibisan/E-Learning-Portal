<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gamification Check 1</title>
<link rel="stylesheet" href="gamify.css">
</head>
<body>

	<section id="quiz_set" class="quiz-gamification">
        <div id="all-quiz">
            <div id="rules" class="rules">
                <h3>Rules for Quiz:</h3>
                <p>1. You cannot get back to a question, Once done is done.</p>
                <p>2. Each questions carry 2 points.</p>
                <p>3. You will Earn a badge if you score 60%.</p>
            </div>
    
            <form id="gamification" class="gamification_1" name="gamification_1" autocomplete="off">
    
                <a href="#question1" id="start-btn" onclick="ShowQuestion1()">START</a>
    
                <div id="question1" class="hide">
                    <p>1.HTML stands for?</p>
                    <label><input type="radio" name="question1" value="correct">Hyper Text Markup Language</label><br>
                    <label><input type="radio" name="question1" value="0">High Text Machine Language</label><br>
                    <label><input type="radio" name="question1" value="0">Hyper Text and links Markup Language</label><br>
                    <label><input type="radio" name="question1" value="0">None of these</label><br>
    
                    <a href="#question2" onclick="ShowQuestion2()">next</a>
                </div>
    
                
                <div id="question2" class="hide">
                    <p>2.The correct sequence of HTML tags for starting a webpage is?</p>
                    <label><input type="radio" name="question2" value="0">Head, Title, HTML, body</label><br>
                    <label><input type="radio" name="question2" value="0">HTML, Body, Title, Head</label><br>
                    <label><input type="radio" name="question2" value="correct">HTML, Head, Title, Body</label><br>
                    <label><input type="radio" name="question2" value="0">HTML, Head,Body,Title</label><br>
    
                    <a href="#question3" onclick="ShowQuestion3()">next</a>
                </div>
    
                
                <div id="question3" class="hide">
                    <p>3.How to create an unordered list (a list with the list items in bullets) in HTML?</p>
                    <label><input type="radio" name="question3" value="0">ol</label><br>
                    <label><input type="radio" name="question3" value="0">li</label><br>
                    <label><input type="radio" name="question3" value="0">i</label><br>
                    <label><input type="radio" name="question3" value="correct">ul</label><br>
    
                    <a href="#question4" onclick="ShowQuestion4()">next</a>
                </div>
    
                
                <div id="question4" class="hide">
                    <p>4.Which of the following element is responsible for making the text bold in HTML?</p>
                    <label><input type="radio" name="question4" value="correct">b</label><br>
                    <label><input type="radio" name="question4" value="0">pre</label><br>
                    <label><input type="radio" name="question4" value="0">a</label><br>
                    <label><input type="radio" name="question4" value="0">br</label><br>
    
                    <a href="#question5" onclick="ShowQuestion5()">next</a>
                </div>
    
                
                <div id="question5" class="hide">
                    <label>5.How to create a hyperlink in HTML?</p>
                    <p><input type="radio" name="question5" value="0">a link = "www.google.com" google.com /a </label><br>
                    <label><input type="radio" name="question5" value="0">a url = "www.google.com" google.com /a</label><br>
                    <label><input type="radio" name="question5" value="correct">a href = "www.google.com"> google.com /a</label><br>
                    <label><input type="radio" name="question5" value="0">a www.google.com google.com /a</label><br>
                </div>
    
                </div>
                <p id="quiz-submit" onclick="validateQuiz()" class="hide">Submit</p>
            </form>
        </div>
        
        <div id="result_set" class="hide">
            <p id="result_mark"></p>
            <a href="home.jsp">Home</a>
        </div>
    </section>
    


    <script src="gamify.js"></script>

</body>
</html>