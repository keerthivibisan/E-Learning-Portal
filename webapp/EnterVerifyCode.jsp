<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
		<style>
		@media(max-width: 700px)
		{
			.no-mobile{
				visiblity: hidden;
				display: none;
			}
		}
	</style>
	
</head>
<body>
	
	<div class="bg-primary text-center text-white mb-3 p-1" style= "height: fit-content">
		<p class="h2">SHARP</p>
	</div>
	
	<section class="row">
    	<div class="col-sm-1 no-mobile"></div>
    	<div class="col-sm-4 no-mobile"><img src="studentLoginR.jpg" alt="image" class="img-fluid"></div>
    	
    	<div class="col-sm-7">
    		<div class="container">
		        <div class="card">
		            <div class="text-center card-header"><p class="h5">Code Sent to Your Email</p></div>
		            <div class="card-body">
		                <form action="VerifyCode" method="post">
		                    <div class="form-floating mb-3">
		                          <input type="text" class="form-control" name="verificationCode" id="floatingInput" placeholder="6-Digit Code">
		                          <label for="floatingInput">6-Digit Code</label>
		                    </div>
		                    <button type="submit" class="btn btn-primary">Verify</button>
		                </form>
		            </div>
		        </div>
    		</div>
    	</div>
    </section>
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>	
</body>
</html>