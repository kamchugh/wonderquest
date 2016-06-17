package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LEG_OF_TRIP_COMMENT")
public class LegOfTripComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String body;
	
	@JoinColumn(name = "legOfTrip_id")
	@ManyToOne
	private LegOfTrip legOfTrip;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	public LegOfTripComment() {
		
	}

	public LegOfTripComment(int id, Date date, String body, LegOfTrip legOfTrip, User user) {
		super();
		this.id = id;
		this.date = date;
		this.body = body;
		this.legOfTrip = legOfTrip;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LegOfTrip getLegOfTrip() {
		return legOfTrip;
	}

	public void setLegOfTrip(LegOfTrip legOfTrip) {
		this.legOfTrip = legOfTrip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LegOfTripComment [id=" + id + ", date=" + date + ", body=" + body + "]";
	}
	
	
	
	
	
	
	

}
