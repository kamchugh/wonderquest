package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FRIEND")
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	String username;
	
	@JoinColumn(name = "leg_of_trip_id")
	@ManyToOne
	private LegOfTrip legOfTrip;
	
	public Friend() {
		
	}

	public Friend(int id, String username, LegOfTrip legOfTrip) {
		super();
		this.id = id;
		this.username = username;
		this.legOfTrip = legOfTrip;
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

	public LegOfTrip getLegOfTrip() {
		return legOfTrip;
	}

	public void setLegOfTrip(LegOfTrip legOfTrip) {
		this.legOfTrip = legOfTrip;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", username=" + username + ", legOfTrip=" + legOfTrip + "]";
	}
	

}
