package com.yash.onlinetrainingsystem.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Training")
public class Training {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int trainingId;
	private String trainingName;
	private String trainingStatus;
	private String trainingFeedback;
	private int trainingAmount;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Training_User", joinColumns = { @JoinColumn(name = "trainingId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trainingAmount;
		result = prime * result + ((trainingFeedback == null) ? 0 : trainingFeedback.hashCode());
		result = prime * result + trainingId;
		result = prime * result + ((trainingName == null) ? 0 : trainingName.hashCode());
		result = prime * result + ((trainingStatus == null) ? 0 : trainingStatus.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Training other = (Training) obj;
		if (trainingAmount != other.trainingAmount)
			return false;
		if (trainingFeedback == null) {
			if (other.trainingFeedback != null)
				return false;
		} else if (!trainingFeedback.equals(other.trainingFeedback))
			return false;
		if (trainingId != other.trainingId)
			return false;
		if (trainingName == null) {
			if (other.trainingName != null)
				return false;
		} else if (!trainingName.equals(other.trainingName))
			return false;
		if (trainingStatus == null) {
			if (other.trainingStatus != null)
				return false;
		} else if (!trainingStatus.equals(other.trainingStatus))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
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
