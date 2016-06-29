package data;

import java.util.List;

import entities.City;
import entities.LegOfTrip;
import entities.Length;
import entities.TransportationTo;
import entities.Trip;
import entities.User;

public interface WonderquestDAO {

	public User getUserByUsername(String username, String password);
	public int addUser(String username, String password, String fname, String lname, String gender, String nationality, String emailAddress, String profImage);
	public List<User> getAllUsers();
	public List<Trip> getAllTrips();
	public List<LegOfTrip> getAllMatchingTrips(String city, String country, String continent, String lengthOfLeg);
	public List<LegOfTrip> getAllLegsOfTrips();
	public Trip createTrip(String tripName, User user);
	public LegOfTrip createLeg(int tripId, City city, Length length, String description);
	public Trip getTripById(int tripId);
	public Length getLengthByDescription(String description);
	public City getCityForLegOfTrip(String city, String country, String continent);
	public TransportationTo createTransportationTo(String type, String time, LegOfTrip leg);
}
