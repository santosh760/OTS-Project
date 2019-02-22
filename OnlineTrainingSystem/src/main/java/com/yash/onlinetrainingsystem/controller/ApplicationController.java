package com.yash.onlinetrainingsystem.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.onlinetrainingsystem.domain.Training;
import com.yash.onlinetrainingsystem.domain.User;
import com.yash.onlinetrainingsystem.service.TrainingService;
import com.yash.onlinetrainingsystem.service.UserService;

@Controller
@Transactional
public class ApplicationController {

	@Autowired
	private UserService userService;

	@Autowired
	private TrainingService trainingService;

	@RequestMapping(value = { "/", "/showLogin" })
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLoginUser(@ModelAttribute User user, Model model, HttpSession session) {
		String username = user.getUserName();
		String password = user.getPassword();

		System.out.println("Called...CheckLogin..");
		System.out.println(username);
		System.out.println(password);

		try {
		User user1 = userService.checkUser(username, password);
		session.setAttribute("uName", user1.getuName());
		session.setAttribute("uId", user1.getUserId());
		System.out.println(user1.getUserRole());
		return user1.getUserRole();
		}
		catch (NullPointerException e) {
			return "UserRegistration"; 
		}
		
	}

	@RequestMapping(value = "/UserRegistration")
	public String showUserRegistrationPage() {
		return "UserRegistration";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		try {
			userService.save(user);
			return "login";
		} catch (Exception e) {
			return "UserRegistration";
		}
	}

	@RequestMapping(value = "/AddTraining")
	public String showAddTrainingPage() {
		return "AddTraining";
	}

	@RequestMapping(value = "/addTraining", method = RequestMethod.POST)
	public String addTraining(@ModelAttribute Training training) {
		try {
			trainingService.save(training);
			return "Admin";
		} catch (Exception e) {
			return "AddTraining";
		}
	}

	@RequestMapping(value = "/ViewUsers")
	public String showViewUsersPage(Model model) {
		List<User> users = userService.findAll();
		System.out.println(users.toString());
		model.addAttribute("listOfUsers", users);
		return "ViewUsers";
	}

	@RequestMapping(value = "/TrainingFeedback")
	public String showYrainingFeedbackPage(Model model) {
		List<Training> training = trainingService.findAll();
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", training);
		return "TrainingFeedback";
	}

	@RequestMapping(value = "/TraingStatus")
	public String showTraingStatusPage(Model model) {
		List<Training> training = trainingService.findAll();
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", training);
		return "TraingStatus";
	}

	@RequestMapping(value = "/EnrollTraining")
	public String showEnrollTrainingPage(Model model,HttpSession session) {

		List<Training> trainingMain = trainingService.findAll();
		System.out.println(trainingMain.toString());

		List<Training> activeTraining = new ArrayList<>();
		activeTraining.addAll(trainingMain);

		int userId = (int) session.getAttribute("uId");
		System.out.println("ye user ID session se milla" + userId);
		User user = userService.findById(userId).get();
		
		
		for (Training training : trainingMain) {
			try {
				if (training.getTrainingStatus().equalsIgnoreCase("In-Active")||training.getUsers().contains(user)) {
					activeTraining.remove(training);
				}
			} catch (Exception e) {
				continue;
			}
		}

		System.out.println(trainingMain.toString());
		model.addAttribute("listOfTraining", activeTraining);
		return "EnrollTraining";
	}

	@RequestMapping(value = "/addUserTraining")
	public String addUserTraining(@RequestParam("trainingId") int trainingId, HttpSession session) {
		
		Training trainingValue=trainingService.findById(trainingId).get();
		System.out.println("YE training milla..." + trainingValue.toString());

		int userId = (int) session.getAttribute("uId");
		System.out.println("ye user ID session se milla" + userId);
		User user = userService.findById(userId).get();
		System.out.println("ye user aaya..." + user.toString());
		
		int trainingAmount=trainingValue.getTrainingAmount();
		int userAmount=user.getUserAmount();
		
		if(userAmount==0) {
			user.setUserAmount(trainingAmount);
		}
		else {
			user.setUserAmount(userAmount+trainingAmount);
		}
		
		Set<User> user1=new HashSet<>();
		user1.add(user);
		
		trainingValue.setUsers(user1);
		trainingService.save(trainingValue);		

		System.out.println("user mein training aaya..." + trainingValue.toString());
		return "User";
	}

	@RequestMapping(value = "/EditTraining")
	public String showEditTrainingPage(Model model) {
		List<Training> training = trainingService.findAll();
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", training);
		return "EditTraining";
	}

	@RequestMapping(value = "/editTraining", method = RequestMethod.POST)
	public String editTraining(@ModelAttribute Training trainingValue) {
		try {

			Training training = trainingService.findById(trainingValue.getTrainingId()).get();
			System.out.println("ye training milla...." + training.toString());

			training.setTrainingName(trainingValue.getTrainingName());
			training.setTrainingStatus(trainingValue.getTrainingStatus());
			training.setTrainingAmount(trainingValue.getTrainingAmount());
			System.out.println("ye training set huwa..." + training.toString());
			trainingService.save(training);
			return "Admin";
		} catch (Exception e) {
			return "EditTraining";
		}
	}
	
	@RequestMapping(value = "/deleteTraining", method = RequestMethod.POST)
	public String editTraining(@RequestParam("trainingId") int trainingId) {
		try {

			trainingService.deleteById(trainingId);
			return "Admin";
		} catch (Exception e) {
			return "EditTraining";
		}
	}	

	
	
	@RequestMapping(value = "/EditTrainingFeedback")
	public String showEditTrainingFeedbackPage(Model model,HttpSession session) {
		List<Training> trainingMain = trainingService.findAll();
		System.out.println(trainingMain.toString());
		
		List<Training> activeTraining = new ArrayList<>();
		activeTraining.addAll(trainingMain);

		int userId = (int) session.getAttribute("uId");
		System.out.println("ye user ID session se milla" + userId);
		User user = userService.findById(userId).get();
		
		
		for (Training training : trainingMain) {
			try {
				if (training.getTrainingStatus().equalsIgnoreCase("In-Active")||training.getUsers().contains(user)) {
					activeTraining.remove(training);
				}
			} catch (Exception e) {
				continue;
			}
		}
		model.addAttribute("listOfTraining", activeTraining);
		return "EditTrainingFeedback";
	}

	@RequestMapping(value = "/editTrainingFeedback")
	public String editTrainingFeedbackPage(@RequestParam("trainingId") int trainingId,@RequestParam("trainingFeedback") String trainingFeedback) {
		Training training = trainingService.findById(trainingId).get();
		try {
		
		System.out.println(training.toString());
		
		String priviousFeedback = training.getTrainingFeedback();
		
		if (priviousFeedback.equals("")||priviousFeedback.equals(null)) {
			training.setTrainingFeedback(trainingFeedback);
		} else {
			training.setTrainingFeedback(priviousFeedback + " , " + trainingFeedback);
		}
		trainingService.save(training);
		System.out.println("Training UPDATED"+training.getTrainingFeedback());
		return "User";
		}
		catch (Exception e) {
			training.setTrainingFeedback(trainingFeedback);
			return "User";
		}
	}

}
