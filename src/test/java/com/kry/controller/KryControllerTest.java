package com.kry.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kry.service.KryService;

@ExtendWith(MockitoExtension.class)
public class KryControllerTest {

	@InjectMocks
	KryController kryController;

	@Mock
	KryService kryService;

	@Test
	void testGetService() throws Exception {
		String result = "List of services";
		Mockito.when(kryService.fetchServices()).thenReturn(result);
		String response = kryController.getServices();
		assertNotNull(response);

	}

	@Test
	void testAddService() throws Exception {
		String name = "Test";
		String url = "http://www.kry.se";
		String result = "Test Service added Successfully";
		Mockito.when(kryService.save(url, name)).thenReturn(result);
		String response = kryController.addService(url, name);
		assertEquals(result, response);

	}

	@Test
	void testInvalidUrl() throws Exception {
		String name = "Test";
		String url = "//www.kry.se";
		String result = "Given URL is not valid";
		String response = kryController.addService(url, name);
		assertEquals(result, response);

	}

	@Test
	void testRemoveService() throws Exception {
		String name = "Test";
		String result = "Test Service Deleted Successfully";
		Mockito.when(kryService.removeService(name)).thenReturn(result);
		String response = kryController.removeService(name);
		assertThat(response).isEqualTo(result);

	}
}
