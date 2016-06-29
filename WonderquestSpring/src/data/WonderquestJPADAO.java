package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entities.City;
import entities.Continent;
import entities.Country;
import entities.LegOfTrip;
import entities.Length;
import entities.TransportationTo;
import entities.Trip;
import entities.User;

@Component
@Transactional

public class WonderquestJPADAO implements WonderquestDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	
	// sign a user in by their username
	public User getUserByUsername(String username, String password) {
		System.out.println("username" + username + "password " + password);
		String search = "select u from User u WHERE u.username = '" + username + "'";
		User user;
		
			System.out.println("In try block");
			user = em.createQuery(search, User.class).getSingleResult();
			System.out.println("got through query" + user);
		
		return user;
	}
	
	// sign up a user
	public int addUser(String username, String password, String fname, String lname, String gender, String nationality, String emailAddress, String profImage) {
		List<User> users = getAllUsers();
		//System.out.println(users);
		for (User user : users) {
			System.out.println(user.getEmailAddress());
			//fix validation later
//			if (user.getEmailAddress().equals(emailAddress)) {
//				return 1;
//			}
//			if (user.getUsername().equals(username)) {
//				return 2;
//			}
		}
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFname(fname);
		newUser.setLname(lname);
		newUser.setGender(gender);
		newUser.setNationality(nationality);
		newUser.setEmailAddress(emailAddress);
		newUser.setProfImage(profImage);
		em.persist(newUser);
		return 0;
	}
	
	//get a list of all the users 
	public List<User> getAllUsers() {
		String search = "select u from User u";
		List<User> allUsers = em.createQuery(search, User.class).getResultList();
		return allUsers;
	}
	
	//get a trip by id 
	public Trip getTripById(int tripId) {
		Trip trip = em.find(Trip.class, tripId);
		return trip;
	}
	
	// get length of trip by description
	
	public Length getLengthByDescription(String description) {	
		Length length = em.createQuery("select l from Length l WHERE l.time_description = " + "'" + description + "'", Length.class).getSingleResult();
		return length;
	}
	
	
	// get the city for the leg of a trip, passing in country and continent 
	public City getCityForLegOfTrip(String city, String country, String continent) {
		System.out.println("IN GET CITY FOR LEG OF TRIP");
		Continent returnedContinent = em.createQuery("select c from Continent c where c.name = " + "'" + continent + "'", Continent.class).getSingleResult();
		System.out.println(returnedContinent);
		Country returnedCountry = em.createQuery("select c from Country c WHERE c.name = " + "'" + country + "' AND c.continent.id =" + returnedContinent.getId(), Country.class).getSingleResult();
		System.out.println(returnedCountry);
		City returnedCity = em.createQuery("select c from City c where c.name = " + "'" + city + "' and c.country.id =" + "'" + returnedCountry.getId() + "'", City.class).getSingleResult();
		System.out.println(returnedCity);
		return returnedCity;
	}
	
	
	//get a list of all the trips
	public List<Trip> getAllTrips() {
		String search = "select t from Trip t";
		List<Trip> allTrips = em.createQuery(search, Trip.class).getResultList();
		return allTrips;
	}
	
	//get a list of all the legs of trips
	public List<LegOfTrip> getAllLegsOfTrips() {
		String search = "select l from LegOfTrip l";
		List<LegOfTrip> allLegsOfTrips = em.createQuery(search, LegOfTrip.class).getResultList();
		return allLegsOfTrips;
	}
	
	
	// create a new trip for a user
	public Trip createTrip(String tripName, User user) {
		
		Trip newTrip = new Trip();
		newTrip.setName(tripName);
		newTrip.setUser(user);
		em.persist(newTrip);
		return newTrip;
		
	}
	
	public TransportationTo createTransportationTo(String type, String time, LegOfTrip leg) {
		System.out.println("got into the jpadao");
		System.out.println(leg);
		TransportationTo newTrans = new TransportationTo();
		newTrans.setTime(time);
		newTrans.setType(type);
		newTrans.setLegOfTrip(leg);
		System.out.println("got right before persist");
		em.persist(newTrans);
		System.out.println("got through persist");
		return newTrans;
		
	}
	
	// create a new leg of a trip for a user 
	public LegOfTrip createLeg(int tripId, City city, Length length, String description) {
		System.out.println("IN CREATE NEW LEG OF TRIP");
		System.out.println(tripId);
		System.out.println(city);
		System.out.println(length);
		System.out.println(description);
		LegOfTrip newLeg = new LegOfTrip();
		Trip trip = getTripById(tripId);
		newLeg.setTrip(trip);
		newLeg.setCity(city);
		// length doesn't seem to be persisting - detached entity problem
		newLeg.setLength(length);
		newLeg.setComplete(false);
		newLeg.setDescription(description);
		em.persist(newLeg);
		return newLeg;
	}
	
	//get all matching trips
	public List<LegOfTrip> getAllMatchingTrips(String city, String country, String continent, String lengthOfLeg) {
		List <LegOfTrip> allLegsOfTrips = getAllLegsOfTrips();
		System.out.println(city);
		System.out.println("ALL THE LEGS");
		System.out.println(allLegsOfTrips);
		List <LegOfTrip> matchingTrips = new ArrayList<>();
		System.out.println("I GET INTO THE DAO");
		for (LegOfTrip legOfTrip : allLegsOfTrips) {
			System.out.println(city);
			System.out.println(legOfTrip.getCity().getName());
			if (city.equals(legOfTrip.getCity().getName())) {
				matchingTrips.add(legOfTrip);
				System.out.println("I matched a city");
				
			}
			else if (country.equals(legOfTrip.getCity().getCountry().getName())){
				matchingTrips.add(legOfTrip);
				System.out.println("I matched a country");
				
			}
			else if (continent.equals(legOfTrip.getCity().getCountry().getContinent().getName())) {
				matchingTrips.add(legOfTrip);
				System.out.println("I matched a continent");
				
			}
			
			// something is wrong with this - you need to fix it! 
//			else if (lengthOfLeg.equals(legOfTrip.getLength().getTime_description())) {
//				matchingTrips.add(legOfTrip);
//				System.out.println("I matched a length");
//				
//			}
			else {
				LegOfTrip noleg = new LegOfTrip();
				matchingTrips.add(noleg);
				System.out.println("I didn't match anything in the list");
			}
		}
		System.out.println("MATCHING TRIPS IN THE DAO");
		System.out.println(matchingTrips);
		return matchingTrips;
		
	}
		
	

}
