<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Eportal.servlet.*, databaseConnect.*" %>
<%@ page errorPage="logOutError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uploads</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="Teachers.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"> 

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
                            <p>Unique ID: <p id = "TUID"><%= TuID%></p></p>
                            <p>Email: <%= Email%></p>
                            <p>Contact: <%= Tcontact%> <i onClick = "ShowUpdateBox()" class="fas fa-edit text-dark"></i></p>
                            <div id = "UpdateBox" class = "hide">
                            	<input type = "number" id = "contactChange" placeholder = "10 - Digit Number"/>
                            	<button onClick = "TUpdateContact()" class = "btn btn-primary btn-sm"><i class="fas fa-check text-light"></i></button>
                            	</div>
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
    
     <section class="container mt-4 upload-contents">
        <article class="bg-grey">
            <h3>Hello!</h3>
            <p>Here you can upload your Course Videos and more.</p>
            <p>Read this before you Upload:</p>
            <ol>
                <li><p>If you are going to upload a new course or new module you should upload in -><a href="TnewFileUpload.jsp">New Module upload page</a><-</p></li>
                <li><p>If you are going to update or upload a video for existing course or module that you have already uploaded you should upload it in -><a href="TExistingUpdate.jsp">Existing module update</a><-</p></li>
            </ol>
        </article>

        <div class="form-contents">

            <div class="upload-card-deck">

                <div  class="upload-card">
                    <a href="TnewFileUpload.jsp" class="text-center">
                        <p class="badge bg-orchid">New</p>
                        <p class="upload-card-text"><span class="text-success">Click here</span> to Upload new modules</p>
                        <p class="badge bg-success rounded-pill">Upload</p>
                    </a>
                </div>
    
                <div  class="upload-card">
                    <a href="TExistingUpdate.jsp" class="text-center">
                        <p class="badge bg-tangerine">Existing</p>
                        <p class="upload-card-text"><span class="text-primary">Click here</span> to Update your modules</p>
                        <p class="badge bg-primary rounded-pill">Update</p>
                    </a>
                </div>
    
            </div>

            <div>
                <img src="TuploadPage1.jpg" alt="" class="img-fluid img-upload">
            </div>
            
        </div>
    </section>


    <!-- JavaScript Bundle with Popper -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<script src = "ContactUpdate.js"></script>

   
</body>
</html>

</body>
</html>