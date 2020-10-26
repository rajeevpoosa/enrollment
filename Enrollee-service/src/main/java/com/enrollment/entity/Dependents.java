package com.enrollment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Dependents {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
	
	@Column
	private String name;
	
	@Column
	private Date dateOfBirth;


}
