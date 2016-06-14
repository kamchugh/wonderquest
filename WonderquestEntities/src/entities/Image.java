package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMAGE")
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "leg_id")
	private LegOfTrip legOfTrip;
	
	public Image() {
		
	}

	public Image(int id, String imageUrl, LegOfTrip legOfTrip) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.legOfTrip = legOfTrip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LegOfTrip getLegOfTrip() {
		return legOfTrip;
	}

	public void setLegOfTrip(LegOfTrip legOfTrip) {
		this.legOfTrip = legOfTrip;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", imageUrl=" + imageUrl + ", legOfTrip=" + legOfTrip + "]";
	}
	
	

}
