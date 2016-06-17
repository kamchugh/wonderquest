<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="signIn">
	</div>
		<form action="signin.do" method="GET">
			<p>Sign in</p>
			<input type="text" placeholder="username" name="username" /> 
			<input type="text" placeholder="password" name="password" /> 
			<input type="submit" value="Sign In" />
		</form>
		<form action="signup.do" method="GET">
			<p>Sign up</p>
			<input type="text" placeholder="username" name="username" /> 
			<input type="text" placeholder="password" name="password" />
			<input type="text" placeholder="fname" name="fname" /> 
			<input type="text" placeholder="lname" name="lname" /> 
			<input type="text" placeholder="gender" name="gender" /> 
			<input type="text" placeholder="nationality" name="nationality" /> 
			<input type="text" placeholder="emailAddress" name="emailAddress" /> 
			<input type="text" placeholder="profImage" name="profImage" />  
			<input type="submit" value="Sign Up" />
		</form>
		
		<br>
			<form action="gettrips.do" method="GET">
			<input type="text" placeholder="1" name="id" /> 
			<input type="submit" value="Get Trips" />
		</form>
		
		<h3> Or search by </h3>
		
			<form action="viewSpecificTrip.do" method="GET">
			<input type="text" placeholder="city" name="city" /> 
			<input type="text" placeholder="country" name="country" />
			<input type="text" placeholder="continent" name="continent" /> 
			<input type="text" placeholder="totalTripLength" name="totalTripLength" />  
			<input type="submit" value="Search Trips" />
		</form>
		<br>
		
		<a href="buildYourTrip.do" >Or start building your own trip!</a>
		
		
		
			
			
			
			
				<c:if test="${! empty(user)}">
					
					<h3>${user.id} user id.</h3>
				</c:if>
				<c:if test="${! empty(allTrips)}">
					<c:forEach var="trip" items="${allTrips}">
						<c:if test="${! empty(trip)}">
							<div>
								${trip.description}
									<c:if test="${! empty(trip)}">
										<c:forEach var="leg" items="${trip.legsOfTrip}">
											<c:if test="${! empty(leg)}">
												<div>
													${leg.id}
											 	
												</div>
											</c:if>
										</c:forEach>
									</c:if>
							</div>
						</c:if>
					</c:forEach>
				</c:if>
<script src="apps.js"></script>
</body>
</html>