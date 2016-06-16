package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LEG_OF_TRIP")
public class LegOfTrip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "city_id")
	@ManyToOne
	private City city;
	
	private String description;
	private String TransportationTo;
	
	@JoinColumn(name = "trip_id")
	@ManyToOne
	private Trip trip;
	
	@OneToOne(mappedBy="legOfTrip", cascade=CascadeType.ALL)
	private Length length;
	
	@OneToMany(mappedBy = "legOfTrip")
	private List<Friend> friends;
	
	@OneToMany(mappedBy = "legOfTrip")
	private List<Image> images;
	
	public LegOfTrip() {
		
	}

	public LegOfTrip(int id, City city, String description, Trip trip, String TransportationTo, Length length, List<Friend> friends,
			List<Image> images) {
		super();
		this.id = id;
		this.city = city;
		this.description = description;
		this.trip = trip;
		this.length = length;
		this.friends = friends;
		this.images = images;
		this.TransportationTo = TransportationTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTransportationTo() {
		return TransportationTo;
	}

	public void setTransportationTo(String transportationTo) {
		TransportationTo = transportationTo;
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
		return "LegOfTrip [id=" + id + ", city=" + city + ", description=" + description + ", trip=" + trip
				+ ", length=" + length + ", friends=" + friends + ", images=" + images + "]";
	}
	
	

}
