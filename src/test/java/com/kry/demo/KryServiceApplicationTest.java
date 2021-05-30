package com.kry.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.kry.controller.KryController;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class KryServiceApplicationTest {

	@Autowired
	private KryController kryController;

	@Test
	public void contextLoads() {
		assertThat(kryController).isNotNull();
	}

}
