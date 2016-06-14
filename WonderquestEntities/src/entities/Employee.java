package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String position;
	private Boolean isAdmin;
	// foreign key
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Employee() {
		
	}

	public Employee(int id, String position, Boolean isAdmin, User user) {
		super();
		this.id = id;
		this.position = position;
		this.isAdmin = isAdmin;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", position=" + position + ", isAdmin=" + isAdmin + ", user=" + user + "]";
	}
	

}
