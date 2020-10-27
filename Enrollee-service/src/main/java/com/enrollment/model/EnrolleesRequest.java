package com.enrollment.model;

import java.util.List;

public class EnrolleesRequest {

	private String name;

	private boolean activationStatus;

	private String phoneNo;

	private List<DependentsRequest> dependents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<DependentsRequest> getDependents() {
		return dependents;
	}

	public void setDependents(List<DependentsRequest> dependents) {
		this.dependents = dependents;
	}

	
	
}
