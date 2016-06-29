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
		<c:if test="${ empty(trip)}">
		
		<form action="createTrip.do" method="POST">
		<p>What's the name of this trip?</p>
		<input type="text" placeholder="tripName" name="tripName" /> 
		<input type="submit" value="Start planning this trip" />
		<!-- add a start date here when you figure it out -->
		</form>
		
		</c:if>
		<c:if test="${! empty(trip)}">
		<h1> Let's get started on ${trip.name}!</h1>
		<h4> Here's your trip so far </h4>
			<c:if test="${! empty(passedTrip)}">
				<c:forEach var="leg" items="${passedTrip.legsOfTrip}">
				
					<c:if test="${! empty(leg)}">
						<div>
							Leg : ${leg.id}
							<form action="editLeg.do" method="POST">
							<input type="hidden" value="${leg.id}" name="legId" /> 
							<input type="submit" value="Edit this leg" />
							<!-- add a start date here when you figure it out -->
							</form>
						</div>
					</c:if>
				</c:forEach>
			</c:if>												
		<form action="addLeg.do" method="POST">	
			<p>Where do you want to go 	
			<c:if test="${ empty(leg)}">
			first?
			</c:if>	
			<c:if test="${! empty(leg)}">
			next?
			</c:if>
			</p>
			<input type="text" placeholder="${trip.id}" name="tripId" />
			<input type="text" placeholder="city" name="city" />
			<input type="text" placeholder="country" name="country" />
			<input type="text" placeholder="continent" name="continent" />
			<p>How do you think you're going to get there?</p>
			<input type="text" placeholder="typeOfTransporation" name="typeOfTransportation" /> 
			<p>How long do you think it's going to take to get there?</p>
			<input type="text" placeholder="time" name="time" /> 
			<p>How long do you think you'll be there?</p> 
			<input type="text" placeholder="length" name="length" /> 
			<p>Any notes you want to leave for yourself on what you might do?</p> 
			<input type="text" placeholder="description" name="description" /> 
			<input type="submit" value="Plan the next leg of this trip" />
		</form>	
		</c:if>
		
		
		<c:if test="${! empty(trip)}">
		<a href="myPage.jsp"> I'm done planning this trip for now. Take me to my page! </a>
		</c:if>
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