let button = document.querySelector("#Pause-Play");
let video = document.getElementById("video");
let TimeBar = document.querySelector(".blue-liquid");
let VideoScreenView = document.getElementById("FullScreen");

let VideoID;


/*To Switch between Videos in Video Player*/

function ShowVideo(source, n)
{
	//console.log("in show");
	//alert("hi");
	
    video.src = source;
    VideoID = n;

	//To add Forward function or not
	//Go to DB and video seen registered there Shows forward btn
	
	let xhr = new XMLHttpRequest();
	
	xhr.open('GET',"CheckAlreadySeen?VideoId="+VideoID,true);

	xhr.onload = function()
	{
	
		if(this.status == 200)
		{
			//console.log("Called Checking...");
			let response = this.responseText;
			console.log(response);
			
			
			if(response == "true")
			{
				document.getElementById("Forward").classList.remove('hide');
				//Right key press forward
				window.onkeydown = function(event)
				{
					if(event.keyCode == 39)
                    {
                        Forward();
                    }
				}
			}
			
			else
			{
				document.getElementById("Forward").classList.add('hide');
								window.onkeydown = function(event)
				{
					if(event.keyCode == 39)
                    {
                        null;
                    }
				}
			}
		}
	}
	
	xhr.send();
}




/*These below Code Works for Current Video in the Video Player*/

/*Play && Pause Button*/
button.addEventListener("click", e=>{
    //alert("gg")

    if(video.paused)
    {
        button.classList.remove('play-btn');
        button.classList.add('pause');
        // button.className='pause';
        video.play();
    }
    else{
        // button.className='play-btn';
        button.classList.remove('pause');
        button.classList.add('play-btn');
        video.pause();
    }
})

//This Function Works when the VideoTimePosition Change
video.addEventListener('timeupdate', e=> {
    var now = video.currentTime/video.duration;

    TimeBar.style.width = now*100+"%";

    if(video.ended)
    {
        button.classList.remove('pause');
        button.classList.add('play-btn');
    }
})

VideoScreenView.addEventListener("click", e=>{

    if(video.requestFullscreen)
    {
        video.requestFullscreen();
    }

})

//----- To Pause && Play Video in FullScreen View -----
document.onkeydown = function(event)
{
    let code = event.keyCode;
    if(code == 32)   
    {
        if(video.paused)
        {
            button.classList.remove('play-btn');
            button.classList.add('pause');
            // button.className='pause';
            video.play();
        }
        else{
            // button.className='play-btn';
            button.classList.remove('pause');
            button.classList.add('play-btn');
            video.pause();
        }
    }

    else if(code == 37)
    {
        video.currentTime -= 1; 
    }
}

function rewindBack()
{
        video.currentTime -= 1;

}

function Forward()
{
    video.currentTime += 1;
}

/*---AJAX REQUESTS---*/
/*------ VIDEO Timer ------*/
function StartTimer()
{
    let runningTime;
    let total = video.duration;

   	let WatchTime = setInterval(function(){
         runningTime = video.currentTime;
         document.getElementById("runningTime").innerText = runningTime;

		if(runningTime == total)
         {
             //console.log("god");
             clearInterval(WatchTime);
             //alert(VideoID);
            
			//Sending Request to Servlet using Servlet, this works after every time after user watches a video fully
			SendRequest();		
			
			
         }
        })

    document.getElementById("TotalTime").innerText = total;
}



//----- Servlet Sending Request Function -----

function SendRequest()
{
	//xhr object
	let xhr = new XMLHttpRequest();
	
	//Opening Servlet
	xhr.open("GET","UserVideoRegister?VideoId="+VideoID, true);
	
	xhr.onload = function()
	{
		if(this.status == 200)
		{
			console.log(VideoID);
			console.log("Req Sent");
			let flag = this.responseText;
			
			if(flag == "true")
			{
				window.location.reload();
				//document.getElementById("Locked-boxes").location.reload();
			}
		}
	}
	
	//This sends request to the Servlet
	xhr.send();
}