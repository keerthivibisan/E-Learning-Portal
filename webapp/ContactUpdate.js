//Teachers NAVBAR
function ShowMenu()
{
	document.getElementById("ShowMenuBtn").classList.add('hide');
	document.getElementById("HideMenuBtn").classList.remove('hide');
    document.getElementById("Menu").classList.remove('hide');
}

function HideMenu()
{
	document.getElementById("ShowMenuBtn").classList.remove('hide');
    document.getElementById("HideMenuBtn").classList.add('hide');
    document.getElementById("Menu").classList.add('hide');
}


//Student Update Contact
function UpdateContact()
{
	document.getElementById("updateForm").classList.remove("hide");
}

//Contact Update Feature for Teachers
function ShowUpdateBox()
{
	document.getElementById("UpdateBox").classList.remove("hide");		
}

function TUpdateContact()
{	
	let id = document.getElementById("TUID").innerText;
	
	let val = document.getElementById("contactChange").value;
	//console.log(val.length);
	if(val.length === 10)
	{
		let params = "Tid="+id+ "&num="+val;
		//Ajax request here
		let xhr = new XMLHttpRequest(); 
		
		xhr.open("POST", "TContactUpdate", true);
		
		xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
		
		xhr.onload = function()
		{
			if(this.status == 200)
			{
				if(this.responseText === "Y")
				{
					document.getElementById("UpdateBox").classList.add("hide");
					window.location.reload();
				}
			}
		}
		
		xhr.send(params);
	}
}