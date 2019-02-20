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

		User user1 = userService.checkUser(username, password);
		session.setAttribute("uName", user1.getuName());
		session.setAttribute("uId", user1.getUserId());
		System.out.println(user1.getUserRole());
		return user1.getUserRole();
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
		
		int userId = (int) session.getAttribute("uId");
		System.out.println("ye user ID session se milla"+userId);
		User user = userService.findById(userId).get();
		
		List<Training> training = trainingService.findAll();
		System.out.println(training.toString());

		List<Training> activeTraining = new ArrayList<>();
		activeTraining.addAll(training);

		
		for (Training training2 : training) {
			try {
			if (training2.getTrainingStatus().equalsIgnoreCase("In-Active")||training2.getUsers().equals(user)) {
				activeTraining.remove(training2);
			}
			}
			catch (Exception e) {
				continue;
			}
		}
		
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", activeTraining);
		return "EnrollTraining";
	}

	@RequestMapping(value = "/addUserTraining")
	public String addUserTraining(@RequestParam("trainingId") int trainingId, HttpSession session) {
		System.out.println("UI se aaya training ID"+trainingId);
		Training training = trainingService.findById(trainingId).get();
		System.out.println("YE training milla..."+training.toString());

		int userId = (int) session.getAttribute("uId");
		System.out.println("ye user ID session se milla"+userId);
		User user = userService.findById(userId).get();
		System.out.println("ye user aaya..."+user.toString());

		Set<Training> taining1=new HashSet<>();
		taining1.add(training);
		user.setTrainings(taining1);
		userService.save(user);
		
		System.out.println("user mein training aaya..."+user.getTrainings().toString());
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
			
			Training training=trainingService.findById(trainingValue.getTrainingId()).get();
			System.out.println("ye training milla...."+training.toString());
			
			training.setTrainingName(trainingValue.getTrainingName());
			training.setTrainingStatus(trainingValue.getTrainingStatus());
			training.setTrainingAmount(trainingValue.getTrainingAmount());
			System.out.println("ye training set huwa..."+training.toString());
			trainingService.save(training);
			return "Admin";
		} catch (Exception e) {
			return "EditTraining";
		}
	}
	
	@RequestMapping(value = "/EditTrainingFeedback")
	public String showEditTrainingFeedbackPage(Model model) {
		List<Training> training = trainingService.findAll();
		System.out.println(training.toString());
		model.addAttribute("listOfTraining", training);
		return "EditTrainingFeedback";
	}
}
