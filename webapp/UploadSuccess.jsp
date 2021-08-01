<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Eportal.servlet.*, databaseConnect.*" %>
<%@ page errorPage="logOutError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Module</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="Teachers.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    
    <style>
      .success-block{
        display: flex;
        justify-content: center;
        align-items: center;
        height: 90vh;
      }

      .row
      {
       display: flex;
        /* border: 2px solid red; */
        width: 90%;
      }

      .text-box{
        /* border: 2px solid yellow; */
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }

      .img-box{
        width: 50%;
      }

      img{
        max-height: 400px;
      }

    </style>

    
</head>
<body data-bs-spy="scroll" data-bs-target="#myScrollSpy" data-bs-offset="0" tabindex="0">
	
	<%!
	String Email;
	String Tname;
	String Tcontact;
	int TuID;
	%>
	
	<%
	//Preventing back button after logout
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	

	<%
	if(session.getAttribute("Temail")==null)
	{
		response.sendRedirect("Tlogin.html");
	}
	
	//Info to show in profile
	HttpSession ses = request.getSession(false);
	Email = ses.getAttribute("Temail").toString();
	
	//POJO Object
	NavbarProfileInfo pull = new NavbarProfileInfo();
	
	//Fetching from Database
	NavbarProfileFetch obj = new NavbarProfileFetch();
	boolean flag = obj.TprofileInfoFetch(Email, pull);
	
	if(flag)
	{
		Tname = pull.getName();
		Tcontact = pull.getPNumber();
		TuID = pull.getRollNo();
	}
	
	
	%>

	 <header class="sticky-top">

        <nav>

            <div class="menu-top">
                <div id="ShowMenuBtn" class="toogle-btn">
                    <i class="fas fa-bars fa-2x" onclick="ShowMenu()"></i>
                </div>

                <div id="HideMenuBtn" class="toogle-btn hide">
                    <i class="fas fa-times-circle fa-2x" onclick="HideMenu()"></i>
                </div>
    
                <div class="menu-logo">
                    <p>SHARP</p>
                </div>
            </div>


            <div id="Menu" class="menu-side hide">

                <div class="menu-bar-top"><p class="h3">Menu</p></div>

                <div class="menu-bar-item"><a href="Thome.jsp" class="menu-bar-link"><i class="fas fa-home"></i>Home</a></div>

                <div class="menu-bar-item"><a href="TmyCourses.jsp" class="menu-bar-link"><i class="fas fa-database"></i>My Uploads</a></div>

                <div class="menu-bar-item"><a href="TuploadPg.jsp" class="menu-bar-link active"><i class="fas fa-upload"></i>Upload</a></div>

                 <div class="menu-bar-item"><a class="menu-bar-link"
                 data-bs-toggle="offcanvas" href="#offcanvasExample" aria-controls="offcanvasExample">
                        <i class="fas fa-user-circle"></i>Profile</a>
                      </a>
                      
                      <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                        <div class="offcanvas-header text-center">
                          <h5 class="offcanvas-title" id="offcanvasExampleLabel">Profile:</h5>
                          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body">
                          <div>
                            <i class="fas fa-user-circle fa-5x"></i>
                            <p class="mt-2">User name: <%= Tname%></p>
                            <p>Unique ID: <%= TuID%></p>
                            <p>Email: <%= Email%></p>
                            <p>Contact: <%= Tcontact%></p>
                          </div>
                        </div>
                      </div>
                </div>

                <div class="menu-bar-item"><a href="TClassroom.jsp" class="menu-bar-link"><i class="fas fa-tasks"></i>Manage</a></div>

                <div class="menu-bar-item">
                
                	<form action="TLogout" method="post">
                		<button type="submit" class="logout-btn"><i class="fas fa-sign-out-alt"></i>Logout</button>
                	</form>
                
                </div>

            </div>

        </nav>

    </header>
    
   <section class="success-block">
    <div class="row m-auto">

      <div class="text-box">
        <p class="display-3 text-success"><strong>Upload Success</strong></p>
        <p><strong>Your module will be live within 48 Working Hours</strong></p>
      </div>

      <div class="img-box">
        <img src="Success.jpg" alt="" class="img-fluid">
      </div>
      
    </div>
  </section>
    	
    

 <!-- JavaScript Bundle with Popper -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

   <script>

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

   </script>

   
</body>
</html>