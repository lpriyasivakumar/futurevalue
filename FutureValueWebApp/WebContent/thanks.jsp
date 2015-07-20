<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Calculator Results:</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body > 
 <section>
	<h1>${message}</h1>	
	<p>The future value of investment amount of ${fv.amount} dollars in ${fv.years} year(s) is : 
	${fv.futureValue}.</p>
 </section>
</body>
</html>