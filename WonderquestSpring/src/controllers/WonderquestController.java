package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.WonderquestDAO;
import entities.User;

@Controller
public class WonderquestController {
	
	@Autowired 
	private WonderquestDAO dao;
	
	@ResponseBody
	@RequestMapping("myAccount")
	public User user(@PathVariable String username, @PathVariable String password) {
		User user = dao.getUserByUsername(username, password);
		System.out.println(user);
		return user;
	}

}
