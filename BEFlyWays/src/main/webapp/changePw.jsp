<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
	  	<h1>Login Form</h1>
		  <form action="<%=request.getContextPath()%>/ChangePassword" method="post">
		  
			   <div class="form-group">
				    <label for="uname">New Password</label> <input type="text"
				    
				     class="form-control" id="password" placeholder="Password" name="aPassword" required>
			   </div>
			   
			   <div class="form-group">
				    <label for="uname">Confirmed Password:</label> <input type="password"
				    
				     class="form-control" id="password" placeholder="Confirmed Password" name="confPassword" required>
			   </div>
			   
			   <div>
			   		<button type="submit" class="btn btn-primary">Submit</button>
			   </div>
		   
		  </form>
	 </div>
 
</body>
</html>