<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="include/style.css" type="text/css">
<title>Arbeitsplatz</title>
</head>
<body>
<div id="header">
	<%@include file="include/header.jsp" %>
	<span id="navigation"><%@include file="include/navigation.jsp" %></span>
</div>
<div id="box_1" class="box">
	<% 
		out.println("Hallo " + request.getParameter("txtUsername") + ", Sie haben " 
	 	+ request.getAttribute("sum") + " Punkte erreicht.");
		out.println("<br><br>" + request.getAttribute("outputResult"));
	%>
</div>

<div class="box">
	<%
		out.println("The average result is: " + request.getParameter("arg0"));
	%>
</div>

</body>
</html>
