<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="databaseConnect.*, Eportal.servlet.*" %>

<%@ page errorPage="logOutError.jsp" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JAVA</title>

	<!--BootStrap 4 CDN-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	 <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
	
	
	<link rel="stylesheet" href="videoLessonPage.css">
	
	<style>
		 .hide{
        	display: none;
        }
	</style>
	
</head>
<body>

	<div class="loader">
        <div class="spinner-border text-primary" role="status">
          <span class="visually-hidden h3">Loading...</span>
        </div>
    </div>
	

	
	<%!
	//To add in profile Navbar
	String Name;
	int RollNo;
	String Email;
	String PNumber;
	String CourseName = "Java";
	%>
	
	<%
	//Preventing back button after logout
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	
	<%
	//if not login redirecting to login
	if(session.getAttribute("useremail")==null) {
		
		response.sendRedirect("login.jsp");
		
	}
	
	//Fetching UserEmail from verify Servlet to take Database to collect user info
	HttpSession ses = request.getSession(false);
	String UEmail = ses.getAttribute("useremail").toString();

	NavbarProfileInfo fetch = new NavbarProfileInfo();
	ses.setAttribute("UserDetails", fetch);
	ses.setAttribute("CourseName", CourseName);
	
	NavbarProfileFetch obj = new NavbarProfileFetch();
	obj.ProfileFetch(UEmail, fetch);
	
	Name = fetch.getName();
	RollNo = fetch.getRollNo();
	Email = fetch.getEmail();
	PNumber = fetch.getPNumber();
	%>
	
    <header>
        <nav class="navbar navbar-expand-lg navbar-light shadow mb-4">
            <div class="container">
           <img src = "./clgLogo.jpg" alt="image" width = "20%"/>

            <!--Toggle button class-->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavBar" aria-controls="myNavBar"
            aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="myNavBar">
                <!--ml-auto margin left auto-->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a href="home.jsp" class="nav-link">Home</a>
                    </li>

                    <li class="nav-item">
                        <a href="course.jsp" class="nav-link">Courses</a>
                    </li>

                    <li class="nav-item">
                        <a href="about.jsp" class="nav-link">About</a>
                    </li>

                    
                    <li class="nav-item">
                        <button class="btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight"><i class="fas fa-user-circle fa-2x"></i></button>

                        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                            <div class="offcanvas-header">
                                <h5 id="offcanvasRightLabel">PROFILE</h5>
                                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                            </div>
                            <div class="offcanvas-body text-center d-flex align-items-center justify-content-center flex-column">
                               
                                <p class="h4">User Details</p>
                                <div>
                                     <p>
                                        <i class="fas fa-user-circle fa-5x user-icon"></i>
                                    </p>

                                    <p>Name: <%= Name%></p>
                                    <p>RollNo: <%= RollNo%></p>
                                    <p>Email: <%= Email%></p>
                                    <p>Contact: <%= PNumber%> <i class="fas fa-edit" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Edit" onclick="UpdateContact()"></i></p>
                                	<form id="updateForm" action = "UpdateContact" method="post" class="hide">
                                		<input type="text" name="Contact" placeholder="10 - Digit Contact Number" pattern="[0-9]{10}" required>
                                		<input type ="text" name="Uemail" value = <%= Email%> hidden>
                                		<button type = "submit" class="btn btn-primary btn-sm">Update</button>
                                	</form>
                                </div>
                               
                            </div>
                        </div>
                    </li>
                    
                     <li  class="nav-item">
                        <form action="logout" method="get">
                            <button type="submit" class="btn nav-link"><i class="fas fa-sign-out-alt fa-2x"></i></button>
                        </form>
                    </li>
                    
                    

                </ul>
            </div>
            </div>
        </nav>
    </header>
	
	<!-- ***** VIDEO Features ***** -->
	    <div class="content row-Flex">
        <!--Side Lessons SHOWCASE-->
        <div id="Locked-boxes" class="lesson-boxes card">
            <div class="box">
                <p class="active" onclick="ShowVideo('Courses/JAVA/sample2.mp4','JavaV1')">Lesson 1</p>
            </div>
            <div class="box">
                <p onclick="ShowVideo('Courses/JAVA/sample.mp4','JavaV2')">Lesson 2</p>
             <%
             	//If user saw before video unlocks next
             	StudentVideoRegister check = new StudentVideoRegister();
             	boolean flag = check.AlreadySaw(RollNo, "JavaV1");
             	
             	if(flag == false)
             	{
             		
             %>
                <div class="box-lock"><i class="fas fa-lock"></i></div>
                
             <%
             	}
             %>
            </div>
            <div class="box">
                <p>Lesson 3</p>
                <div class="box-lock"><i class="fas fa-lock"></i></div>
            </div>

            <div class="box">
                <p>Lesson 4</p>
                <div class="box-lock"><i class="fas fa-lock"></i></div>
            </div>

            <div class="box">
                <p>Lesson 5</p>
                <div class="box-lock"><i class="fas fa-lock"></i></div>
            </div>
        </div>

        <!--Video Player-->
        <div class="video-c mt-3">

            <div class="videoWITHControl">

                <video id = "video" src="http://clips.vorwaerts-gmbh.de/VfE_html5.mp4" class="video" onplay="StartTimer()"></video>

                <div class="controls">
                    <div class="blue">
                        <div class="blue-liquid"></div>
                    </div>

                    <div class="video-buttons">
                        <div class="row-Flex">
                        
                            <div id="Pause-Play" class="play-btn marging-left"></div>
                            <div id="RewindBack" class="rewindBack-btn marging-left" onclick="rewindBack()"></div>
                       		<div id="Forward" class="Forward-btn marging-left hide" onclick="Forward()"></div>
                        
                        </div>
                        
                        <div id="FullScreen" class="fullScreen-btn"></div>
                    </div>

                </div>

            </div>
            
            <div class="watch-timer">
                <p class="h5 text-muted"><i class="fas fa-stopwatch text-warning"></i> Watch Time</p>
                <p><span id="runningTime"  class="text-success">0.00</span> / <span id="TotalTime" class="text-danger">0.00</span></p>
                <small class="text-muted">(Watch this lesson fully to Unlock next)</small>
            </div>
    
            <!-- <div class="system-info">
                <h5>Note: </h5>
                <ul>
                    <li>You can Forward or Skip the videos.</li>
                    <li>you will be able to next video only after watching this Lesson fully.</li>
                </ul>
            </div> -->
        </div>

    </div>

   <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <script src="VideoPlayer.js"></script>
    <script src = "ContactUpdate.js"></script>
    <script>

        let loader = document.querySelector(".loader");
        window.addEventListener("load", vanish);
    
        function vanish()
        {
            loader.classList.add('disappear');
        }
    
    
    </script>
</body>
</html>