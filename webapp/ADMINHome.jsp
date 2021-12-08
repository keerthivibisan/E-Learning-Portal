<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sharp - Admin</title>

    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <style>
      .nav-ele-hover:hover, .activate{
        font-size: 1.5rem;
        transition: all 0.3s;
      }
    </style>
  </head>
  <body>
    
    <%
  	//Preventing back button after logout
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  	response.setHeader("Pragma", "no-cache");
  	response.setHeader("Expires", "0");
  	
    	if(session.getAttribute("AEmail") == null)
    	{
    		response.sendRedirect("AdminLogin.html");
    	}
    %>
    
    <header class="navbar navbar-light sticky-top bg-light flex-md-nowrap p-3 shadow">

        <button class="navbar-toggler  d-md-none me-5 collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <img src = "./clgLogo.jpg" alt = "clgLogo" width = "20%"/>
        
        <div class="navbar-nav">
          <div class="nav-item text-nowrap">
            <form action = "AdminLogout" method="post">
            	<button type="submit" class="btn btn-outline-dark">Signout</button>
            </form>
          </div>
        </div>
      </header>
      
      <div class="container-fluid">
        <div class="row">
          <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse bg-dark" style="height: 95vh;">
            <div class="position-sticky pt-3">
              <ul class="nav flex-column">
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link activate" aria-current="page" href="ADMINHome.jsp">
                    Home
                  </a>
                </li>
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="ADMINStudents.jsp">
                    Student's
                  </a>
                </li>
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminTeachers.jsp">
                    
                    Teacher's
                  </a>
                </li>

                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminCourses.jsp">    
                    Courses
                  </a>
                </li>

                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminStuCourseRegister.jsp">
                    
                    Course Register
                  </a>
                </li>
                
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminCourseView.jsp">
                    Course Store
                  </a>
                </li>
                
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminStudentCourseVideoSee.jsp">
                    Student's Vseen
                  </a>
                </li>
               
              </ul>
            </div>
          </nav>
      
           <div class="container col-md-9 d-flex align-items-center justify-content-center">
            <img src="Admin.png" alt="" class="img-fluid" width="500">
          </div>
          
        </div>
      </div>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
  </body>
</html>
