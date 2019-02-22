package com.yash.onlinetrainingsystem.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Training_ots")
public class Training{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Training_ID")
	private int trainingId;
	
	@Column(name="Training_Name")
	private String trainingName;
	
	@Column(name="Training_Status")
	private String trainingStatus;
	
	@Column(name="Training_Feedback")
	private String trainingFeedback;
	
	@Column(name="Training_Amount")
	private int trainingAmount;
	
	
	@ManyToMany(targetEntity = User.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "Training_User", 
				joinColumns = { @JoinColumn(name = "Training_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "User_ID") })
	private Set<User> users;

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public String getTrainingFeedback() {
		return trainingFeedback;
	}

	public void setTrainingFeedback(String trainingFeedback) {
		this.trainingFeedback = trainingFeedback;
	}

	public int getTrainingAmount() {
		return trainingAmount;
	}

	public void setTrainingAmount(int trainingAmount) {
		this.trainingAmount = trainingAmount;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	

	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingStatus="
				+ trainingStatus + ", trainingFeedback=" + trainingFeedback + ", trainingAmount=" + trainingAmount
				+ ", users=" + users + "]";
	}

	
	
	public Training(int trainingId, String trainingName, String trainingStatus, String trainingFeedback,
			int trainingAmount, Set<User> users) {
		super();
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trainingStatus = trainingStatus;
		this.trainingFeedback = trainingFeedback;
		this.trainingAmount = trainingAmount;
		this.users = users;
	}

	public Training() {
		// TODO Auto-generated constructor stub
	}
}
