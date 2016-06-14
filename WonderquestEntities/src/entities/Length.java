package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LENGTH")

public class Length {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="time description")
	private String time_description;
	
	// missing foreign key connection here 
	
//	@OneToOne(mappedBy = "length")
//	private LegOfTrip legOfTrip;
//	
//	@OneToOne(mappedBy = "length")
//	private Trip trip;
	
	public Length() {
		
	}

	public Length(int id, String time_description) {
		super();
		this.id = id;
		this.time_description = time_description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime_description() {
		return time_description;
	}

	public void setTime_description(String time_description) {
		this.time_description = time_description;
	}

	@Override
	public String toString() {
		return "Length [id=" + id + ", time_description=" + time_description + "]";
	}
	
	
	
}
