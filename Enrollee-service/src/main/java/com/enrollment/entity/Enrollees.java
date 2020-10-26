package com.enrollment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Enrollees {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private boolean activationStatus;

	@Column
	private String phoneNo;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Dependents> dependents;

}
