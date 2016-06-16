package data;

import java.util.List;

import entities.Trip;
import entities.User;

public interface WonderquestDAO {

	public User getUserByUsername(String username, String password);
	public int addUser(String username, String password, String fname, String lname, String gender, String nationality, String emailAddress, String profImage);
	public List<User> getAllUsers();
	public List<Trip> getAllTrips();
}
