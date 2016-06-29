<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View a Trip</title>
</head>
<body>

${trip.name}
		<c:if test="${! empty(trip)}">
			<c:forEach var="leg" items="${trip.legsOfTrip}">
				<c:if test="${! empty(leg)}">
					<div>
						${leg.id}
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		
		<form action="toTripBuild.do" method="POST">
		<p>Add more legs to this trip</p>
		<input type="text" value="${trip.id}" name="tripId" /> 
		<input type="submit" value="Add more legs to this trip" />
		<!-- add a start date here when you figure it out -->
		</form>

		
<a href="myPage.jsp"> My profile </a>

		<h1> Search other trips </h1>
		<form action="viewSpecificTrip.do" method="GET">
			<input type="text" placeholder="city" name="city" /> 
			<input type="text" placeholder="country" name="country" />
			<input type="text" placeholder="continent" name="continent" /> 
			<input type="text" placeholder="totalTripLength" name="totalTripLength" />  
			<input type="submit" value="Search Trips" />
		</form>


</body>
</html>