<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="include/style.css" type="text/css">
<title>Arbeitsplatz</title>
</head>
<body>
<div class="header">
	<%@include file="include/header.jsp" %>
	<span class="navigation"><%@include file="include/navigation.jsp" %></span>
</div>
<div class="box">
	<% 
		out.println("Hallo " + request.getParameter("txtUsername") + ", Sie haben " 
	 	+ request.getAttribute("sum") + " Punkte erreicht.");
		out.println("<br><br>" + request.getAttribute("outputResult"));
	%>
</div>
<div class="box">
		<% 	
		out.println("<br><br>Die durchschnittlich erreichte Punkteanzahl " +
				"liegt bei " + request.getAttribute("average") + " Punkten.");
	  %>
</div>



</body>
</html>
