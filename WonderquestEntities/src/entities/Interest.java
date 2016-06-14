package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="INTEREST")
public class Interest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String fieldName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Interest() {
		
	}

	public Interest(int id, String fieldName, User user) {
		super();
		this.id = id;
		this.fieldName = fieldName;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Interest [id=" + id + ", fieldName=" + fieldName + ", user=" + user + "]";
	}
	

}
