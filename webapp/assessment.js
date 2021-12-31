let box = document.getElementById("quiz-section");

let quiz = [
    {
        ques: "What is HTML?",
        opt: ["HTML", "CSS", "JS"],
        ans: "HTML"
    },

    {
        ques: "What is CSS?",
        opt: ["HTML", "CSS", "JS"],
        ans: "CSS"
    },

    {
        ques: "What is JS?",
        opt: ["HTML", "CSS", "JS"],
        ans: "JS"
    },

    {
        ques: "What is JAVA?",
        opt: ["HTML", "CSS", "JS","JAVA"],
        ans: "JAVA"
    }
];


function StartAssessment(q,time, form)
{
	//StartTimer(time, form, q);
    for(let i = 0; i < q.length; i++)
    {
        let div = document.createElement('div');
        box.appendChild(div);
    }

    let chilDivz = box.children;

    for(let i = 0; i < chilDivz.length; i++)
    {
        chilDivz[i].innerHTML = `${i+1}. ${q[i].ques}
                                ${q[i].opt.map(o =>{
                                    return `<input type="radio" name="${"opt"+i}" id=${i+o} value=${o} /><label for=${i+o}>${o}</label>`;
                                }).join('')}`;

    // chilDivz[i].innerHTML = quiz[i].ques+ "<br /> <p>" + quiz[i].opt;                     
    }
}

//Globalling Set Interval
let clk;
function StartTimer(time, form, q)
{
    console.log(time); 
    let clock = document.getElementById("timer");   
    
    clk = setInterval(() => 
    {
        time = time-1;
        console.log(time);
        clock.innerText = (time);

        if(time == 0)
        {
            clearInterval(clk);
            EvaluateMark(form, q);
        }
    }, 1000);
}

let mark=0;

function EvaluateMark(form, q)
{
    let frm = document.querySelector('#'+form);
    clearInterval(clk);

    for(let i = 0; i < q.length; i++)
    {
        //console.log(q);
        // console.log(div[i].children);
        let input = document.getElementsByName("opt"+i);
        input.forEach(a => {
            if(a.checked)
            {
               let answer= q[i].ans;
                let selected = a.value;
            
                if(selected === answer)
                {
                    mark += 1;
                }
            }
        })
    }

    if(mark >= (q.length/2))
    {
        RegisterMark(form);
    }

    else
    {
        document.getElementById(form).classList.add('hidden');
        document.getElementById("testBtn").classList.add('hidden');
        let markBox = document.getElementById("mark-display");
        markBox.classList.remove('hidden');
        markBox.innerText = mark+" / "+(q.length)+" (You must score atleast 50%)";
    }
}


//This connects with BACKEND
function RegisterMark(form)
{
    document.getElementById(form).classList.add('hidden');
    document.getElementById("testBtn").classList.add('hidden');
    console.log(document.getElementById("testBtn"));
    let markBox = document.getElementById("mark-display");
    markBox.classList.remove('hidden');
    markBox.innerText = mark+" Mark --> Passed the Assessment :) Claim your certificate.";

    //Ajax Request to Servlet Here
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "StuMarkRegister?mark="+mark,"true");
	
	xhr.onload = function()
	{
		if(this.status == 200)
		{
			location.reload();
		}
	}
	
	xhr.send();
	
}


