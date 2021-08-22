<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "databaseConnect.*, Eportal.servlet.*, java.util.LinkedList" %>
<%@ page errorPage="logOutError.jsp" %>
<%@ page import="java.io.File"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyCourses</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="Teachers.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"> 
	
		<style>

    .loader{
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        backgroung-color: white;
    }

    .disappear{
        animation: fadeaway 0.7s forwards;
    }

    @keyframes fadeaway{
        100%{
            opacity: 0;
            visibility: hidden;
        }
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
	
	<div class="loader">
      <div class="spinner-border text-primary" role="status">
          <span class="visually-hidden">Loading...</span>
       </div>
    </div>

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

                <div class="menu-bar-item"><a href="TmyCourses.jsp" class="menu-bar-link active"><i class="fas fa-database"></i>My Uploads</a></div>

                <div class="menu-bar-item"><a href="TuploadPg.jsp" class="menu-bar-link"><i class="fas fa-upload"></i>Upload</a></div>

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
    <%!
    LinkedList <Integer> CID = new LinkedList <Integer> ();
	LinkedList <String> Cname = new LinkedList <String> ();
	LinkedList <String> Cpath = new LinkedList <String> ();
	Integer Cid[] = null;
	String Cnm [] = null;
	String Fpath [] = null;
	int i;
	String Filepath;
    %>
    
    <div class="container">
    	<div class="d-flex align-items-center justify-content-center flex-column">
        	<img src="MyUploads.png" alt="" class="img-fluid" style="width: 450px;">
      	</div>
      <P class="h4 mb-3">My Modules: </P>
    
    <%
    TmyUploadsGet get = new TmyUploadsGet();
    TmyUploadsCarrier mycourse = new TmyUploadsCarrier();
    
    if(get.getMyUploads(TuID,mycourse))
    {
    	CID = mycourse.getCId();
    	Cname = mycourse.getCname();
    	Cpath = mycourse.getCpath();
    	
    	//Converting LinkedLists into Array
    	Integer Cid[] = CID.toArray(new Integer[0]);
    	String Cnm [] = Cname.toArray(new String[0]);
    	String Fpath [] = Cpath.toArray(new String[0]);
    	
    	int p = Cid.length;
    	//System.out.print("Length: "+p);
    	for(i = 0; i<p; i++)
    	{
    %>
    
			<div class="card mb-3">
				<div class="row g-0">
          			<div class="col-md-4">
            			<img src="ePortal.png" class="img-fluid rounded-start" alt="...">
          			</div>
          			<div class="col-md-8">        		
            			<div class="card-body">
             			 	<h5 class="card-title">Name: <%= Cnm[i]%></h5>
              				<p class="card-text">UID: <%= Cid[i]%></p>
            				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut eum ipsum sunt laborum eos vero minima magni sapiente omnis debitis. Vero incidunt mollitia omnis suscipit nisi fugiat sunt dignissimos! Voluptas?</p>
             				<!-- p class="h5">What you have uploaded in this Module:</p -->
             				
             				<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target= <%= "#offcanvasRigh"+Cnm[i]%> aria-controls="offcanvasRight">Show More</button>
             				<div class="offcanvas offcanvas-end" tabindex="-1" id=<%= "offcanvasRigh"+Cnm[i]%> aria-labelledby="offcanvasRightLabel">	
             				<div class="offcanvas-header">
                  				<h5 id="offcanvasRightLabel">You have Uploaded</h5>
                  				<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">		
    	<%
		File fobj = new File(Fpath[i]);
		boolean exist = fobj.exists();
	
		if(exist)
		{
			File fileitems[] = fobj.listFiles();
		
			for(File item: fileitems)
			{
				String Fname = item.getName();
				int dot = Fname.lastIndexOf(".");
				String str = Fname.substring(dot+1);

				if(str.equals("mp4"))
				{
					String path = item.getAbsolutePath();
					int z = path.indexOf("Courses");
					//System.out.println(i);
					String relativePath = path.substring(z);
					Filepath = relativePath.replace('\\','/');
					//Filepath = "Courses\\JAVA(5)\\sample2.mp4";
					System.out.println(Filepath);
		%>
				<video src=<%= Filepath%> type="video/mp4" class="img-fluid mt-1" controls autoplay width="300">Not Supported Format</video>
	
		<%
			}
			
			else if(str.equals("jpg") || str.equals("jpeg") || str.equals("png"))
			{
				String path = item.getAbsolutePath();
				int z = path.indexOf("Courses");
				String relativePath = path.substring(z);
				Filepath = relativePath.replace('\\','/');
				System.out.println(Filepath );
		%>
				<img src= <%= Filepath%> class="img-fluid" alt="Your Upload" width="300">
	
	<%
			}
	%>
			
	<%
		}
	%>
								</div>
							</div>
	<%
	}
	%>
             			
             			
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