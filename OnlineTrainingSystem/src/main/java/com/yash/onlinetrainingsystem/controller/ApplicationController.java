package com.yash.onlinetrainingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yash.onlinetrainingsystem.domain.Training;
import com.yash.onlinetrainingsystem.domain.User;
import com.yash.onlinetrainingsystem.service.TrainingService;
import com.yash.onlinetrainingsystem.service.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value= {"/", "/showLogin"})
	public String showHomePage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String checkLoginUser(@ModelAttribute User user,Model model,HttpSession session) {
		String username=user.getUserName();
		String password=user.getPassword();
		
		System.out.println("Called...CheckLogin..");
		System.out.println(username);
		System.out.println(password);
		
		User user1=userService.checkUser(username,password);
		session.setAttribute("uName", user1.getuName());
		System.out.println(user1.getUserRole());
		return user1.getUserRole();
	}
	
	@RequestMapping(value="/UserRegistration")
	public String showUserRegistrationPage() {
		return "UserRegistration";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		try {
		userService.save(user);
		return "login";
		}
		catch (Exception e) {
			return "UserRegistration";
		}
	}
	
	@RequestMapping(value= "/AddTraining")
	public String showAddTrainingPage() {
		return "AddTraining";
	}
	
	@RequestMapping(value="/addTraining",method=RequestMethod.POST)
	public String addUser(@ModelAttribute Training training) {
		try {
		trainingService.save(training);
		return "Admin";
		}
		catch (Exception e) {
			return "AddTraining";
		}
	}
	
	@RequestMapping(value= "/ViewUsers")
	public String showViewUsersPage(Model model) {
		List<User> users=userService.findAll();
		System.out.println(users.toString());
		model.addAttribute("listOfUsers", users);
		return "ViewUsers";
	}
	
	@RequestMapping(value= "/TrainingFeedback")
	public String showYrainingFeedbackPage(Model model) {
		List<Training> training=trainingService.findAll();
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", training);
		return "TrainingFeedback";
	}
}
