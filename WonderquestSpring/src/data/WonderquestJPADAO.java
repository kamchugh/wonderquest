package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entities.LegOfTrip;
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
