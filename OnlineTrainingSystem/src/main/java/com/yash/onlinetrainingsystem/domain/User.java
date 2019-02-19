package com.yash.onlinetrainingsystem.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String uName;
	private String userName;
	private String userRole;
	private String password;
	private String userEmail;
	private int userContact;
	private int userAmount;
	private String userFeedback;

	@ManyToMany(mappedBy = "users")
	private Set<Training> trainings;

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

	public String getUserFeedback() {
		return userFeedback;
	}

	public void setUserFeedback(String userFeedback) {
		this.userFeedback = userFeedback;
	}

	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	public User(int userId, String uName, String userName, String userRole, String password, String userEmail,
			int userContact, int userAmount, String userFeedback, Set<Training> trainings) {
		super();
		this.userId = userId;
		this.uName = uName;
		this.userName = userName;
		this.userRole = userRole;
		this.password = password;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userAmount = userAmount;
		this.userFeedback = userFeedback;
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uName=" + uName + ", userName=" + userName + ", userRole=" + userRole
				+ ", password=" + password + ", userEmail=" + userEmail + ", userContact=" + userContact
				+ ", userAmount=" + userAmount + ", userFeedback=" + userFeedback + ", trainings=" + trainings + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((trainings == null) ? 0 : trainings.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + userAmount;
		result = prime * result + userContact;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFeedback == null) ? 0 : userFeedback.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (trainings == null) {
			if (other.trainings != null)
				return false;
		} else if (!trainings.equals(other.trainings))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (userAmount != other.userAmount)
			return false;
		if (userContact != other.userContact)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFeedback == null) {
			if (other.userFeedback != null)
				return false;
		} else if (!userFeedback.equals(other.userFeedback))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
