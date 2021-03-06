package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.WonderquestDAO;
import entities.City;
import entities.LegOfTrip;
import entities.Length;
import entities.TransportationTo;
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
	
	// get all the trips available 
	
	@RequestMapping("gettrips.do")
	public ModelAndView viewAllTrips(@RequestParam("id") String id) {
		List<Trip> allTrips = dao.getAllTrips();
		System.out.println(allTrips);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("allTrips", allTrips);
		return mv;
	}
	
	@RequestMapping("viewTrip.do")
	public ModelAndView viewSingleTrips(@RequestParam("tripId") String tripId) {
		Trip trip = dao.getTripById(Integer.parseInt(tripId));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("singleTrip.jsp");
		mv.addObject("trip", trip);
		return mv;
	}
	
	@RequestMapping("toTripBuild.do")
	public ModelAndView viewTripBuild(@RequestParam("tripId") String tripId) {
		Trip trip = dao.getTripById(Integer.parseInt(tripId));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tripBuild.jsp");
		mv.addObject("passedTrip", trip);
		mv.addObject("trip", trip);
		return mv;
	}
	
	// go to edit leg page 
//	@RequestMapping("editLeg.do") 
//	public ModelAndView editPage(@RequestParam("legId") String legId) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("tripBuild.jsp");
//		mv.addObject("leg", leg);
//		return mv;
//	}
	
	// figure out what to do here if someone isn't signed in 
	
	@RequestMapping("buildYourTrip.do")
	public ModelAndView buildTrip(@ModelAttribute("user") User user) {
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
			List<Trip> allTrips = dao.getAllTrips();
			System.out.println(allTrips);
			mv.setViewName("tripBuild.jsp");
			mv.addObject("user", user);
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
	
	
	// create a new trip 
	@RequestMapping("createTrip.do") 
	public ModelAndView createTrip(@RequestParam("tripName") String tripName, @ModelAttribute("user") User user, HttpSession session) {
		System.out.println(tripName);
		System.out.println(user);
		Trip trip = dao.createTrip(tripName, user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tripBuild.jsp");
		mv.addObject("passedTrip", trip);
		session.setAttribute("trip", trip);
		//mv.addObject("trip", trip);
		return mv;
	}
	
	// create a new leg for a trip
	@RequestMapping("addLeg.do") 
	public ModelAndView addLeg(@RequestParam("city") String city, @RequestParam("country") String country,
			@RequestParam("continent") String continent, @RequestParam("typeOfTransportation") String typeofTransportation,
			@RequestParam("time") String time, @RequestParam("length") String lengthDescription, 
			@RequestParam("tripId") String tripId, @ModelAttribute("user") User user,
			@RequestParam("description") String description) {
		Length lengthOfTrip = dao.getLengthByDescription(lengthDescription);
		City cityForTrip = dao.getCityForLegOfTrip(city, country, continent);
		LegOfTrip leg = dao.createLeg(Integer.parseInt(tripId), cityForTrip, lengthOfTrip, description);
		Trip passedTrip = dao.getTripById(Integer.parseInt(tripId));
		TransportationTo newTrans = dao.createTransportationTo(typeofTransportation, time, leg);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tripBuild.jsp");
		//mv.addObject("tripId", tripId);
		mv.addObject("leg", leg);
		mv.addObject("transportation", newTrans);
		mv.addObject("passedTrip", passedTrip);
		return mv;
		
	}
		
	
	
	// view specific trip legs that meet certain criteria 
	
	@RequestMapping("viewSpecificTrip.do")
	public ModelAndView viewSpecificTrips(@RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("continent") String continent,
		@RequestParam("totalTripLength") String totalTripLength, HttpSession session) {
		List<LegOfTrip> allMatchingLegs = dao.getAllMatchingTrips(city, country, continent, totalTripLength);
		System.out.println("All matching legs" + allMatchingLegs);
		ModelAndView mv = new ModelAndView();
		mv.addObject("allMatchingLegs", allMatchingLegs);
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
