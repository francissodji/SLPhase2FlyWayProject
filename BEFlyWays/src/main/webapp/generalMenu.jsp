<%@page import="java.util.List" %>
<%@page import ="com.beans.Flight" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>



<body>
	<H1>ADMINISTRATOR BACK OFFICE</H1>

	<div>
		<ul><a href="<%=request.getContextPath()%>/changePw.jsp">Change your passwords</a></ul>
	</div>
	
	<div>
		<div>
			<form action="<%=request.getContextPath()%>/SourceAction" method="get">
			<label for="listSourc">Edit List of Sources :</label>
				<button type="submit" class="btn btn-primary">Edit</button>
			</form>
		</div>
		
		<div>
			<form action="<%=request.getContextPath()%>/DestinationAction" method="get">
				<label for="listDest">Edit List of Destination :</label>
				<button type="submit" class="btn btn-primary">Edit</button>
			</form>
		</div>
		
		<div>
			<form action="<%=request.getContextPath()%>/AirlinerAction" method="get">
				<label for="listAirl">Edit list of Airliners</label>
				<button type="submit" class="btn btn-primary">Edit</button>
			</form>
		</div>
		
	</div>
	
	
</body>
</html>