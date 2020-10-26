package com.enrollment.model;

import java.util.List;

import lombok.Data;

@Data
public class EnrolleesRequest {

	private String name;

	private boolean activationStatus;

	private String phoneNo;

	private List<DependentsRequest> dependents;

}
