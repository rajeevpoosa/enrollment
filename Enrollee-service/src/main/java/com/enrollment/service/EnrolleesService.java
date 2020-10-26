package com.enrollment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.entity.Dependents;
import com.enrollment.entity.Enrollees;
import com.enrollment.model.DependentsRequest;
import com.enrollment.model.EnrolleesRequest;
import com.enrollment.repository.EnrolleesRepository;

@Service
public class EnrolleesService {

	@Autowired
	private EnrolleesRepository enrolleesRepository;

	public Enrollees save(EnrolleesRequest enrolleesRequest) {

		Enrollees enrollees = new Enrollees();

		BeanUtils.copyProperties(enrolleesRequest, enrollees);

		return enrolleesRepository.save(enrollees);
	}

	public Enrollees update(EnrolleesRequest enrolleesRequest, int id) {

		Enrollees enrollees = new Enrollees();

		BeanUtils.copyProperties(enrolleesRequest, enrollees);

		enrollees.setId(id);

		return enrolleesRepository.save(enrollees);
	}

	public Optional<Enrollees> getEnrollees(int id) {
		return enrolleesRepository.findById(id);
	}

	public List<Enrollees> getAll() {

		return enrolleesRepository.findAll();
	}

	public void delete(int id) {
		enrolleesRepository.deleteById(id);
	}

	public Enrollees updateDependents(List<DependentsRequest> dependentsRequest, int id) {
		List<Dependents> dependents = new ArrayList<Dependents>();
		dependentsRequest.forEach(dependent -> {
			Dependents dependentObj = new Dependents();
			BeanUtils.copyProperties(dependent, dependentObj);
			dependents.add(dependentObj);
		});
		Enrollees enrollees = enrolleesRepository.findById(id).get();
		enrollees.setDependents(dependents);

		return enrolleesRepository.save(enrollees);
	}
}
