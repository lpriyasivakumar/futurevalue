<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Future Value Calculator Application</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <section>
            <h1>Future Value Calculator</h1>
            <label style= "font-style:italic; color:red;font-family:serif">${error_message}</label>
            <form action="displayResults" method="post">
            	<img src="images/calc.jpg" alt="Calculator"/>
            	<h1>Welcome to the Future Value Calculator!</h1>
            	<label>Enter the following Information:</label><br> <br>
            	
                <label>Monthly Investment Amount:</label>				
                <input type="text" name="investment" placeholder="Enter Investment Amount"
                       value=""/><br><br>
                 <label>Interest Rate per annum (Compounded monthly): </label>
                 <input type="text" name="rate" placeholder="Enter Interest Rate"
                       value=""/><br><br>
                 <label>Number of years:</label>                 
                 <select name="years">
					<option value=1>One</option>
					<option value=2>Two</option>
					<option value=3>Three</option>					
					<option value=4>Four</option>
				</select>
				<br><br>				               
				<input type="submit" value="Calculate" id="submit">
				<br>
            </form>
        </section>
    </body>
</html>