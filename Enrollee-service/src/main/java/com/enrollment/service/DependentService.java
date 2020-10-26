package com.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.entity.Dependents;
import com.enrollment.repository.DependentsRepository;

@Service
public class DependentService {

	@Autowired
	private DependentsRepository dependentsRepository;

	public List<Dependents> update(List<Dependents> dependents, int id) {

		return dependentsRepository.saveAll(dependents);
	}

}
