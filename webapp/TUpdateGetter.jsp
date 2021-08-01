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
    <title>New Module</title>

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
    
     <section class="container mt-5">
        <div class="row">
            <div class="col-sm-6">
                <img src="202CT113.jpg" alt="" class="img-fluid">
            </div>
            <div class="col-sm-6 mt-5">
                <div class="card">
                    <div class="card-header text-center">
                        <p class="h5">Module Update</p>
                    </div>

                    <div class="card-body">
                        <form action="UpdateWriter" method="post" enctype="multipart/form-data">

                              <div class="mb-3">
                                <input type="file" class="form-control" id="floatingPassword" placeholder="Upload Here" name="Ufiles" multiple required>
                                <label for="floatingPassword">(Upload your Contents Here)</label>
                              </div>

                              <div class="">
                                  <small class="text-muted float-start">(Please don't upload new modules here)</small>
                                <button type="submit" class="btn btn-primary float-end">Update</button>
                              </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>


   <!-- JavaScript Bundle with Popper -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   
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

</body>
</html>