package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
		
	

}
