package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.WonderquestDAO;
import entities.Trip;
import entities.User;

@Controller
@SessionAttributes({"user"})
public class WonderquestController {
	
//	@ModelAttribute("user")
//	private User setBlankCurrentUser() {
//		User user = new User();
//		return user;
//	}
	
	@Autowired 
	private WonderquestDAO dao;
	

//	@ResponseBody
//	@RequestMapping(value = "myAccount", method = RequestMethod.POST)
//	public User user(@RequestBody Credentials credentials) {
//		
//		System.out.println("USERNAME" + credentials.getUsername());
//		System.out.println("PASSWORD" + credentials.getPassword());
//		User user = dao.getUserByUsername(credentials.getUsername(), credentials.getPassword());
//		System.out.println(user);
//		return user;
//	}
	
	@RequestMapping("gettrips.do")
	public ModelAndView viewAllTrips(@RequestParam("id") String id) {
		List<Trip> allTrips = dao.getAllTrips();
		System.out.println(allTrips);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("allTrips", allTrips);
		return mv;
	}
	
	
	// sign a user in
	@RequestMapping("signin.do")
	public ModelAndView signIn(@RequestParam("username") String username, 
			@RequestParam("password") String password, HttpSession session) {
		System.out.println(username);
		System.out.println(password);
		User user = dao.getUserByUsername(username, password);
		System.out.println("This is what I have as the user" + user);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index.jsp");
		session.setAttribute("user", user);
		return mv;
	}
	
	@RequestMapping("viewSpecificTrip.do")
	public ModelAndView viewSpecificTrips(@RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("continent") String continent,
		@RequestParam("totalTripLength") String totalTripLength, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	
	// sign a user up
	@RequestMapping("signup.do")
	public ModelAndView addUserRegistration(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("gender") String gender, 
			@RequestParam("lname") String nationality, @RequestParam("lname") String emailAddress,
			@RequestParam("lname") String profImage, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//allArtists = dao.getAllArtists();

		//session.setAttribute("all", allArtists);
		if (username == "" || password == "" || emailAddress == "" || fname == "") {
			String error = "You're missing something important.";
			mv.addObject("valueMissing", error);
			System.out.println(error);
			mv.setViewName("index.jsp");
		} else {
			int addUserReturn = dao.addUser(username, password, fname, lname, gender, nationality, emailAddress, profImage);
			if (addUserReturn != 0) {
				String duplicateError = "This email already exists for another user.";
				mv.addObject("duplicateError", duplicateError);
				System.out.println(duplicateError);
				mv.setViewName("index1.jsp");

			} else {
				User user = dao.getUserByUsername(username, password);
				session.setAttribute("user", user);
				mv.setViewName("index.jsp");
			}
		}
		return mv;
	}
	
}
