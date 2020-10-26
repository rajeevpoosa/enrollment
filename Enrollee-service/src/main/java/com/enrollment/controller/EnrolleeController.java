package com.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.entity.Enrollees;
import com.enrollment.model.DependentsRequest;
import com.enrollment.model.EnrolleesRequest;
import com.enrollment.service.EnrolleesService;

@RestController
@RequestMapping("/enrollees")
public class EnrolleeController {

	@Autowired
	private EnrolleesService enrolleesService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Enrollees saveEnrollee(@RequestBody EnrolleesRequest enrolleesRequest) {
		return enrolleesService.save(enrolleesRequest);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Enrollees updateEnrollee(@RequestBody EnrolleesRequest enrolleesRequest, @PathVariable int id) {
		return enrolleesService.update(enrolleesRequest, id);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Enrollees getEnrollee(@PathVariable int id) {
		return enrolleesService.getEnrollees(id).orElseGet(null);
	}

	@GetMapping(value = "/get-list-enrollees")
	@ResponseStatus(HttpStatus.OK)
	public List<Enrollees> getAllEnrollee() {
		return enrolleesService.getAll();
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEnrollee(@PathVariable int id) {
		enrolleesService.delete(id);
	}

	@PutMapping(value = "/update-dependents/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Enrollees updateDependents(@RequestBody List<DependentsRequest> dependentsRequest, @PathVariable int id) {
		return enrolleesService.updateDependents(dependentsRequest, id);
	}
}
