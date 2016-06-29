package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CONTINENT")
public class Continent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "continent")
	private List<Country> countries;
	
	public Continent() {
		
	}

	public Continent(int id, String name, String description, List<Country> countries) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.countries = countries;
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

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + ", description=" + description
				+ "]";
	}
	

}
