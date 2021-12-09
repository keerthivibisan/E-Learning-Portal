<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="databaseConnect.*, Eportal.servlet.*, java.util.LinkedList"%>

<%@ page errorPage="logOutError.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>

      <!--BootStrap 4 CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
	<link rel="stylesheet" href="ePortal.css">

	<style>
	  .user-icon{
            color: lightgrey;
        }
        
		 .hide{
        	display: none;
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
	
	//Fetching UserEmail from verify Servlet to take User info from Database and Display in Profile
	HttpSession ses = request.getSession(false);
	String UEmail = ses.getAttribute("useremail").toString();

	NavbarProfileInfo fetch = new NavbarProfileInfo();
	
	NavbarProfileFetch obj = new NavbarProfileFetch();
	obj.ProfileFetch(UEmail, fetch);
	
	Name = fetch.getName();
	RollNo = fetch.getRollNo();
	Email = fetch.getEmail();
	PNumber = fetch.getPNumber();
	%>
	
    <header>
        <nav class="navbar navbar-expand-lg navbar-light shadow">
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

    <!--Course above-->
    <div class="container my-3">
        <div>
            <h5>Featured Courses:</h5>
        </div>
    </div>
    
    <!-- Fetching available courses from database -->
    <div class = "container">
    
    <%
    	LinkedList <Integer> id = new LinkedList <Integer>();
    	LinkedList <String> img = new LinkedList <String>();
    	LinkedList <String> Cname = new LinkedList <String>();
    	LinkedList <String> desc = new LinkedList <String>();
    	LinkedList <String> jsp = new LinkedList <String>();
    	LinkedList <String> status = new LinkedList <String>();
    	
    	Integer ID [] = null;
    	String imgurl [] = null;
    	String cname [] = null;
    	String dsc [] = null;
    	String JSP [] = null;
    	String stat [] = null;
    	
    	CoursePagePojo carry = new CoursePagePojo();
    	CoursePgDao  getDetails = new CoursePgDao();
    	getDetails.GetAllCourses(carry);
    	
    	id = carry.getId();
    	img = carry.getImg();
    	Cname = carry.getCname();
    	desc = carry.getDesc();
    	jsp = carry.getJsp();
    	status = carry.getStatus();
    	
    	ID = id.toArray(new Integer[0]);
    	imgurl = img.toArray(new String[0]);
    	cname = Cname.toArray(new String[0]);
    	dsc = desc.toArray(new String[0]);
    	JSP = jsp.toArray(new String[0]);
    	stat = status.toArray(new String[0]);
    	
    	int p = ID.length;
    	
    	for(int i = 0; i < p; i++)
    	{
    		if(stat[i].equalsIgnoreCase("Active"))
    		{
    %>
    	<div class="card mb-3" style="width: 80%; margin: 0 auto; position:relative;">
		  <div class="row g-0">
		    <div class="col-md-4">
		      <img src="<%=imgurl[i]%>" class="img-fluid rounded-start" alt="courseImg">
		    </div>
		    <div class="col-md-8">
		      <div class="card-body">
		        <h5 class="card-title"><%=cname[i]%></h5>
		        <p class="card-text"><%=dsc[i]%></p>
		        <!-- a href="CourseRegister.jsp" class = "btn btn-primary float-end" style="position: absolute; bottom: 1em; right: 1em;">Enroll Now</a-->
		        
		        <form action="CreateHttpSession" method="post" style="position: absolute; bottom: 1em; right: 1em;">
		        	<input type="submit" class="btn btn-primary" value="Enroll Now"/>
		        	<input type="text" value=<%= cname[i]%> name="cname" hidden/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
    <%
    		}
    	}
    %>
    
    </div>

 <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<script src = "ContactUpdate.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>