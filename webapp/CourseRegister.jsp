<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="databaseConnect.*, Eportal.servlet.*" %>

<%@ page errorPage="logOutError.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Register-Course</title>
     <!--BootStrap 4 CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>

	<%!
	//To add in profile Navbar
	String Name;
	int RollNo;
	String Email;
	String PNumber;
	
	//COURSE Details
	String CourseName = "JAVA";
	int CourseUID;
	String teacherName;
	String Temail;
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
	
	//Fetching UserEmail from verify Servlet to take User info from Database and Display in Profile
	HttpSession ses = request.getSession(false);
	String UEmail = ses.getAttribute("useremail").toString();

	NavbarProfileInfo fetch = new NavbarProfileInfo();
	
	//Setting Course name
	fetch.setCourseName(CourseName);
	
	//Profile
	NavbarProfileFetch obj = new NavbarProfileFetch();
	obj.ProfileFetch(UEmail, fetch);
	
	//Course Details
	CourseInfoFetch obj2 = new CourseInfoFetch();
	obj2.CourseDetails(CourseName, fetch);
	
	//Profile
	Name = fetch.getName();
	RollNo = fetch.getRollNo();
	Email = fetch.getEmail();
	PNumber = fetch.getPNumber();
	
	//Course
	CourseUID = fetch.getCourseUID();
	teacherName = fetch.getTeacherName();
	Temail = fetch.getTemail();
	
	//Giving fetch Object to EnrollServlet
	HttpSession enroll = request.getSession();
	enroll.setAttribute("AllInfoObject",fetch);
	%>
	
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
            <a href="/" class="navbar-brand">
                SHARP
            </a>

            <!--Toggle button class-->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavBar" aria-controls="myNavBar"
            aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="myNavBar">
                <!--ml-auto margin left auto-->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a href="home.jsp" class="nav-link">Home</a>
                    </li>

                    <li class="nav-item active">
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
	
	   <main>
        <div class="container py-4">

          <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
              <h1 class="display-5 fw-bold">Java Programming Course</h1>
              <p class="col-md-8 fs-4">Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi eligendi odio rem alias officia quisquam ut in quas dignissimos obcaecati magni eum quo architecto, vero voluptas corporis praesentium! Quia, ipsam?</p>
            </div>
          </div>
      
          <div class="row align-items-md-stretch">
            <div class="col-md-6">
              <div class="h-100 p-5 text-white bg-dark rounded-3">
                <h2>Your Details</h2>
                <p>Name: <%= Name%></p>
                <p>RollNo: <%= RollNo%></p>
                <p>Email: <%= Email%></p>
                
                <p>(The above Details will be Enrolled in the Course)</p>
                <!-- <button class="btn btn-outline-light" type="button">Example button</button> -->
              </div>
            </div>
            <div class="col-md-6">
              <div class="h-100 p-5 bg-light border rounded-3">
              <h2>Confirm Registration:</h2>
              
              <div class="row">
              	<div class="col-sm-5">
              		<p>Course Name: <%= CourseName%></p>
              	</div>
              	
              	<div class="col-sm-7">
              		<p>Course UID: <%= CourseUID%></p>
              	</div>
              </div>
              
              <div class="row">
              	<div class="col-sm-5">
              		 <p>Mentor: <%= teacherName%></p>
              	</div>
              	
              	<div class="col-sm-7">
              		<p>Email: <%= Temail%></p>
              	</div>
              </div>
              
              <div class="row">
              	<div class="col-sm-5">
              		 <p>Price: Free</p>
              	</div>
              	
              	<div class="col-sm-7">
              		
              	</div>
              </div>
                
              <div class="row">
              	<div class="col-sm-5">
              		
              	</div>
              	
              	<div class="col-sm-7">
              	
              	<form action="EnrollCourse" method="post">
              		<button class="btn btn-outline-secondary btn-block" type="submit">Enroll Now</button>
              	</form>
              		
              	</div>
              </div>
            
              </div>
            </div>
          </div>
      
          <footer class="pt-3 mt-4 text-muted border-top">
            &copy; 2021
          </footer>
        </div>
      </main>

	<!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	

</body>
</html>