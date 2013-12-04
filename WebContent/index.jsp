<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="include/style.css" type="text/css" />
<title>Arbeitsplatz</title>
</head>
<body>
<div id="header">
	<%@include file="include/header.jsp" %>
	<span id="navigation"><%@include file="include/navigation.jsp" %></span>
</div>
<div id="container">
<h3> Wie gesund ist mein Arbeitsplatz?</h3>

<p>Brennen Ihre Augen, schmerzt der R&uuml;cken nach einem Tag im B&uuml;ro? 
Dann muss vielleicht ein neuer Sessel oder eine Bildschirmarbeits-Brille her.</p>

<p>Machen Sie den Test! Kreuzen Sie an, was auf Sie zutrifft, 
und z&auml;hlen Sie am Ende die erreichten Punkte zusammen.</p>

<p>
1 = trifft kaum zu<br>
2 = trifft zum Teil zu<br>
3 = trifft voll zu
</p>
 

<form action="myController" method="post">

	Bitte geben Sie Ihren Namen ein: <input type="text" name="txtUsername" /><br> 
	
	<p>
	<input type="radio" name="question_1" value="1" />1
	<input type="radio" name="question_1" value="2" />2
	<input type="radio" name="question_1" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Ich kann gen&uuml;gend Pausen von der Bildschirmschirmarbeit machen.
	</p>
		
	<p>
	<input type="radio" name="question_2" value="1" />1
	<input type="radio" name="question_2" value="2" />2
	<input type="radio" name="question_2" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Mein Arbeitsplatz ist ausreichend beleuchtet, gel&uuml;ftet und temperiert.
	</p>
	
	<p>
	<input type="radio" name="question_3" value="1" />1
	<input type="radio" name="question_3" value="2" />2
	<input type="radio" name="question_3" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Ich arbeite in einer rauchfreien Umgebung.
	</p>
	
	<p>
	<input type="radio" name="question_4" value="1" />1
	<input type="radio" name="question_4" value="2" />2
	<input type="radio" name="question_4" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	An meinem Arbeitsplatz herrscht Ruhe, ich kann mich somit gut konzentrieren.
	</p>
	
	<p>
	<input type="radio" name="question_5" value="1" />1
	<input type="radio" name="question_5" value="2" />2
	<input type="radio" name="question_5" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Ich kann w&auml;hrend der Arbeit Pausen machen, um mich gut zu erholen.
	</p>
	
	<p>
	<input type="radio" name="question_6" value="1" />1
	<input type="radio" name="question_6" value="2" />2
	<input type="radio" name="question_6" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Ich habe in meiner Firma die M&ouml;glichkeit, einen Arbeitsmediziner zu kontaktieren.
	</p>
	
	
	<p>
	<input type="radio" name="question_7" value="1" />1
	<input type="radio" name="question_7" value="2" />2
	<input type="radio" name="question_7" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Meine Firma bietet gesundheitsf&ouml;rdernde Ma&szlig;nahmen an.
	 </p>
	
	<p>
	<input type="radio" name="question_8" value="1" />1
	<input type="radio" name="question_8" value="2" />2
	<input type="radio" name="question_8" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	An meinem Arbeitsplatz schaue ich nicht dauernd auf die Uhr, bis der Tag vergeht.
	</p>
	
	<p>
	<input type="radio" name="question_9" value="1" />1
	<input type="radio" name="question_9" value="2" />2
	<input type="radio" name="question_9" value="3" />3
	&nbsp;&nbsp;&nbsp;&nbsp;
	Wenn ich meinen Arbeitsplatz verlasse, f&uuml;hle ich mich noch fit.
	</p>
	
	<input type="submit" value="click it" />
</form>
</div>
</body>
</html>