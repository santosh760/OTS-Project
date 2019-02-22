package com.yash.onlinetrainingsystem.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_ots")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_ID")
	private int userId;
	
	@Column(name="Name")
	private String uName;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="User_Role")
	private String userRole;
	
	@Column(name="User_Password")
	private String password;
	
	@Column(name="User_Email")
	private String userEmail;
	
	@Column(name="User_Contact")
	private int userContact;
	
	@Column(name="User_Amount")
	private int userAmount;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserContact() {
		return userContact;
	}

	public void setUserContact(int userContact) {
		this.userContact = userContact;
	}

	public int getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(int userAmount) {
		this.userAmount = userAmount;
	}

	public User(int userId, String uName, String userName, String userRole, String password, String userEmail,
			int userContact, int userAmount,Set<Training> trainings) {
		super();
		this.userId = userId;
		this.uName = uName;
		this.userName = userName;
		this.userRole = userRole;
		this.password = password;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userAmount = userAmount;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uName=" + uName + ", userName=" + userName + ", userRole=" + userRole
				+ ", password=" + password + ", userEmail=" + userEmail + ", userContact=" + userContact
				+ ", userAmount=" + userAmount + "]";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
