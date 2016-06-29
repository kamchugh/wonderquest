<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
</head>
<body>

${user.profImage} Hi there, ${user.fname}.
<br> 
Your basic info : 
username : ${user.username}
fname : ${user.fname}
lname : ${user.lname}
gender : ${user.gender}
nationality : ${user.nationality}
emailAddress : ${user.emailAddress}

<br> 

Trips you've planned so far : 

		<c:forEach var="trip" items="${user.trips}">
			<c:if test="${! empty(trip)}">
				<div>
					Name : ${trip.name}
					Complete : ${trip.complete}
					Start date : ${trip.startDate}
					rating : ${trip.rating}
					<br>
					<form action="viewTrip.do" method="GET">
					<input type="text" value="${trip.id}" name="tripId" /> 
					<input type="submit" value="View or edit this trip" />
					</form>
					<br>
				</div>
			</c:if>
		</c:forEach>



</body>
</html>