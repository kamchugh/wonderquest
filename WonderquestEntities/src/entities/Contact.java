package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")

public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String emailAddress;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Contact() {
		
	}
	
	public Contact(int id, String fname, String lname, String emailAddress, User user) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.emailAddress = emailAddress;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", fname=" + fname + ", lname=" + lname + ", emailAddress=" + emailAddress
				+ ", user=" + user + "]";
	}
	

}
