package com.kry.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kry.model.Kry;
import com.kry.repository.KryRepository;

@ExtendWith(MockitoExtension.class)
public class KryServiceImplTest {
	@InjectMocks
	private KryServiceImpl kryServiceImpl;
	@Mock
	private KryRepository kryRepository;

	@Test
	void testSave() {
		String name = "Test";
		String url = "http://www.kry.se/";
		String result = kryServiceImpl.save(url, name);
		assertNotNull(result);

	}

	@Test
	void testUpdateService() {
		String name = "Test";
		String url = "http://www.kry.se/";
		kryServiceImpl.updateService(name, url);
		Mockito.verify(kryRepository, times(1)).update(name, url);

	}

	@Test
	void testFetchServices() {
		String result = kryServiceImpl.fetchServices();
		assertNotNull(result);
		Mockito.verify(kryRepository, times(1)).findAll();

	}

	@Test
	void testNoServices() {
		String result = kryServiceImpl.fetchServices();
		assertThat(result).isEqualTo("No services available currently");
		Mockito.verify(kryRepository, times(1)).findAll();

	}

	@Test
	void testCheckConnection() {
		kryServiceImpl.checkConnection();
		Mockito.verify(kryRepository, times(1)).findAll();
	}

}
