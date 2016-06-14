package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.City;
import entities.Continent;
import entities.Country;
import entities.User;

public class JUnitTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("wonderquest");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	public void testUser() {
		User u = em.find(User.class, 1);
		assertEquals("test", u.getFname());
	}
	
//	@Test
//	public void testContinent() {
//		Continent c = em.find(Continent.class, 1);
//		assertEquals("North America", c.getName());
//	}
//	
//	@Test
//	public void testCountry() {
//		Country c = em.find(Country.class, 1);
//		assertEquals("usa", c.getName());
//	}
//	
//	@Test
//	public void testCity() {
//		City c = em.find(City.class, 2);
//		assertEquals("Phoenix", c.getName());
//	}
	
	

}
