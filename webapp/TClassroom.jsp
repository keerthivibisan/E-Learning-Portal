<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, databaseConnect.*, Eportal.servlet.*" %>
<%@ page errorPage="logOutError.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage</title>

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

                <div class="menu-bar-item"><a href="TClassroom.jsp" class="menu-bar-link active"><i class="fas fa-tasks"></i>Manage</a></div>

                <div class="menu-bar-item">
                
                	<form action="TLogout" method="post">
                		<button type="submit" class="logout-btn"><i class="fas fa-sign-out-alt"></i>Logout</button>
                	</form>
                
                </div>

            </div>

        </nav>

    </header>
	
	
	<%!
	int i,j,x;
	LinkedList <Integer> CId = new LinkedList <Integer> ();
	LinkedList <String> Cname = new LinkedList <String> ();
	
	LinkedList <Integer> SId = new LinkedList <Integer> ();
	LinkedList <String> Sname = new LinkedList <String> ();
	LinkedList <String> Semail = new LinkedList <String> ();
	LinkedList <String> Scontact = new LinkedList <String> ();
	
	Integer CidArray[] = null;
	String CnameArray[] = null;
	
	Integer StuidArray[] = null;
	String StuNameArray[] = null;
	String StuEmailArray[] = null;
	String StuContactArray[] = null;
	%>
		<section class="container">
        <div class="bg-grey">
            <h5>Hello!</h5>
            <p>Here you can see the list of Students in you class room.</p>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Unde, nulla. Ea autem voluptatibus deleniti accusamus, quasi ex aliquid enim, id consequatur ipsa atque reiciendis vel nam reprehenderit temporibus fugiat? Sequi.</p>
        </div>

	<%
	//POJO
	TmyUploadsCarrier classroom = new TmyUploadsCarrier();
	
	//Getting Teachers Courses
	TmyUploadsGet courses = new TmyUploadsGet();
	
	boolean flag2 = courses.getMyUploads(TuID, classroom);
	
	if(flag2)
	{
		CId = classroom.getCId();
		Cname = classroom.getCname();
		
		CidArray = CId.toArray(new Integer[0]);
		CnameArray = Cname.toArray(new String[0]);
		//System.out.println(CnameArray[1]);
		int p = CidArray.length;
	%>
	
		<div class="container mt-4">
        	 Filter by Course:
             <select id="selectfield">
             	 <option value="All" class="text-center" selected>All</option>
     <%
     for(x = 0;x<p;x++)
     {
    	 
     %>
     			<option value=<%= CnameArray[x]%>><%= CnameArray[x]%></option> 
	
	<%
     }
	%>
	
			</select>
		</div>
		
		<div class="mt-3 card">
            <table id="tabledata" class="table">
                <tr>
                    <th>SID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Course</th>
                    <th>Course ID</th>
                </tr>
	<%
		for(i = 0; i < p; i++)
		{
			TStudentGetterDAO data = new TStudentGetterDAO();
			boolean flag3 = data.CourseStudentGet(CidArray[i], classroom);
	
			if(flag3)
			{
				SId = classroom.getSId();
				Sname = classroom.getSname();
				Semail = classroom.getSemail();
				Scontact = classroom.getScontact();
				
				StuidArray = SId.toArray(new Integer[0]);
				StuNameArray = Sname.toArray(new String[0]);
				StuEmailArray = Semail.toArray(new String[0]);
				StuContactArray = Scontact.toArray(new String[0]);
				
				int Sp = StuidArray.length;
				
				for(j=0; j<Sp; j++)
				{
				
	%>

	                <tr position= <%= CnameArray[i]%>>
	                    <td><%= StuidArray[j]%></td>
	                    <td><%= StuNameArray[j]%></td>
	                    <td><%= StuEmailArray[j]%></td>
	                    <td><%= StuContactArray[j]%></td>
	                    <td><%= CnameArray[i]%></td>
	                    <td><%= CidArray[i]%></td>
	                </tr>
                
         
	<%
				}
			}
		}
	}
	%>                
            </table>
        </div>
    </section>


     <!-- JavaScript Bundle with Popper -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

	<script src = "ContactUpdate.js"></script>
   
       <!--For UserType-->
    <script>

        $(document).ready(function(){

            function addRemoveClass(theRows){
                theRows.removeClass("odd even");
                //theRows.filter(":odd").addClass("odd");
                //theRows.filter(":even").addClass("even");
            }

            var rows = $("table#tabledata tr:not(:first-child)");

            addRemoveClass(rows);

           $("#selectfield").on("change",function(){
            var selected = this.value;

                //To check other thal all
                if(selected != "All")
                {
                    //show if position equal selected
                    rows.filter("[position="+selected+"]").show();
                    //hide other than selected
                    rows.not("[position="+selected+"]").hide();
                    var visibleRows=rows.filter("[position="+selected+"]");
                    addRemoveClass(visibleRows);
                }

                //If selected is all to show everything
                else{
                    rows.show();
                    addRemoveClass(rows);
                 }
           });
        });
    </script>
	
</body>
</html>