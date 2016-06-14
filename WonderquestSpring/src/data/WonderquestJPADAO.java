package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Component
@Transactional

public class WonderquestJPADAO implements WonderquestDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public User getUserByUsername(String username, String password) {
		String search = "select u from User u WHERE u.username = '" + username + "'";
		User user;
		try {
			user = em.createQuery(search, User.class).getSingleResult();
		} catch (Exception e) {
			user = null;
			
		}
		return user;
	}
		
	

}
