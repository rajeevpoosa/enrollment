package com;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.enrollment.entity.Dependents;
import com.enrollment.repository.DependentsRepository;
import com.enrollment.service.DependentService;

@SpringBootTest
class DependentServiceTests extends AbstractTest {

	@InjectMocks
	private DependentService service;

	@Mock
	private DependentsRepository repository;

	@Test
	public void getEnrollList() throws Exception {
		List<Dependents> dependents = Arrays.asList(getDependents());
		Mockito.when(service.update(dependents, 1)).thenReturn(dependents);
		List<Dependents> dependentsList = service.update(dependents, 1);
		assertEquals(dependentsList.size(), dependents.size());
	}

	public Dependents getDependents() {
		Dependents dependent = new Dependents();
		dependent.setId(1);
		dependent.setName("test");
		dependent.setDateOfBirth(new Date());
		return dependent;
	}

}