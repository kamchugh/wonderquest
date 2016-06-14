package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CITY")

public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy = "city")
	private List<LegOfTrip> legsOfTrips;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	public City() {
		
	}

	public City(int id, String name, String description, String imageUrl, List<LegOfTrip> legsOfTrips,
			Country country) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.legsOfTrips = legsOfTrips;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<LegOfTrip> getLegsOfTrips() {
		return legsOfTrips;
	}

	public void setLegsOfTrips(List<LegOfTrip> legsOfTrips) {
		this.legsOfTrips = legsOfTrips;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", legsOfTrips=" + legsOfTrips + ", country=" + country + "]";
	}
	
	
}
