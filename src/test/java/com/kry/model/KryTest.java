package com.kry.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class KryTest {

	@Test
	public void testKry() {
		Kry kry = new Kry();
		kry.setServiceName("Test");
		kry.setActive("OK");
		kry.setUrl("http://www.kry.se");
		assertEquals("Test", kry.getServiceName());
		assertTrue(kry.getUrl().equals("http://www.kry.se"));
		assertFalse(kry.getActive().equals("FAIL"));

	}
}
