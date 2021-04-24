<%@page import="java.util.List" %>
<%@page import="com.beans.Source" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<H1>List of Sources</H1>
	
	<div>
		<table border=1>
	
			<tr>
				<th>Description</th>
				
			</tr>
			
			<% 
				
				List<Source> sourceList = (List<Source>)session.getAttribute("ALLSOURCE"); 
	
				for(Source asource : sourceList)
				{
			%>
					<tr>
						<td><%=asource.getDesignSource()%></td>
	
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