package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
	private List<City> cities;
	
	@ManyToOne
	@JoinColumn(name = "continent_id")
	private Continent continent;
	
	public Country() {
		
	}

	public Country(int id, String name, String description, List<City> cities, Continent continent) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cities = cities;
		this.continent = continent;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", description=" + description + ", cities=" + cities
				+ ", continent=" + continent + "]";
	}
	
	

}
