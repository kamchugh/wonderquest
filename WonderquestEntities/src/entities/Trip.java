package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRIP")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@OneToOne(mappedBy="trip", cascade=CascadeType.ALL)
	private Length length;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Trip() {
		
	}

	public Trip(int id, Length length, String description, User user) {
		super();
		this.id = id;
		this.length = length;
		this.description = description;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", length=" + length + ", description=" + description + "]";
	}

}
