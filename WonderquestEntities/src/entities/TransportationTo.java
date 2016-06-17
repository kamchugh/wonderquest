package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRANSPORTATION_TO")
public class TransportationTo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	private String time;
	
	private boolean recommended;
	
	@JoinColumn(name = "leg_of_trip_id")
	@ManyToOne
	private LegOfTrip legOfTrip;
	
	public TransportationTo() {
		
	}

	public TransportationTo(int id, String type, String time, boolean recommended, LegOfTrip legOfTrip) {
		super();
		this.id = id;
		this.type = type;
		this.time = time;
		this.recommended = recommended;
		this.legOfTrip = legOfTrip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isRecommended() {
		return recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public LegOfTrip getLegOfTrip() {
		return legOfTrip;
	}

	public void setLegOfTrip(LegOfTrip legOfTrip) {
		this.legOfTrip = legOfTrip;
	}

	@Override
	public String toString() {
		return "TransportationTo [id=" + id + ", type=" + type + ", time=" + time + ", recommended=" + recommended
				+ ", legOfTrip= taken out to avoid stack overflow]";
	}
	
	
	
	
}
