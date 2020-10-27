package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.enrollment.entity.Enrollees;
import com.enrollment.model.EnrolleesRequest;
import com.enrollment.repository.EnrolleesRepository;
import com.enrollment.service.EnrolleesService;

@SpringBootTest
class EnrolleeServiceTests extends AbstractTest {

	@InjectMocks
	private EnrolleesService service;

	@Mock
	private EnrolleesRepository repository;

	@Test
	public void getEnrollList() throws Exception {
		List<Enrollees> enrolleesList = new ArrayList<Enrollees>();
		enrolleesList.add(getEnrollee());
		Mockito.when(service.getAll()).thenReturn(enrolleesList);
		List<Enrollees> productlist = service.getAll();
		assertTrue(productlist.size() > 0);
	}

	@Test
	public void createEnrollment() throws Exception {
		EnrolleesRequest product = new EnrolleesRequest();
		product.setName("Rajeev Poosa");
		product.setPhoneNo("913-636-3946");
		product.setActivationStatus(true);
		Mockito.when(service.save(product)).thenReturn(getEnrollee());
		Enrollees enrollees = service.save(product);
		assertEquals(enrollees.getName(), product.getName());

	}

	@Test
	public void updateEnroll() throws Exception {
		EnrolleesRequest product = new EnrolleesRequest();
		product.setName("Poosa");
		product.setPhoneNo("+1 913-636-3946");
		Mockito.when(service.update(product, 1)).thenReturn(getEnrollee());
		Enrollees enrollees = service.update(product, 1);
		assertEquals(enrollees.getId(), getEnrollee().getId());
	}

	@Test
	public void deleteEnroll() throws Exception {
		Mockito.doNothing().when(service).delete(1);
		service.delete(1);
		Mockito.verify(service, times(1)).delete(1);
	}

	public Enrollees getEnrollee() {
		Enrollees enrollee = new Enrollees();
		enrollee.setId(1);
		enrollee.setName("test");
		enrollee.setActivationStatus(false);
		return enrollee;
	}

}