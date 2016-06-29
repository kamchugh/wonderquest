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

@Entity
@Table(name="LEG_OF_TRIP")
public class LegOfTrip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Boolean complete;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@JoinColumn(name = "city_id")
	@ManyToOne
	private City city;
	
	private String description;
	
	
	@JoinColumn(name = "trip_id")
	@ManyToOne
	private Trip trip;
	
	@JoinColumn(name = "length_id")
	@OneToOne
	(mappedBy="legOfTrip", cascade=CascadeType.MERGE)
	private Length length;
	
	@OneToMany(mappedBy = "legOfTrip")
	private List<LegOfTripComment> legOfTripComment;
	
	@OneToMany(mappedBy = "legOfTrip")
	private List<TransportationTo> transportationTo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "legOfTrip")
	private List<Friend> friends;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "legOfTrip")
	private List<Image> images;
	
	public LegOfTrip() {
		
	}

	

	public LegOfTrip(int id, Boolean complete, City city, String description, String transportationTo, Trip trip,
			Length length, List<Friend> friends, List<Image> images) {
		super();
		this.id = id;
		this.complete = complete;
		this.city = city;
		this.description = description;
		
		this.trip = trip;
		this.length = length;
		this.friends = friends;
		this.images = images;
	}
	


	public Boolean isComplete() {
		return complete;
	}



	public void setComplete(Boolean complete) {
		this.complete = complete;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "LegOfTrip [id=" + id + ", city=" + city + ", description=" + description 
				+ ", length=" + length + ", friends=" + friends + ", images=" + images + "]";
	}
	
	

}
