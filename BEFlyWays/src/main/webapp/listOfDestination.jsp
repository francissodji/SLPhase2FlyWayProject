<%@page import="com.beans.Destination" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H1>List of Destination</H1>
	<div>
		<table border=1>
	
			<tr>
				<th>Description</th>
				
			</tr>
			
			<% 
				
				List<Destination> destinatList = (List<Destination>)session.getAttribute("ALLDESTINATION"); 
	
	
				for(Destination aDestin : destinatList)
				{
			%>
					<tr>
						<td><%=aDestin.getDesignDestination()%></td>
	
					</tr>
			<%		
				}
			%>
		</table>
	</div>
	
	<div>
		<a href="#">Back to Administrator back office</a>
	</div>
</body>
</html>