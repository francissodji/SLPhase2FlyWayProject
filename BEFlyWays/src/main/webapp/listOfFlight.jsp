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

	<div>
			<table border=1>
		
				<tr>
					<th>Flight Number</th>
					<!--<th>Date </th>-->
					<th>Capacity</th>
					<th>Airliner</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Price</th>
					
				</tr>
				
				<% 

					List<Flight> aListOfAllFlight = (List<Flight>)session.getAttribute("ALLFLIGHTSPERDAY");

					for(Flight aflight : aListOfAllFlight)
					{
						
				%>
						<tr>
							<td><%=aflight.getNumFlight()%></td>
							<!--<td><%=aflight.getDateFligth()%></td>-->
							<td><%=aflight.getTotPassengFligth()%></td>
							<td><%=aflight.getAirliner()%></td>
							<td><%=aflight.getSource()%></td>
							<td><%=aflight.getDestination()%></td>
							<td><%=aflight.getTicket()%></td>
						</tr>
				<%		
					}
				%>
			</table>
	</div>
</body>

</html>