<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start building your trip</title>
</head>
<body>

		<form action="addLeg.do" method="POST">
		<c:if test="${ empty(firstLeg)}">
			<p>What's the name of this trip?</p>
			<input type="text" placeholder="tripName" name="name" /> 
		</c:if>
			
			<p>Where do you want to go 
			
			<c:if test="${ empty(firstLeg)}">
			first?
			</c:if>
			
			<c:if test="${! empty(firstLeg)}">
			next?
			</c:if>
			</p>
			<input type="text" placeholder="city" name="city" />
			<input type="text" placeholder="country" name="country" />
			<input type="text" placeholder="continent" name="continent" />
			<p>How do you think you're going to get there?</p>
			<input type="text" placeholder="typeOfTransporation" name="typeOfTransportation" /> 
			<p>How long do you think it's going to take to get there?</p>
			<input type="text" placeholder="time" name="time" /> 
			<p>How long do you think you'll be there?</p> 
			<input type="text" placeholder="length" name="length" /> 
			<input type="submit" value="Plan the next leg of this trip" />
		</form>	
		
		<h1> Stumped? See what others did. </h1>
		
		<form action="viewSpecificTrip.do" method="GET">
			<input type="text" placeholder="city" name="city" /> 
			<input type="text" placeholder="country" name="country" />
			<input type="text" placeholder="continent" name="continent" /> 
			<input type="text" placeholder="totalTripLength" name="totalTripLength" />  
			<input type="submit" value="Search Trips" />
		</form>
				
			
<script src="apps.js"></script>
</body>
</html>