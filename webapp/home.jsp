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
    <title>Home</title>

    <!--BootStrap 4 CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">


    <style>
        .bs-color{
            background-color: purple;
            color: white;
        }
        
         .user-icon{
            color: lightgrey;
        }
    </style>
</head>
<body>

	<%!
	//To add in profile Navbar
	String Name;
	int RollNo;
	String Email;
	String PNumber;
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
	ses.setAttribute("GamifySupport", fetch);
	NavbarProfileFetch obj = new NavbarProfileFetch();
	obj.ProfileFetch(UEmail, fetch);
	
	Name = fetch.getName();
	RollNo = fetch.getRollNo();
	Email = fetch.getEmail();
	PNumber = fetch.getPNumber();
	%>
	
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
            <a href="/" class="navbar-brand">
                
                SHARP</a>

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
                        <a href="#" class="nav-link">Contact</a>
                    </li>
                    
                    <li class="nav-item">
                        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight"><i class="fas fa-user-circle fa-2x"></i></button>

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
                                    <p>Contact: <%= PNumber%></p>
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

    <!--Content-->
    <!--jumbotron BOOTSTRAP and font or text classes-->
    <div class="container">
        <div class="jumbotron text-center">
            <P class="display-4">Welcome</P>
            <br classs="mt-5">
            <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel quae odio consequuntur laudantium maiores. Deserunt in eligendi 
                tempora itaque magni, voluptas explicabo consectetur at ea alias, iusto incidunt, dolorum eius.</p>
        </div>
    </div>

    <!--Gamification Cards or Blog UI-->
    <div class="container">
        <div class="card">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <img src="https://images.pexels.com/photos/6532373/pexels-photo-6532373.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="gamification.jpg" class="card-img img-fluid img-responsive">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Gamification <span class="badge badge-primary">Earn a Badge</span></h5>
                        <p class="class-text">
                            <span class="badge badge-success badge-pill">Gamification</span>
                            <span class="badge bs-color badge-pill">Play & Win</span>
                        </p>
                        <p class="card-text">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Doloribus ab aliquam, cum asperiores quo, obcaecati ex nostrum libero alias quasi veniam ullam dolore at vel. Eos voluptatem dolorem aliquam necessitatibus?</p>
                    
                        <div class="clearfix"></div>
                        
                        <%
                        //Checking for already played
                        GamifyRegister play = new GamifyRegister();
                        boolean result = play.AlreadyAttended(RollNo);
                        		
                        if(result)
                        {
                        	
                        %>
                        <a href="#" class="btn btn-primary btn-block mt-2">Completed</a>
                        <%
                        }
                        
                        else
                        {
                        %>
                        
                        <a href="Gamification1.jsp" class="btn btn-primary btn-block mt-2">Play</a>
                    
                    	<%
                        }
                    	%>
                    	
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container mt-5">
        <p class="h4">Continue your Learnings:</p>

<%
MyLearnings checkCourse = new MyLearnings();
if(checkCourse.displayCourse(RollNo))
{
%>
    <!--Your Learnings Start-->
    
        <div class="card mt-4" style="width: 18rem;">
            <img src="https://techbooky.com/wp-content/uploads/2019/10/java-logo.png" alt="Java" classs="card-img-top">

            <div class="card-body">
                <h5 class="card-title">Learn JAVA</h5>
               <span class="badge badge-primary">Rating</span>
                <span class="badge badge-warning">4.8/5</span>
                <p class="card-text mt-2">Learn Java From Basics to Advanced and work on Projects with mentors Support.</p>
                <a href="JavaCourseVideo.jsp" type="button" class="btn btn-primary btn-block">Resume</a>
            </div>

            <div class="card-footer">
               <small class="text-muted">Get certified on Completion of Course</small>
            </div>
        </div>
    
<%}
else{
%>
	<p>There are no Courses to see, Enroll a Course Now</p>

<%}%>

	</div>

 <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>