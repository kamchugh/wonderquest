package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String gender;
	private String nationality;
	private String emailAddress;
	private String profImage;
	
	@OneToMany(mappedBy = "user")
	private List<Interest> interests;
	
	@OneToMany(mappedBy = "user")
	private List<Contact> contacts;
	
	@OneToMany(mappedBy = "user")
	private List<Trip> trips;
	
	@OneToOne(mappedBy = "user")
	private Employee employee;
	
	public User() {
		
	}

	public User(int id, String username, String password, String fname, String lname, String gender, String nationality,
			String emailAddress, String profImage, List<Interest> interests, List<Contact> contacts, List<Trip> trips,
			Employee employee) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.nationality = nationality;
		this.emailAddress = emailAddress;
		this.profImage = profImage;
		this.interests = interests;
		this.contacts = contacts;
		this.trips = trips;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProfImage() {
		return profImage;
	}

	public void setProfImage(String profImage) {
		this.profImage = profImage;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", gender=" + gender + ", nationality=" + nationality + ", emailAddress=" + emailAddress
				+ ", profImage=" + profImage + ", interests=" + interests + ", contacts=" + contacts + ", trips="
				+ trips + ", employee=" + employee + "]";
	}	

}
