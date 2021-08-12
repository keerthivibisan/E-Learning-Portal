
function validateQuiz(){

    console.log("hii");
    let mark_scored = 0;

    let q1 = document.gamification_1.question1.value;
    let q2 = document.gamification_1.question2.value;
    let q3 = document.gamification_1.question3.value;
    let q4 = document.gamification_1.question4.value;
    let q5 = document.gamification_1.question5.value;


    if(q1=="correct"){
        mark_scored++;
    }

    if(q2=="correct"){
        mark_scored++;
    }

    if(q3=="correct"){
        mark_scored++;
    }

    if(q4=="correct"){
        mark_scored++;
    }

    if(q5=="correct"){
        mark_scored++;
    }

    document.getElementById("all-quiz").classList.add('hide');
    document.getElementById("quiz-submit").classList.add('hide');
    document.getElementById("result_set").classList.remove('hide');
    document.getElementById("result_mark").innerText="Your Score: "+mark_scored;

	let xhr = new XMLHttpRequest();
	xhr.open("GET","GamifySupport?Score="+mark_scored,true);
	
	console.log(xhr.status);
	
	xhr.onload = function()
	{
		if(this.status == 200)
		{
			console.log("in");
			let Restext = this.responseText;
			
			if(Restext == "AlreadyWritten")
			{
				document.getElementById("result_mark").innerText="You have Already attended the Quiz";
			}
		}
	}
	
	xhr.send();
}
    
   


/*Seperate Functions for calling next Questions*/

function ShowQuestion1() {
    document.getElementById("question1").classList.remove('hide');
    document.getElementById("rules").classList.add('hide');
    document.getElementById("start-btn").classList.add('hide');
}


function ShowQuestion2() {
    document.getElementById("question2").classList.remove('hide');
    document.getElementById("question1").classList.add('hide');
}

function ShowQuestion3() {
    document.getElementById("question3").classList.remove('hide');
    document.getElementById("question2").classList.add('hide');
}

function ShowQuestion4() {
    document.getElementById("question4").classList.remove('hide');
    document.getElementById("question3").classList.add('hide');
}

function ShowQuestion5() {
    // document.getElementById("question5").classList.remove('hide');
    // document.getElementById("question4").classList.add('hide');
    document.getElementById("question5").classList.remove('hide');
    document.getElementById("quiz-submit").classList.remove('hide');
    document.getElementById("question4").classList.add('hide');
}

