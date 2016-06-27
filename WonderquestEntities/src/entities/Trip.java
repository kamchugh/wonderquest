package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="TRIP")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Boolean complete;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	@OneToOne(mappedBy="trip", cascade=CascadeType.ALL)
	private Length length;
	
	private String description;
	
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trip")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TripComment> tripcomments;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trip")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LegOfTrip> legsOfTrip;
	
	public Trip() {
		
	}

	


	public Trip(int id, Boolean complete, Date startDate, Date endDate, Length length, String description, int rating,
			User user, List<TripComment> tripcomments, List<LegOfTrip> legsOfTrip) {
		super();
		this.id = id;
		this.complete = complete;
		this.startDate = startDate;
		this.endDate = endDate;
		this.length = length;
		this.description = description;
		this.rating = rating;
		this.user = user;
		this.tripcomments = tripcomments;
		this.legsOfTrip = legsOfTrip;
	}

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Boolean getComplete() {
		return complete;
	}




	public void setComplete(Boolean complete) {
		this.complete = complete;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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




	public int getRating() {
		return rating;
	}




	public void setRating(int rating) {
		this.rating = rating;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public List<TripComment> getTripcomments() {
		return tripcomments;
	}




	public void setTripcomments(List<TripComment> tripcomments) {
		this.tripcomments = tripcomments;
	}




	public List<LegOfTrip> getLegsOfTrip() {
		return legsOfTrip;
	}




	public void setLegsOfTrip(List<LegOfTrip> legsOfTrip) {
		this.legsOfTrip = legsOfTrip;
	}




	@Override
	public String toString() {
		return "Trip [id=" + id + ", complete=" + complete + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", length=" + length + ", description=" + description + ", rating=" + rating + ", user=" + user
				+ ", tripcomments=" + tripcomments + ", legsOfTrip=" + legsOfTrip + "]";
	}




	

}
