package com.kry.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kry.model.Kry;
import com.kry.service.KryService;

@ExtendWith(MockitoExtension.class)
public class KryControllerTest {

	@InjectMocks
	KryController kryController;

	@Mock
	KryService kryService;

	@Test
	@Disabled
	void testGetService() throws Exception {
		List<Kry> result = new ArrayList<>();
		Kry kry = new Kry("test","http://www.kry.se","OK");
		result.add(kry);
		Mockito.when(kryService.fetchServices()).thenReturn(result);
		List<Kry> response = kryController.getServices();
		assertEquals(result,response);

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
