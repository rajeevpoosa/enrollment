package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.enrollment.entity.Enrollees;
import com.enrollment.model.EnrolleesRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

@SpringBootTest
class EnrolleeServiceApplicationTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getEnrollList() throws Exception {
		String uri = "/enrollees/get-list-enrollees";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Enrollees[] productlist = super.mapFromJson(content, Enrollees[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void createEnrollment() throws Exception {
		String uri = "/enrollees";
		EnrolleesRequest product = new EnrolleesRequest();
		product.setName("Rajeev Poosa");
		product.setPhoneNo("913-636-3946");
		product.setActivationStatus(true);
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

	}

	@Test
	public void updateEnroll() throws Exception {
		String uri = "/enrollees/1";
		EnrolleesRequest product = new EnrolleesRequest();
		product.setName("Poosa");
		product.setPhoneNo("+1 913-636-3946");
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void deleteEnroll() throws Exception {
		String uri = "/enrollees/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}
}