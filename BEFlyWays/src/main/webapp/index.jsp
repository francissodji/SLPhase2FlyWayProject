<%@page import="java.util.List" %>
<%@page import ="com.beans.Airliner" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
 
</head>


<body>
<h1>General Menu</h1>


<div>
	<div>
		
		<form action="<%=request.getContextPath()%>/AirlinerAction" method="get">
			<div class="form-group">
			    <label for="dateSearch">Search by date</label>
			    <input type="date" name="searchFlightDate">
			    <button type="submit" class="btn btn-primary">Submit</button>
		   </div>
		  
		</form>
	</div>
	
	<br/>
	
	<div>
		
		<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		  	<h1>Administrator Only</h1>
		  	
		  	<h3>Connect to Administrator back office</h3>
			  <form action="<%=request.getContextPath()%>/UserLogin" method="post">
				   <div class="form-group">
				    <label for="uname">User Name:</label> <input type="text"
				     class="form-control" id="username" placeholder="User Name" name="aUsername" required>
				   </div>
				   
				   <div class="form-group">
				    <label for="uname">Password:</label> <input type="password"
				     class="form-control" id="password" placeholder="Password" name="aPassword" required>
				   </div>
			   		<button type="submit" class="btn btn-primary">Submit</button>
			  </form>
		 </div>
	</div>
<div>	
	
	
	
</body>
</html>