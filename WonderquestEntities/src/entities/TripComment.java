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
@Table(name="TRIP_COMMENT")
public class TripComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String body;
	
	@JoinColumn(name = "trip_id")
	@ManyToOne
	private Trip trip;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

}
